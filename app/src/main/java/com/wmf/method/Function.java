package com.wmf.method;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

/**
 * **************************************************************
 *
 * @ProjectName: Dcloud
 * @Package: com.wmf.method
 * @ClassName: Function
 * @Description: React Native调用原生模块
 * @Author: wmf
 * @CreateDate: 2019/10/31 10:42
 * @UpdateDate: 2019/10/31 10:42
 * **************************************************************
 */
public class Function extends Activity {

    public void ShowToast(Context mCtx,String msg){
        Toast toast = Toast.makeText(mCtx, msg,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
