package day07.am.control;

import day07.am.model.UserLogin;
import java.util.ArrayList;

public interface InterfaceUserLogin {
    public int doInsert(UserLogin u);
    public boolean doLoginCheck(UserLogin u);
    public boolean doModifyPwd(UserLogin u);
    public ArrayList<UserLogin> doSelectAll();
}
