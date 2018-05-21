package cn.happy.day07.demo5;

/**
 * @author liutao
 * @data 2018年5月18日 下午2:43:18
 */
public class Consumer implements Runnable{

	private Movie movie=null;
	
	/**
	 * @param movie
	 */
	public Consumer(Movie movie) {
		super();
		this.movie = movie;
	}

	@Override
	public void run() {
		//循环显示50次电影信息
		for (int i = 0; i <=50; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.movie.get();
		}
	}

}
