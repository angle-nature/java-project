package day02.pm;

public class Reverse {

	public String doreverse(String inputstr) {
        String outputstr="";
		MyStack myst=new MyStack(inputstr.length());
		for (int i = 0; i < inputstr.length(); i++) {
			char ch= inputstr.charAt(i);
			myst.push(ch);
		}
        
		 while(!myst.isEmpty()){
			 outputstr=outputstr+myst.pop();
		 }
				
		return outputstr;
	}

}
