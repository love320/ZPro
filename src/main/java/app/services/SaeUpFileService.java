package app.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.sina.sae.storage.SaeStorage;


@Service
public class SaeUpFileService {
	
	private SaeStorage ss = new SaeStorage("ynwykm23m4","33j4wz320miz44mw5yjx03yk3mwhmy4h211m45x1","zpro");//使用Storage存储
	
	public int upFile(String name,byte[] bytes){
		
		//复制文件到指定磁盘下
		/*try {
			FileCopyUtils.copy(bytes, new FileOutputStream("D:/del/"+(new Date()).getTime()+name));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		//使用upload方法上传到域为image下
		ss.write("upload",name,bytes);
		return 1;
	}
	
	public byte[] getFile(String name){
		return ss.read("upload", name);
	}

}
