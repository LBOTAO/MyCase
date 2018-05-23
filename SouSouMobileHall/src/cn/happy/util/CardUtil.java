package cn.happy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import cn.happy.entity.ConsumInfo;
import cn.happy.entity.MobileCard;
import cn.happy.entity.NetPackage;
import cn.happy.entity.ServicePackage;
import cn.happy.entity.SuperPackage;
import cn.happy.entity.TalkPackage;

/**
 * 工具类
 * 
 * @author liutao
 * @data 2018年5月23日 上午11:00:49
 */
public class CardUtil {

	// 已注册嗖嗖移动用户列表
	public static Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
	// 所有卡号的消费记录列表
	public static Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();

	/**
	 * 登录
	 * 
	 * @param number
	 * @param pwd
	 * @return
	 */
	public boolean isLogin(String number, String pwd) {

		if (cards.containsKey(number) && (cards.get(number).getPassWord().equals(pwd))) {
			System.out.println("登录成功！");
		} else {
			System.out.println("登录失败！");

		}
		return false;
	}

	/**
	 * 用户初始化
	 */
	public void intitScene() {
		MobileCard hl = new MobileCard("15815891967", "小西瓜", "123456", new TalkPackage(), 88, 100, 89, 88, 90); // 话唠套餐
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
	 */
	public void addCard(MobileCard card) {
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

}
