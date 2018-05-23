package cn.happy.biz;

import java.util.Scanner;

import cn.happy.entity.MobileCard;
import cn.happy.entity.ServicePackage;
import cn.happy.util.CardUtil;

/**
 * 业务类
 * @author liutao
 * @data 2018年5月23日 上午11:07:10
 */
public class SosoMgr {
	CardUtil cardUtil=new CardUtil();
	Scanner input=new Scanner(System.in);
	//实例化soso移动卡类
	MobileCard mobileCard=new MobileCard();
	ServicePackage service=null;
	public static void main(String[] args) {
		SosoMgr mar=new SosoMgr();
		mar.paintMainMenu();
	}
	/**
	 * 打印主菜单
	 */
	public void paintMainMenu(){
		//初始化
		cardUtil.intitScene();
		System.out.println("\n*******************欢迎使用嗖嗖移动业务大厅******************");
		System.out.println("1.用户登录   2.用户注册    3.使用嗖嗖   4.话费注册    5.资费说明   6.退出系统 ");
		System.out.println("请选择：");
		int menuChoose = input.nextInt();
		switch (menuChoose) {
		case 1:
			//登录
			System.out.println("现在处于用户登录");
			cardMenu();
			rerurnMenu();
			break;
		case 2:
			//注册
			System.out.println("现在处于用户注册");
			registCard();
			rerurnMenu();
			break;
		case 3:
			//使用嗖嗖
			System.out.println("现在处于使用嗖嗖");
			rerurnMenu();
			break;
		case 4:
			//话费充值
			System.out.println("现在处于话费充值");
			rerurnMenu();
			break;
		case 5:
			//资费说明
			System.out.println("现在处于资费说明");
			rerurnMenu();
			break;
		case 6:
			//退出
			System.out.println("您已经退出了嗖嗖移动业务大厅，感谢使用！");
			break;
		default:
			break;
		}
	}

	public void rerurnMenu(){
		System.out.println("输入0返回");
		int userInput = input.nextInt();
		while (userInput!=0) {
			System.out.println("输入错误  ，请你重新输入！！");
			userInput=input.nextInt();
		}
		paintMainMenu();  //调用主菜单
	}
	
	 /** 
     * 用户注册流程 
     */  
    public void registCard() {  
    	   System.out.println("************可选择的卡号************");  
           
           String[] cardNumbers = cardUtil.getNewNumber(9);  
           for (int i = 0; i <cardNumbers.length; i++) {  
               System.out.print((i+1)+":"+cardNumbers[i]+"\t");  
               if (2==i ||5==i||8==i) {  
                   System.out.println();  
               }
           }  
           System.out.println("请选择卡号(输入1~9的序号)：");  
           int key = input.nextInt();  
             
           if (key >= 1 && key <= 9) {  
               mobileCard.setCardNumber(cardNumbers[key - 1]);  
               System.out.println("1.话唠套餐  2.网虫套餐  3.超人套餐 ， 请选择套餐（输入序号）:");  
           } else {  
               System.out.print("输入错误！请输入（1~9）的整数:");     //表示输入错误
           }  
             
           boolean bol = true;  
         
           int packageNum = input.nextInt();  
           while (bol) {  
               if (packageNum<=3 && packageNum>=1) {  
                   service= cardUtil.createPackage(packageNum);  
                     mobileCard.setSerPackage(service);  //  
                   bol = false;  
               } else {  
                   System.out.println("输入错误，请重新选择：");  
                   packageNum = input.nextInt();  
               }  
           }  
             
           System.out.println("请输入姓名：");  
           String userName =  input.next();  
           System.out.println("请输入密码：");  
           String passWord = input.next();  
           System.out.println("请输入预存话费：");  
           double money=input.nextInt();  
           while (money<service.getPrice()) {  
               System.out.println("您预存话费金额不足以支付本月固定套餐资费，请重新充值：");  
               money=input.nextInt();  
          }  
           //当前输入的余额减去月租  
           mobileCard.setMoney(money-service.getPrice());  
           //注册新用户添加到集合  
           MobileCard card=new MobileCard(mobileCard.getCardNumber(), userName, passWord,mobileCard.getSerPackage(),mobileCard.getMoney());    
           cardUtil.addCard(card);  
           card.showMeg();  
       }  
    
    /** 
     * 二级菜单 
     */  
    public void cardMenu() {  
        System.out.println("请输入手机卡号：");  
        String number=input.next();  
        System.out.println("请输入密码：");  
        String pwd=input.next();  
        if (cardUtil.isExistCard(number,pwd)) {  
            System.out.println("登录成功");  
        }else {  
            return;  
        }  
  
        System.out.println("******嗖嗖移动用户菜单******");  
        System.out.println("1.本月账单查询");  
        System.out.println("2.套餐余量查询");  
        System.out.println("3.打印消费详单");  
        System.out.println("4.套餐变更");  
        System.out.println("5.办理退网");  
        System.out.print("请选择(输入1~5选择功能,其他键返回上一级)：");  

 
    }  
  
    
}
