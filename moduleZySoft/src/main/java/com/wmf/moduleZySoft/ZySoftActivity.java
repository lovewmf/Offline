package com.wmf.moduleZySoft;

import android.view.Gravity;
import android.widget.Toast;

import com.uzmap.pkg.uzcore.UZWebView;
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
 * **************************************************************
 */
public class ZySoftActivity extends UZModule {

    public ZySoftActivity(UZWebView webView) {
        super(webView);
    }

//    public void jsmethod_ShowToast(UZModuleContext mCtx){
//        Toast toast = Toast.makeText(mCtx, "This is an synchronization Toast",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.show();
//    }

}
