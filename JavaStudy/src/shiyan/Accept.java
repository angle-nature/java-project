package shiyan;

class Accept{
 
	public static void main(String [ ] args) {
	
		int c=0;
		String s="";
		System.out.println("输入摄氏度：（0<数值<100）");
		try {		
			while (c!='\n'){    //当输入的不是回车	    
				c=System.in.read();        
				s=s+(char)c;    //将int型转化成char型，再连接成字符串
			}
		} 
		catch (Exception e){}
		int celsius=Integer.parseInt(s.trim());
		double fahre=1.8*celsius+32;
		System.out.println("转化成华氏度为："+fahre);
	}
}

