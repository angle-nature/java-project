package OOA;

public class Score {
    private Student student;
    private Course course;
    private int score;

    public Score(Student student, Course course, int score) {
        this.student = student;
        this.course = course;
        this.score = score;

        student.addSSC(this);
        course.addSSC(this);
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString(){
        String s=course.toString()+"得分："+score+"\n";
        return s;
    }
}
