package com.wmf.dcloud;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.wmf.method.Function;

import org.json.JSONArray;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.StandardFeature;

public class ZySoftPlugin extends StandardFeature {
    private static final String TAG = "zysoft";
    private Context mCtx;
    private Function fun;

    public void onStart(Context pContext, Bundle pSavedInstanceState, String[] pRuntimeArgs) {
        mCtx = getDPluginContext();
        fun = new Function();
        Log.e(TAG,"Dcloud离线打包插件开始执行");
    }
    public void PluginShowToast(IWebview pWebview, JSONArray array){
        Log.e(TAG,"This is an synchronization Toast");
        fun.ShowToast(mCtx,"This is an synchronization Toast");
    }
    public void PluginShowToastSync(IWebview pWebview, JSONArray array){
        Log.e(TAG,"This is a asynchronous Toast");
        fun.ShowToast(mCtx,"This is a asynchronous Toast");

    }
}
