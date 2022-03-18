package service;

import po.UserInfo;

public interface IUserService {
    /*
    * 用户验证
    * */
    UserInfo checkUser(String userName,String password);

    /*
    * 注册用户
    * */
    boolean registerUser(String userName,String password,String mobilePhone,String birthday,String address);
}
