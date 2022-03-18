package po;

public class Schedule { //开设课程
    private String courseID; //课程号
    private String teacherID; //授课教师工号
    private String classroom; //开课教室
    private String time; //开课时间
    private int limitation; //限制人数
    private int selectedNumber; //已选人数

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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLimitation() {
        return limitation;
    }

    public void setLimitation(int limitation) {
        this.limitation = limitation;
    }

    public int getSelectedNumber() {
        return selectedNumber;
    }

    public void setSelectedNumber(int selectedNumber) {
        this.selectedNumber = selectedNumber;
    }

    public Schedule() {
    }

    public Schedule(String courseID, String teacherID, String classroom, String time, int limitation, int selectedNumber) {
        this.courseID = courseID;
        this.teacherID = teacherID;
        this.classroom = classroom;
        this.time = time;
        this.limitation = limitation;
        this.selectedNumber = selectedNumber;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "courseID='" + courseID + '\'' +
                ", teacherID='" + teacherID + '\'' +
                ", classroom='" + classroom + '\'' +
                ", time='" + time + '\'' +
                ", limitation=" + limitation +
                ", selectedNumber=" + selectedNumber +
                '}';
    }
}
