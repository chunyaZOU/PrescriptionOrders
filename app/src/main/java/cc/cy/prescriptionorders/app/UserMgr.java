package cc.cy.prescriptionorders.app;

import android.text.TextUtils;

/**
 * Created by ygs on 2018/1/30.
 */

public class UserMgr {
    public static final String USER_NAME="user_name";
    public static final String USER_PWD="user_pwd";

    public static void saveUserName(String userName){
        SharePreferenceMgr.put(USER_NAME,userName);
    }

    public static String getUserName(){
        return String.valueOf(SharePreferenceMgr.get(USER_NAME,""));
    }

    public static void saveUserPwd(String password){
        SharePreferenceMgr.put(USER_PWD,password);
    }

    public static String getUserPwd(){
        return String.valueOf(SharePreferenceMgr.get(USER_PWD,""));
    }

    public static boolean isLogin(){
        return !TextUtils.isEmpty(getUserName());
    }
}
