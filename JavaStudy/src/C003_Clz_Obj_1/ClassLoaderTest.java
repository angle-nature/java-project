package C003_Clz_Obj_1;

import java.net.URL;

/**
 * project_name: Java_Ex
 *
 * package_name: C003_Clz_Obj_1 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-28 ÉÏÎç9:14:05 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: ClassLoaderTest.java  
 *
 * Description: ×Ö½ÚÂë¼ÓÔØÆ÷²âÊÔ³ÌĞò 
 *
 */
public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println(System.getProperty("sun.boot.class.path"));  
	    System.out.println(System.getProperty("user.dir"));
	    System.out.println(System.getProperty("file.separator"));  
	    testClassLoader();
		//testClassPath();
	}
	
	public static void testClassPath(){		
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();  
		for (int i = 0; i < urls.length; i++) {  
		    System.out.println(urls[i].toExternalForm());  
		}
	}
	
	public static void testClassLoader(){		
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();  
        while(loader != null) {  
            System.out.println(loader.getClass().getName());  
            loader = loader.getParent();  
        }  
	}

}


 