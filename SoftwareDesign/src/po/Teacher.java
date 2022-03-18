package po;

public class Teacher {
    private String id; //教师工号
    private String name; //教师姓名
    private String office; //教研室
    private String position; //职称
    private String sex; //性别
    private String mobilePhone; //手机号码

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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Teacher() {
    }

    public Teacher(String id, String name, String office, String position, String sex, String mobilePhone) {
        this.id = id;
        this.name = name;
        this.office = office;
        this.position = position;
        this.sex = sex;
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", office='" + office + '\'' +
                ", position='" + position + '\'' +
                ", sex='" + sex + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}
