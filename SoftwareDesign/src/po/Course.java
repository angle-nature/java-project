package po;

public class Course {
    private String id; //课程号
    private String name; //课程名称
    private int credit; //学分
    private String previousID; //先修课课程号
    private int hour; //课时

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getPreviousID() {
        return previousID;
    }

    public void setPreviousID(String previousID) {
        this.previousID = previousID;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Course() {
    }

    public Course(String id, String name, int credit, String previousID, int hour) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.previousID = previousID;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", previousID='" + previousID + '\'' +
                ", hour=" + hour +
                '}';
    }
}
