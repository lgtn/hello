package hello.util;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.FileCopyUtils;

/**
 * 使用spring的文件操作类
 * 
 * FileCopyUtils -- 封装了一些文件的操作<br>
 * StreamUtils  ----<br>
 * 使用默认的4M缓冲区， 文件超过4M后，缓冲区会增长<br>
 * @author TL
 *
 */
public class FileUtil {

	public static String readFile(File file) throws Exception{
		
		byte[] byte_array = FileCopyUtils.copyToByteArray(file);
		
		//默认使用GBK编码
		String content = new String(byte_array,"GBK");
		
		return content;
	}
	
	public static String readFile(String path,String fileName) throws Exception{
		
		File file = new File(path, fileName);
		
		if(!file.exists()){
			throw new FileNotFoundException(fileName);
		}
		
		return readFile(file);
	}
	
	public static void copyFile(File ori,File des) throws Exception{
		FileCopyUtils.copy(ori, des);
	}
	
	public static void writeFile(String content,File out) throws Exception{
		
		byte[] in = content.getBytes("GBK");
		
		if(!out.exists()){
			throw new FileNotFoundException(out.getName());
		}
		
		FileCopyUtils.copy(in, out);
	}
}
