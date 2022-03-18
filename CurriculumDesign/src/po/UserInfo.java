package po;

import java.util.Date;
/*
* 用户实体类
* */
public class UserInfo {
    private int id;
    private String userName;
    private String password;
    private String mobilePhone;
    private Date birthday;
    private String address;

    public UserInfo() {
    }

    public UserInfo(int id, String userName, String password, String mobilePhone, Date birthday, String address) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.mobilePhone = mobilePhone;
        this.birthday = birthday;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
