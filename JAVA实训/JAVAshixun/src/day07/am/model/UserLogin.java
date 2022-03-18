package day07.am.model;

public class UserLogin {
    private int userid;
    private String userName;
    private String userPwd;
    private int userPrivilege;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserPrivilege() {
        return userPrivilege;
    }

    public void setUserPrivilege(int userPrivilege) {
        this.userPrivilege = userPrivilege;
    }

    public UserLogin(int userid, String userName, String userPwd, int userPrivilege) {
        this.userid = userid;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPrivilege = userPrivilege;
    }

    public UserLogin(String userName, String userPwd, int userPrivilege) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPrivilege = userPrivilege;
    }
}
