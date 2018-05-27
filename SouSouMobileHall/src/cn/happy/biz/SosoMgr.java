package cn.happy.biz;

import java.util.Scanner;

import cn.happy.entity.MobileCard;
import cn.happy.entity.ServicePackage;
import cn.happy.util.CardUtil;

/**
 * 业务类
 * 
 * @author liutao
 * @data 2018年5月23日 上午11:07:10
 */
public class SosoMgr {
	CardUtil cardUtil = new CardUtil();
	Scanner input = new Scanner(System.in);
	// 实例化soso移动卡类
	MobileCard mobileCard = new MobileCard();
	ServicePackage service = null;

	public static void main(String[] args) throws Exception {
		SosoMgr mar = new SosoMgr();
		mar.paintMainMenu();
	}

	/**
	 * 打印主菜单
	 * 
	 * @throws Exception
	 */
	public void paintMainMenu() throws Exception {
		// 初始化
		cardUtil.intitScene();
		System.out.println("\n*******************欢迎使用嗖嗖移动业务大厅******************");
		System.out.println("1.用户登录   2.用户注册    3.使用嗖嗖   4.话费充值    5.资费说明   6.退出系统 ");
		System.out.println("请选择：");
		int menuChoose = input.nextInt();
		switch (menuChoose) {
		case 1:
			cardMenu();
			rerurnMenu();
			break;
		case 2:
			// 注册
			System.out.println("现在处于用户注册");
			registCard();
			rerurnMenu();
			break;
		case 3:
			// 使用嗖嗖
			System.out.println("现在处于使用嗖嗖");
			System.out.println("请输入手机卡号:");
			String number = input.next();
			cardUtil.userSoso(number); // 调用使用soso
			rerurnMenu();
			break;
		case 4:
			// 话费充值
			System.out.println("现在处于话费充值");
			moneyRecharge();
			rerurnMenu();
			break;
		case 5:
			// 资费说明
			System.out.println("现在处于资费说明");
			try {
				cardUtil.showDescription();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rerurnMenu();
			break;
		case 6:
			// 退出
			System.out.println("您已经退出了嗖嗖移动业务大厅，感谢使用！");
			break;
		default:
			break;
		}
	}

	public void rerurnMenu() throws Exception {
		System.out.println("输入0返回");
		int userInput = input.nextInt();
		while (userInput != 0) {
			System.out.println("输入错误  ，请你重新输入！！");
			userInput = input.nextInt();
		}
		paintMainMenu(); // 调用主菜单
	}

	/**
	 * 用户注册流程
	 */
	public void registCard() {
		System.out.println("************可选择的卡号************");

		String[] cardNumbers = cardUtil.getNewNumber(9);
		for (int i = 0; i < cardNumbers.length; i++) {
			System.out.print((i + 1) + ":" + cardNumbers[i] + "\t");
			if (2 == i || 5 == i || 8 == i) {
				System.out.println();
			}
		}
		System.out.println("请选择卡号(输入1~9的序号)：");
		int key = input.nextInt();

		if (key >= 1 && key <= 9) {
			mobileCard.setCardNumber(cardNumbers[key - 1]);
			System.out.println("1.话唠套餐  2.网虫套餐  3.超人套餐 ， 请选择套餐（输入序号）:");
		} else {
			System.out.print("输入错误！请输入（1~9）的整数:"); // 表示输入错误
		}

		boolean bol = true;

		int packageNum = input.nextInt();
		while (bol) {
			if (packageNum <= 3 && packageNum >= 1) {
				service = cardUtil.createPackage(packageNum);
				mobileCard.setSerPackage(service); //
				bol = false;
			} else {
				System.out.println("输入错误，请重新选择：");
				packageNum = input.nextInt();
			}
		}

		System.out.println("请输入姓名：");
		String userName = input.next();
		System.out.println("请输入密码：");
		String passWord = input.next();
		System.out.println("请输入预存话费：");
		double money = input.nextInt();
		if (!(money >= 50)) {
			System.out.println("至少充值50元及以上资费！");

		} else {
			while (money < service.getPrice()) {
				System.out.println("您预存话费金额不足以支付本月固定套餐资费，请重新充值：");
				money = input.nextInt();
			}
			// 当前输入的余额减去月租
			mobileCard.setMoney(money - service.getPrice());
			// 注册新用户添加到集合
			MobileCard card = new MobileCard(mobileCard.getCardNumber(), userName, passWord, mobileCard.getSerPackage(),
					mobileCard.getMoney());
			cardUtil.addCard(card);
			card.showMeg();
		}

	}

	/**
	 * 二级菜单
	 * 
	 * @throws Exception
	 */
	public void cardMenu() throws Exception {
		System.out.println("请输入手机卡号：");
		String numberMoney = input.next();
		System.out.println("请输入密码：");
		String pwd = input.next();
		if (cardUtil.isLogin(numberMoney, pwd)) {
			System.out.println("登录成功");
		} else {
			return;
		}

		System.out.println("******嗖嗖移动用户菜单******");
		System.out.println("1.本月账单查询");
		System.out.println("2.套餐余量查询");
		System.out.println("3.打印消费详单");
		System.out.println("4.套餐变更");
		System.out.println("5.办理退网");
		System.out.print("请选择(输入1~5选择功能,其他键返回上一级)：");
		int key = input.nextInt();
		switch (key) {
		case 1:
			System.out.println("进入本月账单查询======");
			cardUtil.findByMonthlyBill(numberMoney);
			break;
		case 2:
			System.out.println("套餐余量查询=========");
			cardUtil.showRemainDetail(numberMoney);
			break;
		case 3:
			System.out.println("打印消费详单=========");
			cardUtil.printList(numberMoney);
			break;
		case 4:
			System.out.println("套餐变更=========");
			cardUtil.chargeingPack(numberMoney);
			break;
		case 5:
			System.out.println("办理退网=========");
			cardUtil.exitNetWork(numberMoney);
			break;
		default:

		}

	}

	/**
	 * 话费充值方法
	 */
	public void moneyRecharge() {
		System.out.println("请输入手机卡号：");
		String strNum = input.next();
		boolean is = cardUtil.isExistenceNumber(strNum);
		if (is) {
			System.out.println("请输入充值余额：");
			double strMoney = input.nextDouble();
			cardUtil.recharge(strNum, strMoney);
			System.out.println("充值成功,当前话费余额为" + CardUtil.cards.get(strNum).getMoney() + "元");
		} else {
			System.out.println("手机输入有误，请重新输入手机号：");
		}
	}

}
