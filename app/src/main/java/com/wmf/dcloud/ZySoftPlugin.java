package com.wmf.dcloud;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

import com.wmf.customize.CardReader;
import com.wmf.method.Function;

import org.json.JSONArray;

import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.StandardFeature;
import io.dcloud.common.util.JSUtil;

/**
 * 5+ SDK 扩展插件示例
 * 5+ 扩扎插件在使用时需要以下两个地方进行配置
 * 		1  WebApp的mainfest.json文件的permissions节点下添加JS标识
 * 		2  assets/data/properties.xml文件添加JS标识和原生类的对应关系
 * 本插件对应的JS文件在 assets/apps/H5Plugin/js/test.js
 * 本插件对应的使用的HTML assest/apps/H5plugin/index.html
 *
 * 更详细说明请参考文档http://ask.dcloud.net.cn/article/66
 * **/
public class ZySoftPlugin extends StandardFeature {
    private static final String TAG = "zysoft";
    private Context mCtx;
    private Function fun;
    private  CardReader cardReader;
    private static final  int SUCCESSD =0;
    private String text = "";


    public void onStart(Context pContext, Bundle pSavedInstanceState, String[] pRuntimeArgs) {
        /**
         * 如果需要在应用启动时进行初始化，可以继承这个方法，并在properties.xml文件的service节点添加扩展插件的注册即可触发onStart方法
         * */
        mCtx = getDPluginContext();
        fun = new Function();
        cardReader = new CardReader();
        Log.e(TAG,"Dcloud离线打包插件开始执行");
    }
    //同步无参无返回值
    public void PluginShowToast(IWebview pWebview, JSONArray array){
        Log.e(TAG,"This is an synchronization Toast");
        fun.ShowToast(mCtx,"This is an synchronization Toast");
    }
    //同步无参无返回值
    public void PluginTellCall(IWebview pWebview, JSONArray array){
        Log.e(TAG,"PluginTellCall");
        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:15827056428"));
        mCtx.startActivity(intent);
    }
    //异步无参无返回值
    public void PluginShowToastSync(IWebview pWebview, JSONArray array){
        Log.e(TAG,"This is a asynchronous Toast");
        fun.ShowToast(mCtx,"This is a asynchronous Toast");
    }
    //异步有参有返回值
    public void PluginArgs(IWebview pWebview, JSONArray array){
        Log.e(TAG,"异步有参有返回值");
        String CallBackID = array.optString(0);
        JSONArray newArray = new JSONArray();
        newArray.put(array.optString(1));
        JSUtil.execCallback(pWebview, CallBackID, newArray, JSUtil.OK, false);//成功回调
        //JSUtil.execCallback(pWebview, CallBackID, newArray, JSUtil.ERROR, false);失败回调

    }
    //同步有参有返回值
    public String PluginArgsSync(IWebview pWebview, JSONArray array){
        Log.e(TAG,"同步有参有返回值");
        Log.e(TAG,array.toString());
        String inValue1 = array.optString(0);
        return JSUtil.wrapJsVar(inValue1,true);
    }
    //同步有参有返回值
    public void PluginCapter(IWebview pWebview, JSONArray array){
        Log.e(TAG,"截屏插件");
        //View dView = mCtx.getWindow().getDecorView();
//        dView.setDrawingCacheEnabled(true);
//        dView.buildDrawingCache();
//        Bitmap bitmap = Bitmap.createBitmap(dView.getDrawingCache());
//        dView.destroyDrawingCache();
//        imageView.setImageBitmap(bitmap);

    }
    public void PluginInitSdk(IWebview pWebview, JSONArray array){
        String CallBackID = array.optString(0);
        openDevice(pWebview,CallBackID);
    }
    @SuppressLint("HandlerLeak")
    public final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SUCCESSD:{
                    Log.e(TAG, (String) msg.obj);
                }
            }
        }
    };
    private void openDevice(final IWebview pWebview, final String CallBackID) {
        new Thread() {
            @Override
            public void run() {
               // mHandler.sendMessage(mHandler.obtainMessage(SUCCESSD, "this is Thread"));
                JSUtil.execCallback(pWebview, CallBackID, "this is Thread", JSUtil.OK, false);//成功回调
            }
        }.start();
    }
}
