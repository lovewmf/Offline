package com.wmf.customize;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IPowerManager;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
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
public class CardReader extends Application {

    private static final  int SUCCESSD =0;
    private FingerprintScanner mScanner;
    private IPowerManager mPower;
    private HsSerialPortSDK sdk;
    int version = Integer.parseInt(Build.VERSION.SDK);
    private static final String TAG = "zysoft";
    private String filepath ="";
    private Context mCtx;

    @Override
    public void onCreate() {
       super.onCreate();
        mCtx = getApplicationContext();
        Log.e(TAG,"123456");
    }
    public void initSdk(){
        Log.e(TAG,"初始化SDK");

        mScanner = FingerprintScanner.getInstance();
        mPower = IPowerManager.Stub.asInterface(ServiceManager.getService("power"));
        if (sdk != null) {
            return;
        }
        openDevice();
    }
    @SuppressLint("HandlerLeak")
    public final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SUCCESSD:{
                    Log.e(TAG, String.valueOf(msg.obj));
                }
            }
        }
    };
    private void openDevice() {
        new Thread() {
            @Override
            public void run() {
                mHandler.sendMessage(mHandler.obtainMessage(SUCCESSD, "hello"));
            }
        }.start();
    }
}
