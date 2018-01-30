package cc.cy.prescriptionorders.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by ygs on 2018/1/30.
 */

public class PrescriptionApplication extends Application {

    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }
}
