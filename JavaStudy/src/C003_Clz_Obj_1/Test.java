package C003_Clz_Obj_1;
/**  

 * Created Time：2013-11-13 上午8:51:30  

 * Project Name：Ex.Proj  

 * @author DarlingKe  

 * @version 1.0   

 * @since JDK 1.7.0_15  

 * FileName：Test.java  

 * Description：  

 */
public class Test {

	/**
	
	 * <p>Title: main</p>
	
	 * <p>Description: </p>
	
	 * @param args
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=new String("ab");//或者是String str="ab";  
	    setString(str);  
	    System.out.println(str);  
	    String str2=str;
	    System.out.println(str2==str);
	    StringBuffer sb=new StringBuffer("abc");
	    setStringBuffer(sb);
	    System.out.println(sb);
	    
	    str=str+"_cd";
	    System.out.println(str);
	    System.out.println(str2==str);
	} 
	
	private static void setString(String str){
	    str="change";  
	}  
	
	private static void setStringBuffer(StringBuffer sb1){
		//sb1=new StringBuffer("change");
		sb1.append("_append");
	}

}
