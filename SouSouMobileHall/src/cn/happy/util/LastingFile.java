package cn.happy.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import cn.happy.entity.MobileCard;

/** 
 * @author liutao
 * @data 2018年5月28日 上午8:16:16
 */
public class LastingFile {
	/**
	 * 序列化
	 * 
	 * @param card
	 * @throws Exception
	 */
	public void objectOutPutFile(MobileCard card) throws Exception {

		OutputStream os = new FileOutputStream("cardUser.bin");
		ObjectOutputStream oos = new ObjectOutputStream(os);

		oos.writeObject(card);

		oos.close();
		os.close();
	}

	/**
	 * 反序列化
	 * @return
	 * @throws Exception
	 */
	public ArrayList objecInputFile() throws Exception {
		List<MobileCard> list = new ArrayList<>();
		InputStream is = new FileInputStream("cardUser.bin");
		ObjectInputStream ois = new ObjectInputStream(is);

		MobileCard cards = (MobileCard) ois.readObject();
		list.add(cards);
		ois.close();
		is.close();
		return (ArrayList) list;
	}
}
