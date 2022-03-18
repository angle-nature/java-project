package po;

import java.util.Date;

public class Student {
    private String id; //学号
    private String name; //姓名
    private String password; //登录密码
    private String sex; //性别
    private Date birthday; //出生 年月日
    private String nativePlace; //籍贯
    private String currentAddress; //当前居住地址
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Student() {
    }

    public Student(String id, String name, String password, String sex, Date birthday, String nativePlace, String currentAddress, String mobilePhone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.nativePlace = nativePlace;
        this.currentAddress = currentAddress;
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", nativePlace='" + nativePlace + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}