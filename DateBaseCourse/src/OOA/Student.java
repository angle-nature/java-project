package OOA;
/*
* Student 与 Score 存在一对多关联
* */
import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList sscs=new ArrayList();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Score[] getSSC(){
        //强转
        return (Score[]) sscs.toArray (new Score[0]);
    }

    public void addSSC(Score score){
        sscs.add(score);
    }

    @Override
    public String toString(){
        String s="学生姓名："+name+"\n";
        s+="该学生所选课程及得分："+"\n";
        Score[] scores=getSSC();
        for(int i=0;i<scores.length;i++){
            s+=scores[i].toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Student st1=new Student("张三");
        Student st2=new Student("李四");
        Student st3=new Student("王五");

        Course c1=new Course("07020001 UML", 100);
        Course c2=new Course("07020002 SoftwareTest", 100);
        Course c3=new Course("07030003 Java", 100);
        Course c4=new Course("07030004 C++", 100);


        Score sc1=new Score(st1, c1, 85);
        Score sc2=new Score(st1, c3, 92);
        Score sc3=new Score(st2, c1, 77);
        Score sc4=new Score(st2, c3, 87);
        Score sc5=new Score(st2, c4, 92);
        Score sc6=new Score(st3, c3, 81);
        Score sc7=new Score(st3, c4, 88);

        System.out.println("学生选课及得分情况如下：");
        System.out.println("====================");
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);
        System.out.println("\n/*******软194 何知灿*******/");
    }
}
