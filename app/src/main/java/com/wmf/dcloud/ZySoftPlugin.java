package com.wmf.dcloud;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.wmf.method.Function;

import org.json.JSONArray;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.StandardFeature;

public class ZySoftPlugin extends StandardFeature {
    private static final String TAG = "Dcloud_ZySoft";
    private Context mCtx;
    private Function fun;

    public void onStart(Context pContext, Bundle pSavedInstanceState, String[] pRuntimeArgs) {
        mCtx = getDPluginContext();
        fun = new Function();
        /**
         * 如果需要在应用启动时进行初始化，可以继承这个方法，并在properties.xml文件的service节点添加扩展插件的注册即可触发onStart方法
         * */
        Log.e(TAG,"Dcloud离线打包插件开始执行");
    }
    public void PluginTest(IWebview pWebview, JSONArray array){
        Log.e(TAG,"插件测试成功");
        fun.ShowToast(mCtx);

    }
}
