package shiyan;

class Accept{
 
	public static void main(String [ ] args) {
	
		int c=0;
		String s="";
		System.out.println("�������϶ȣ���0<��ֵ<100��");
		try {		
			while (c!='\n'){    //������Ĳ��ǻس�	    
				c=System.in.read();        
				s=s+(char)c;    //��int��ת����char�ͣ������ӳ��ַ���
			}
		} 
		catch (Exception e){}
		int celsius=Integer.parseInt(s.trim());
		double fahre=1.8*celsius+32;
		System.out.println("ת���ɻ��϶�Ϊ��"+fahre);
	}
}

