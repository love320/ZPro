package app.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.sina.sae.storage.SaeStorage;


@Service
public class SaeUpFileService {
	
	private static Logger logger = Logger.getLogger(SaeUpFileService.class.getName());
	
	private String accessKey = "ynwykm23m4";
	private String secretKey = "33j4wz320miz44mw5yjx03yk3mwhmy4h211m45x1";
	private String appName = "zpro";
	private String domain = "upload";
	
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
		SaeStorage storage = new SaeStorage(accessKey,secretKey,appName);
		storage.write(domain, name, bytes);
		return storage.getErrno();
	}
	
	public byte[] getFile(String name){
		logger.info(name+" Get File Ok.");
		SaeStorage storage = new SaeStorage(accessKey,secretKey,appName);
		return storage.read(domain, name);
	}

}
