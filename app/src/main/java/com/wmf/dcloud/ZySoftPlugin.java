package com.wmf.dcloud;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.wmf.method.Function;

import org.json.JSONArray;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.StandardFeature;
import io.dcloud.common.util.JSUtil;

public class ZySoftPlugin extends StandardFeature {
    private static final String TAG = "zysoft";
    private Context mCtx;
    private Function fun;

    public void onStart(Context pContext, Bundle pSavedInstanceState, String[] pRuntimeArgs) {
        mCtx = getDPluginContext();
        fun = new Function();
        Log.e(TAG,"Dcloud离线打包插件开始执行");
    }
    //同步无参无返回值
    public void PluginShowToast(IWebview pWebview, JSONArray array){
        Log.e(TAG,"This is an synchronization Toast");
        fun.ShowToast(mCtx,"This is an synchronization Toast");
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
}
