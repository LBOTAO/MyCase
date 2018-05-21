package cn.happy.day07.demo5;

/**
 * @author liutao
 * @data 2018年5月18日 下午2:45:09
 */
public class Producer implements Runnable {

	private Movie movie=null;
	private boolean flag=false;
	
	
	/**
	 * @param movie
	 */
	public Producer(Movie movie) {
		super();
		this.movie = movie;
	}


	@Override
	public void run() {
		//循环录入50遍电影数据  两部电影交替录入
		for (int i = 0; i <=50; i++) {
			if (flag) {
				this.movie.set("变形金刚","一部科幻电影");
				flag=false;
			}else {
				this.movie.set("神偷奶爸", "一部3d电影");
				flag=true;
			}
		}
	}

}
