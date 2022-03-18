package C003_Clz_Obj_1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * project_name: Java_Ex
 *
 * package_name: C003_Clz_Obj_1 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-28 上午10:10:13 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: MyClassLoader.java  
 *
 * Description:  
 *
 */
public class MyClassLoader extends ClassLoader{

	private String rootUrl;

	public MyClassLoader(String rootUrl) {
		this.rootUrl = rootUrl;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class clazz = null;		
		byte[] classData = getClassData(name); // 读取字节码文件存入字节数组
		if (classData == null) {
			throw new ClassNotFoundException();
		}
		clazz = defineClass(name, classData, 0, classData.length); // 字节码数组转换成Class类的实例
		return clazz;
	}

	private byte[] getClassData(String name) {
		InputStream is = null;
		try {
			String path = classNameToPath(name);
			URL url = new URL(path);
			byte[] buff = new byte[1024*4];
			int len = -1;
			is = url.openStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while((len = is.read(buff)) != -1) {
				baos.write(buff,0,len);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
			   try {
			      is.close();
			   } catch(IOException e) {
			      e.printStackTrace();
			   }
			}
		}
		return null;
	}

	private String classNameToPath(String name) {
		return rootUrl + "/" + name.replace(".", "/") + ".class";
	}
	
	@SuppressWarnings({ "rawtypes","unchecked"})
	public static void main(String[] args) throws Exception {
		MyClassLoader mClassLoader = new MyClassLoader("");
		Class c = mClassLoader.loadClass("C003_Clz_Obj_1.Employee");
		Object o =c.newInstance();
		System.out.println(o.toString());
		
		Employee ee = (Employee) o;
		System.out.println(ee.getName());
		
		Method getName = c.getMethod("getName");
		System.out.println(getName.invoke(ee));
	}

}


 