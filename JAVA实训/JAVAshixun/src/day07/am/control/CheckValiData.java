package day07.am.control;

public class CheckValiData {
    public static boolean checkIsNumber(String s){
        String regex="^\\d{1,2}$";
        if (s==null||s.length()==0)
            return false;
        else{
            return s.matches(regex);
        }
    }

    public static boolean checkIsNull(String s){
        if (s!=null&&s.length()!=0)
            return false;
        else
            return true;
    }
}
