package cn.happy.day06.demo4;


/**
 * @author liutao
 * @data 2018年5月14日 下午4:01:34
 */
public class Queue {

	public static void main(String[] args) {
		
		 /* LinkedList list = new LinkedList(); list.addFirst("1");
		  list.addFirst("2"); list.addFirst("3"); System.out.println(list);
		  System.out.print(list.removeLast());
		  System.out.print(list.removeLast());*/
		 
		try {
			int[] arr = new int[5];
			for (int i = 0; i < 8; i++) {
				System.out.println(arr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		

	}

}