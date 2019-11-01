package com.wmf.moduleZySoft;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;
import com.uzmap.pkg.uzcore.UZWebView;
import com.uzmap.pkg.uzcore.uzmodule.ModuleResult;
import com.uzmap.pkg.uzcore.uzmodule.UZModule;
import com.uzmap.pkg.uzcore.uzmodule.UZModuleContext;

/**
 * **************************************************************
 *
 * @ProjectName: APICloudModuleSDK
 * @Package: com.wmf.moduleZySoft
 * @ClassName: ZySoftActivity
 * @Description: ApiCloud调用原生模块
 * @Author: wmf
 * @CreateDate: 2019/11/1 10:11
 * @UpdateDate: 2019/11/1 10:11
 * @Document https://docs.apicloud.com/Module-Dev/module-dev-guide-for-android-studio APICloud模块开发文档
 * **************************************************************
 */
public class APIModuleZySoft extends UZModule{

    private static final String TAG = "zysoft";
    private Context mCtx;

    public APIModuleZySoft(UZWebView webView) {
        super(webView);
    }
    //异步
    public void jsmethod_ShowToast( final UZModuleContext moduleContext){
        Log.e(TAG,"插件执行成功");
        Toast toast = Toast.makeText(context(), "Hi！我是原生的Toast",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        moduleContext.interrupt();
        //moduleContext.success("",true);成功回调
       // moduleContext.error("",true);失败回调
    }
    //同步
    public ModuleResult jsmethod_FuncSync(final UZModuleContext context){
        return new ModuleResult(true);
    }

}
