package dao;

import pojo.UserLogin;
import java.util.List;

public interface UserLoginMapper {
    public UserLogin doSelectByUserID(int userID);
    public List<UserLogin> doSelectAll();
    public List<UserLogin> doSelectByUserName(String userName);
}
