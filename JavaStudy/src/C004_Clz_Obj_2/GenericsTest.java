package C004_Clz_Obj_2;
/**
 * project_name: Java_Ex
 *
 * package_name: C004_Clz_Obj_2 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-30 ����12:23:56 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: GenericsTest.java  
 *
 * Description:  
 *
 */
public class GenericsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chorus<����,����> model=new Chorus<����,����>();    //����һ������model
        ���� zhangxueyou=new ����();
        ���� piano=new ����();
        model.makeChorus(zhangxueyou,piano);
	}

}
interface Computer<E,F>{
    void makeChorus(E x,F y); 
}
class Chorus<E,F> implements Computer<E,F>{
    public void makeChorus(E x,F y){
        x.toString();
        y.toString();
    }
}
class ����{
    public String toString(){
        System.out.println("|5 6 3-|5  17 56|");
        return "";
    }
}
class ����{
    public String toString(){
        System.out.println("�����Ĳ�ԭ,�ҿɰ��ļ���");
        return "";
    }
}

 