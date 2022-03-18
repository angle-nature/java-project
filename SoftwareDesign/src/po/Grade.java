package po;

public class Grade {
    private String studentID; //学号
    private String courseID; //课程号
    private String teacherID; //老师工号
    private float examScore; //考试成绩
    private float usualScore; //平时成绩
    private float totalScore; //总评成绩

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public float getExamScore() {
        return examScore;
    }

    public void setExamScore(float examScore) {
        this.examScore = examScore;
    }

    public float getUsualScore() {
        return usualScore;
    }

    public void setUsualScore(float usualScore) {
        this.usualScore = usualScore;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public Grade() {
    }

    public Grade(String studentID, String courseID, String teacherID, float examScore, float usualScore, float totalScore) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.teacherID = teacherID;
        this.examScore = examScore;
        this.usualScore = usualScore;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentID='" + studentID + '\'' +
                ", courseID='" + courseID + '\'' +
                ", teacherID='" + teacherID + '\'' +
                ", examScore=" + examScore +
                ", usualScore=" + usualScore +
                ", totalScore=" + totalScore +
                '}';
    }
}
