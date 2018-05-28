package cn.happy.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import cn.happy.entity.ConsumInfo;
import cn.happy.entity.MobileCard;
import cn.happy.entity.NetPackage;
import cn.happy.entity.Scene;
import cn.happy.entity.ServicePackage;
import cn.happy.entity.SuperPackage;
import cn.happy.entity.TalkPackage;
import cn.happy.service.CallService;
import cn.happy.service.SendService;

/**
 * 工具类
 * 
 * @author liutao
 * @data 2018年5月23日 上午11:00:49
 */
public class CardUtil {
	Scanner input = new Scanner(System.in);
	
    static LastingFile obj=new LastingFile();
	// 已注册嗖嗖移动用户列表
	public static Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
	// 所有卡号的消费记录列表
	public static Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();

	public void init() throws Exception{
		ArrayList<MobileCard> list = obj.objecInputFile();
		
		for (MobileCard item : list) {
			cards.put(item.getCardNumber(), item);
		}
	}
	
	
	// 使用场景列表
	Map<Integer, Scene> scenes = new HashMap<Integer, Scene>();

	Scene scene0 = new Scene("通话", 90, "问候客户，谁知其如此难缠，通话90分钟");
	Scene scene1 = new Scene("通话", 30, "询问妈妈身体状况，本地通话30分钟");
	Scene scene2 = new Scene("短信", 5, "参与环境保护实施方案问卷调查，发送短信5条");
	Scene scene3 = new Scene("短信", 50, "通知朋友手机换号，发送短信50条");
	Scene scene4 = new Scene("上网", 1024, "和女朋友用微信视频聊天，使用流量1GB");
	Scene scene5 = new Scene("上网", 2 * 1024, "晚上手机在线看韩剧，不留神睡着啦！使用2GB");

	/**
	 * 登录
	 * 
	 * @param number
	 * @param pwd
	 * @return
	 * @throws Exception 
	 */
	public boolean isLogin(String number, String pwd) throws Exception {

		if (cards.containsKey(number) && (cards.get(number).getPassWord().equals(pwd))) {
			return true;
		} else {
			System.out.println("登录失败！");

		}
		return false;
	}

	/**
	 * 用户初始化
	 */
	public void intitScene() {
		MobileCard hl = new MobileCard("15815891967", "小西瓜", "123456", new TalkPackage(), 88, 50, 89, 88, 90); // 话唠套餐
		MobileCard wc = new MobileCard("12345678910", "大榴莲", "123456", new NetPackage(), 99, 200, 200, 60, 20); // 网虫套餐
		MobileCard cr = new MobileCard("13812345678", "红樱桃", "123456", new SuperPackage(), 100, 300, 50, 20, 900); // 超人套餐

		CardUtil.cards.put("15815891967", hl); // 添加到集合里
		CardUtil.cards.put("12345678910", wc); // 添加到集合里
		CardUtil.cards.put("13812345678", cr); // 添加到集合里

		ConsumInfo info = new ConsumInfo("12345678910", "电话", 500);

		List<ConsumInfo> list = new ArrayList<ConsumInfo>();
		list.add(info);
		consumInfos.put(info.getNumber(), list);

	}

	/**
	 * 注册新卡
	 * 
	 * @param card
	 * @throws Exception 
	 */
	public void addCard(MobileCard card) throws Exception {
		//cards.put(card.getCardNumber(), card);
		//每次注册序列化到本地
		obj.objectOutPutFile(card);
		//存进map
		cards.put(card.getCardNumber(), card);
	}

	/**
	 * 根据用户选择的套餐序列返回套餐对象
	 * 
	 * @param packId
	 *            套餐序列号
	 * @return
	 */
	public ServicePackage createPackage(int packId) {
		ServicePackage servicePackage = null;
		switch (packId) {
		case 1:
			servicePackage = new TalkPackage();
			break;
		case 2:
			servicePackage = new NetPackage();
			break;
		case 3:
			servicePackage = new SuperPackage();
			break;
		default:
			break;
		}
		return servicePackage;
	}

	/**
	 * 生成随机卡号
	 * 
	 * @return 随机卡号
	 */
	public String createNumber() {
		Random random = new Random();
		// 记录现有用户中是否存在此卡号用户 是：true 否：false
		boolean isExist = false;
		String number = "";
		int temp = 0;
		do {
			isExist = false;// 标志位重置为false,用于控制外重循环
			// 生成的随机数是8位，不能小于10000000，否则重新生成
			do {
				temp = random.nextInt(100000000);
			} while (temp < 10000000);
			// 生成之前，前面加“139”
			number = "139" + temp;
			// 和现有用户的卡号比较，不能是重复的
			if (cards != null) { // 价格判断 否则 下方的一句会报空指针异常
				Set<String> cardNumbers = cards.keySet();
				for (String cardNumber : cardNumbers) {
					if (number.equals(cardNumber)) {
						isExist = true;
						break;
					}
				}
			}
		} while (isExist);
		return number;
	}

	/**
	 * 生成指定个数卡号列表
	 * 
	 * @param count
	 * @return
	 */
	public String[] getNewNumber(int count) {
		String[] strs = new String[count];
		for (int i = 0; i < count; i++) {
			strs[i] = createNumber(); // 通过随机生成给strs[i]赋值
		}
		return strs;
	}

	/**
	 * 资费说明
	 * 
	 * @throws Exception
	 */
	public void showDescription() throws Exception {
		// 创建字符流对象
		FileReader reader = new FileReader("套餐资费说明.txt");
		// 创建一个缓冲区
		BufferedReader br = new BufferedReader(reader);
		// 读取一行数据
		String line = null;
		while ((line = br.readLine()) != null) { // line的下一行不为空 循环读取输出
			System.out.println(line.toString());
		}

		// 关闭资源
		br.close();
		reader.close();

	}

	/**
	 * 话费充值
	 * 
	 * @param number
	 * @param money
	 */
	public void recharge(String number, double money) {
		cards.get(number).setMoney(cards.get(number).getMoney() + money);
	}

	/**
	 * 是否存在该卡号 话费充值
	 * 
	 * @param number
	 * @return
	 */
	public boolean isExistenceNumber(String number) {
		
		Set<String> keySet = cards.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if (next.equals(number)) {
				return true;
			}

		}
		return false;
	}

	/**
	 * 本月账单查询
	 * 
	 * @param numberMoney
	 *            要查询的卡号
	 */
	public void findByMonthlyBill(String numberMoney) {
		/*MobileCard card = cards.get(numberMoney); // 集合中获取卡号
		System.out.println("您的卡号：" + card.getCardNumber() + ",当月账单\n套餐资费" + card.getSerPackage().getPrice() + "\n合计："
				+ card.getConsumAmout() + "\n套餐余额：" + card.getMoney());*/
		
		   StringBuffer meg = new StringBuffer();  
	        MobileCard card=cards.get(numberMoney);  //要查询的卡  
	        meg.append("您的卡号:"+card.getCardNumber()+"当月账单:\n");  
	        meg.append("套餐资费:"+card.getSerPackage().getPrice()+"元\n");  
	        meg.append("合计:"+Common.dataFormat(card.getConsumAmout())+"元\n");  
	        meg.append("账号余额:"+Common.dataFormat(card.getMoney())+"元");  
	        //显示本月消费详细信息  
	        System.out.println(meg); 
	}

	/**
	 * 套餐余量查询
	 * 
	 * @param numberMoney
	 *            要查询的卡号
	 */
	public void findByMealAllowance(String numberMoney) {
		MobileCard card = cards.get(numberMoney);
		System.out.println("您的卡号：" + card.getCardNumber() + ",套餐内剩余\n通话时长" + card.getRealTakTime() + "\n短信条数："
				+ card.getRealSMSCount() + "\n上网流量：" + card.getRealFlow());
	}

	/**
	 * 退网
	 * 
	 * @param numberMony
	 */
	public void exitNetWork(String numberMoney) {
		if (cards.containsKey(numberMoney)) {
			cards.remove(numberMoney);
			System.out.println("卡号" + numberMoney + "办理退网成功！");
			System.out.println("谢谢使用！");
		} else {
			System.out.println("输入错误，请重新输入。。");
		}
	}

	/**
	 * 套餐变更
	 * 
	 * @param number
	 */
	public void chargeingPack(String number) {
		System.out.println("1.话唠套餐 2.网虫套餐 3.超人套餐 ：请选择(序号)：");
		int packNum = input.nextInt();
		switch (packNum) {
		case 1: // 选择变更的套餐为话唠套餐 运行时指出对象是否是特定类的实例
			if (cards.get(number).getSerPackage() instanceof TalkPackage) {
				System.out.println("对不起，您已经是该套餐用户，无需换套餐！");
			} else {
				// 如果剩余金额小于套餐金额 提示信息
				if (cards.get(number).getMoney() < cards.get(number).getSerPackage().getPrice()) {
					System.out.println("对不起,您的的余额不足以支付新的套餐本月资费，请充值后再办理业务！");
				} else { // 否则更改成功
					cards.get(number).setRealSMSCount(0);
					cards.get(number).setRealTakTime(0);
					cards.get(number).setRealFlow(0);
					cards.get(number).setSerPackage(createPackage(packNum));
					System.out.println("套餐更换成功！");
					createPackage(packNum).showInfo();
				}
			}
			break;
		case 2: // 选择变更的套餐为网虫套餐 运行时指出对象是否是特定类的实例
			if (cards.get(number).getSerPackage() instanceof NetPackage) {
				System.out.println("对不起，您已经是该套餐用户，无需换套餐！");
			} else {
				// 如果剩余金额小于套餐金额 提示信息
				if (cards.get(number).getMoney() < cards.get(number).getSerPackage().getPrice()) {
					System.out.println("对不起,您的的余额不足以支付新的套餐本月资费，请充值后再办理业务！");
				} else { // 否则更改成功
					cards.get(number).setRealSMSCount(0);
					cards.get(number).setRealTakTime(0);
					cards.get(number).setRealFlow(0);
					cards.get(number).setSerPackage(createPackage(packNum));
					System.out.println("套餐更换成功！");
					createPackage(packNum).showInfo();
				}
			}
			break;
		case 3:// 选择变更的套餐为超人套餐 运行时指出对象是否是特定类的实例
			if (cards.get(number).getSerPackage() instanceof SuperPackage) {
				System.out.println("对不起，您已经是该套餐用户，无需换套餐！");
			} else {
				// 如果剩余金额小于套餐金额 提示信息
				if (cards.get(number).getMoney() < cards.get(number).getSerPackage().getPrice()) {
					System.out.println("对不起,您的的余额不足以支付新的套餐本月资费，请充值后再办理业务！");
				} else { // 否则更改成功
					cards.get(number).setRealSMSCount(0);
					cards.get(number).setRealTakTime(0);
					cards.get(number).setRealFlow(0);
					cards.get(number).setSerPackage(createPackage(packNum));
					System.out.println("套餐更换成功！");
					createPackage(packNum).showInfo();
				}
			}
			break;
		}
	}

	/**
	 * 套餐余量查询
	 * 
	 * @param number
	 */
	public void showRemainDetail(String number) {
		MobileCard card = cards.get(number);
		int remainTalkTime;
		int remainSmsCount;
		double remainFlow;
		StringBuffer meg = new StringBuffer();
		meg.append("您的卡号是" + number + ",套餐内剩余:\n");
		ServicePackage pack = card.getSerPackage();
		if (pack instanceof TalkPackage) {
			// 向下转型为话唠套餐对象
			TalkPackage cardPack = (TalkPackage) pack;
			// 话唠套餐，查询套餐内剩余的通话时长和短信条数
			remainTalkTime = cardPack.getTalkTime() > card.getRealTakTime()
					? cardPack.getTalkTime() - card.getRealTakTime() : 0;
			meg.append("通话时长:" + remainTalkTime + "分钟\n");
			remainSmsCount = cardPack.getSmsCount() > card.getRealSMSCount()
					? cardPack.getSmsCount() - card.getRealSMSCount() : 0;
			meg.append("短信条数:" + remainSmsCount + "条");
		} else if (pack instanceof NetPackage) {
			// 向下转型为网虫套餐的信息
			NetPackage netPackage = (NetPackage) pack;
			remainFlow = netPackage.getFlow() * 1024 > card.getRealFlow()
					? netPackage.getFlow() * 1024 - card.getRealFlow() : 0;
			meg.append("上网流量:" + Common.dataFormat(remainFlow / 1024) + "GB");
		} else {
			SuperPackage superPackage = (SuperPackage) pack;
			remainTalkTime = superPackage.getTalkTime() > card.getRealTakTime()
					? superPackage.getTalkTime() - card.getRealTakTime() : 0;
			meg.append("通话时长:" + remainTalkTime + "分钟\n");
			remainSmsCount = superPackage.getSmsCount() > card.getRealSMSCount()
					? superPackage.getSmsCount() - card.getRealSMSCount() : 0;
			meg.append("短信条数:" + remainSmsCount + "条");
			remainFlow = superPackage.getFlow() * 1024 > card.getRealFlow()
					? superPackage.getFlow() * 1024 - card.getRealFlow() : 0;
			meg.append("上网流量:" + Common.dataFormat(remainFlow / 1024) + "GB");
		}
		System.out.println(meg);
	}
	 /** 
     * 添加指定卡号的消费记录 
     *  
     * @param number 
     * @param info 
     */  
    public void addConsumInfo(String number, ConsumInfo info) {  
        if (consumInfos.containsKey(number)) {  
            consumInfos.get(number).add(info);  
        }else{  
            List<ConsumInfo> list = new ArrayList<ConsumInfo>();  
            list.add(info);  
            consumInfos.put(number, list);  
        }  
    }  
	  /** 
     * 使用搜搜 
     *  
     * @param number 
     */  
    public void userSoso(String number) {  
          
         //添加场景Map集合的键值对  
        scenes.put(0, scene0);  
        scenes.put(1, scene1);  
        scenes.put(2, scene2);  
        scenes.put(3, scene3);  
        scenes.put(4, scene4);  
        scenes.put(5, scene5);  
          
        MobileCard card=cards.get(number);  //获取此卡对象  
        ServicePackage pack=card.getSerPackage();   //获取此卡所属套餐  
        Random random=new Random();  
        int ranNum=0;  
        int temp=0; //记录个场景中实际消费  
        do {  
            ranNum=random.nextInt(6);  
            Scene scene=scenes.get(ranNum); //获取该序号所对应的场景  
            switch (ranNum) {  
            case 0:  
            case 1:  
                //序号为0或1为通话场景  
                //判断该卡所属套餐是否支持通话功能  
                if (pack instanceof CallService) {  
                    //执行通话方法  
                    System.out.println(scene.getDescription());  
                    CallService callService=(CallService)pack;  
                    try {  
                        temp=callService.call(scene.getData(), card);  
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }  
                    //添加一条消费记录  
                    addConsumInfo(number, new ConsumInfo(number, scene.getType(), temp));  
                    break;  
                }else {  
                    //如果该卡套餐不支持通话功能，则重新生成随机数选择其他场景  
                    continue;  
                }  
            case 2:  
            case 3:  
                //判断该卡所属套餐是否支持短信功能  
                if (pack instanceof SendService) {  
                    //执行短信方法  
                    System.out.println(scene.getDescription());  
                    SendService sendService=(SendService)pack;  
                    try {  
                        temp=sendService.send(scene.getData(), card);  
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }  
                    //添加一条消费记录  
                    addConsumInfo(number, new ConsumInfo(number, scene.getType(), temp));  
                    break;  
                }else {  
                    //如果该卡套餐不支持通话功能，则重新生成随机数选择其他场景  
                    continue;  
                }  
            case 4:  
            case 5:  
                //判断该卡所属套餐是否支持上网功能  
                if (pack instanceof NetPackage) {  
                    //执行上网方法  
                    System.out.println(scene.getDescription());  
                    NetPackage netPackage=(NetPackage)pack;  
                    try {  
                        temp=netPackage.netPlay(scene.getData(), card);  
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }  
                    //添加一条消费记录  
                    addConsumInfo(number, new ConsumInfo(number, scene.getType(), temp));  
                    break;  
                }else {  
                    //如果该卡套餐不支持通话功能，则重新生成随机数选择其他场景  
                    continue;  
                }  
            }  
            break;  
        } while (true);  
          
    }
    /** 
     * 打印消费详单 
     * @param number 
     */  
    public void printList(String number){     
        Writer fileWriter = null;  
        try {  
            fileWriter = new FileWriter("consumes.txt");  
            Set<String> numbers = consumInfos.keySet();  
            Iterator<String> it = numbers.iterator();  
            List<ConsumInfo> infos = new ArrayList<ConsumInfo>();  
            infos = consumInfos.get(number);  
            //存储指定卡的所有消费记录  
            //现有消费列表中是否存在此卡号的消费记录，是：true 否：false  
            boolean isExist = false;  
            while(it.hasNext()){  
                String numberKey = it.next();  
                if(number.equals(numberKey)){  
                    isExist = true;  
                }
 
            }  
              
            if(isExist){  
                StringBuffer content = new StringBuffer("***********" + number + "消费记录************\n");  
                content.append("序号\t类型\t数据（通话（分钟）/上网（MB）/短信（条））\n");  
                for(int i = 0; i < infos.size(); i++){  
                    ConsumInfo info = infos.get(i);  
                    System.out.println((i + 1) + ".\t" + info.getType() + "\t" + info.getConsumData() + "\n");  
                    content.append((i + 1) + ".\t" + info.getType() + "\t" + info.getConsumData() + "\n");  
                }  
                fileWriter.write(content.toString());  
                fileWriter.flush();  
                System.out.println("消息记录打印完毕！");  
            }else{  
                System.out.println("对不起，不存在此号码的消费记录，不能够打印！");  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                fileWriter.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
