package pojo;

public class UserLogin {
    private int userID;
    private String userName;
    private String userPwd;
    private int userPrivilege;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public UserLogin(int userID, String userName, String userPwd, int userPrivilege) {
        this.userID = userID;
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
