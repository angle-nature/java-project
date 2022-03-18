package po;

public class TimeTable {
    private String studentID;
    private String courseID;
    private String teacherID;
    private String classroom;
    private String time;

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

    public TimeTable() {
    }

    public TimeTable(String studentID, String courseID, String teacherID, String classroom, String time) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.teacherID = teacherID;
        this.classroom = classroom;
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "studentID='" + studentID + '\'' +
                ", courseID='" + courseID + '\'' +
                ", teacherID='" + teacherID + '\'' +
                ", classroom='" + classroom + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
