package OOA;

/*
 * Course 与 Score 存在一对多关联
 * */
import java.util.ArrayList;

public class Course {
    private String name;
    private int fullScore;
    private ArrayList sscs=new ArrayList();

    public Course(String name, int fullScore) {
        this.name = name;
        this.fullScore = fullScore;
    }

    public String getName() {
        return name;
    }

    public Score[] getScore(){
        //强转
        return (Score[]) sscs.toArray (new Score[0]);
    }

    public void addSSC(Score score){
        sscs.add(score);
    }

    @Override
    public String toString(){
        String s="    "+name+"(满分"+fullScore+",选课人：";
        Score[] scores=getScore();
        for(int i=0;i<scores.length;i++){
            s+=scores[i].getStudent().getName()+"、";
        }
        s+=") ";
        return s;
    }
}
