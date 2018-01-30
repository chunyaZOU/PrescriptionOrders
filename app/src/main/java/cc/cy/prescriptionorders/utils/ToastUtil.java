package cc.cy.prescriptionorders.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import cc.cy.prescriptionorders.app.PrescriptionApplication;

/**
 * Created by ygs on 2018/1/30.
 */

public class ToastUtil {

    public static void show(@StringRes int strResID){
        Toast.makeText(PrescriptionApplication.mContext,strResID,Toast.LENGTH_SHORT).show();
    }
    public static void show(String str){
        Toast.makeText(PrescriptionApplication.mContext,str,Toast.LENGTH_SHORT).show();
    }
}
