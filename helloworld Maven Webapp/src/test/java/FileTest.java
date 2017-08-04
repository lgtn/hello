import hello.util.FileUtil;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class FileTest {
	
	@Test
	public void test(){
		
		File file = new File("D:/QQ文件/237961657/FileRecv/唐山银行柜面日志.txt");
		
		try {
			String content = FileUtil.readFile(file);
			System.out.println(content.getBytes("GBK").length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
