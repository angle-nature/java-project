package C004_Clz_Obj_2;
/**
 * project_name: Java_Ex
 *
 * package_name: C004_Clz_Obj_2 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-30 下午12:23:56 
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
		Chorus<歌手,乐器> model=new Chorus<歌手,乐器>();    //创建一个对象model
        歌手 zhangxueyou=new 歌手();
        乐器 piano=new 乐器();
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
class 乐器{
    public String toString(){
        System.out.println("|5 6 3-|5  17 56|");
        return "";
    }
}
class 歌手{
    public String toString(){
        System.out.println("美丽的草原,我可爱的家乡");
        return "";
    }
}

 