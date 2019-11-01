## Dcloud 最新版离线打包精简版示例

* master 分支为Dcloud

    `git clone -master https://github.com/lovewmf/Offline.git`

* apicloud 分支为ApiCloud

   `git clone -apicloud https://github.com/lovewmf/Offline.git`

**如需操作Application，必须要继承自DCloudApplication**

```java
public void onStart(Context pContext, Bundle pSavedInstanceState, String[] pRuntimeArgs) {
    mCtx = getDPluginContext();
    Log.e(TAG,"Dcloud离线打包插件开始执行");
}
```
<details>
<summary>PluginShowToastSync 异步 居中原生Toast</summary>

 **html**
```javascript
ZySoftPlugin.PluginShowToastSync();
```
**java**
```java
//同步无参无返回值
public void PluginShowToast(IWebview pWebview, JSONArray array){
    Log.e(TAG,"This is an synchronization Toast");
    Toast toast = Toast.makeText(mCtx, "This is an synchronization Toast",Toast.LENGTH_SHORT);
    toast.setGravity(Gravity.CENTER, 0, 0);
    toast.show();
}
```
</details>

<details>
<summary>PluginShowToast 同步 居中原生Toast</summary>

**html**
```javascript
 ZySoftPlugin.PluginShowToast();
```
**java**
```java
//同步无参无返回值
public void PluginShowToast(IWebview pWebview, JSONArray array){
    Log.e(TAG,"This is an synchronization Toast");
    Toast toast = Toast.makeText(mCtx, "This is an synchronization Toast",Toast.LENGTH_SHORT);
    toast.setGravity(Gravity.CENTER, 0, 0);
    toast.show();
}
 ```

 
</details>

<details>
<summary>PluginArgs 异步有传参有返回值</summary>

**html**
```javascript
ZySoftPlugin.PluginArgs("Dcloud",function(success){
    alert(success.toString());
},function(error){
    alert(error.toString());
});
```
**java**
```java
 //异步有参有返回值
public void PluginArgs(IWebview pWebview, JSONArray array){
    Log.e(TAG,"异步有参有返回值");
    String CallBackID = array.optString(0);
    JSONArray newArray = new JSONArray();
    newArray.put(array.optString(1));
    JSUtil.execCallback(pWebview, CallBackID, newArray, JSUtil.OK, false);//成功回调
    //JSUtil.execCallback(pWebview, CallBackID, newArray, JSUtil.ERROR, false);失败回调
}
```
</details>

<details>
<summary>PluginArgsSync 同步有传参有返回值</summary>

**html**
```javascript
ZySoftPlugin.PluginArgsSync("Dcloud");
```
**java**
```java
//同步有参有返回值
public String PluginArgsSync(IWebview pWebview, JSONArray array){
    Log.e(TAG,"同步有参有返回值");
    Log.e(TAG,array.toString());
    String inValue1 = array.optString(0);
    return JSUtil.wrapJsVar(inValue1,true);
}
```
</details>


## ApiCloud 离线打包模块开发

`https://docs.apicloud.com/Module-Dev/module-dev-guide-for-android-studio`

**配置module.json**
```json
{
    "modules":[
		{
		    "name":"moduleZySoft",
			"class":"com.wmf.moduleZySoft.APIModuleZySoft"
		}
	]
}
```

**使用方式**

```javascript
<script type="text/javascript">
    var zysoft = null;
    apiready = function(){
        zysoft = api.require('moduleZySoft');//引入模块
        $api.addEvt($api.byId('Suspension'), 'click', function(){
            zysoft.ShowToast();//执行模块里面的方法
        }, false);
    };
</script>
```