package com.wmf.customize;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.IPowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

import com.huashi.lua.HsUtlis;
import com.huashi.serialport.sdk.HsSerialPortSDK;

import java.io.IOException;

import cn.com.aratek.fp.FingerprintScanner;

/**
 * **************************************************************
 *
 * @ProjectName: Dcloud
 * @Package: com.wmf.customize
 * @ClassName: CardReader
 * @Description:
 * @Author: wmf
 * @CreateDate: 2019/11/13 10:58
 * @UpdateDate: 2019/11/13 10:58
 * **************************************************************
 */
public class CardReader extends Activity {

    private FingerprintScanner mScanner;
    private IPowerManager mPower;
    private HsSerialPortSDK sdk;
    int version = Integer.parseInt(Build.VERSION.SDK);
    private static final String TAG = "The_life_cycle";

    public void initSdk(){
        Log.e(TAG,"初始化SDK");
        mScanner = FingerprintScanner.getInstance();
        mPower = IPowerManager.Stub.asInterface(ServiceManager.getService("power"));
        if (sdk != null) {
            return;
        }
        if(version == 22){
            try {
                mPower.SetCardPower(1);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }else {
            try {
                HsUtlis.IDCardPonwer1();
            } catch (IOException e) {
                return;
            }
        }
    }
}
