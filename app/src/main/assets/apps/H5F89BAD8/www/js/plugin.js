! function (root, factory) {
    if (typeof exports == 'object' && typeof module != 'undefined') {
        module.exports = factory()
    } else if (typeof define == 'function' && define.amd) {
        define(factory)
    } else {
        /**
         * 插件对象直接扩展到 window 对象上
         * 这个对象的名字，需要自己填写一下。例如：ZySoftPlugin
         */
        var moduleName = 'ZySoftPlugin';
        root[moduleName] = factory()
    }
}(this, function () {
    var _BARCODE = 'ZySoftPlugin';
    var ZySoftPlugin = {
		//异步无参
		PluginShowToastSync: function(){
            return plus.bridge.exec(_BARCODE,"PluginShowToastSync",[]);
		},
		 //同步无参数
        PluginShowToast: function(){
        	return plus.bridge.execSync(_BARCODE,"PluginShowToast",[]);
        },
        //异步有参有返回值
        PluginArgs: function(args,successCallback, errorCallback){
            console.log(12345678);
            var success = typeof successCallback !== 'function' ? null : function(args) {
                    successCallback(args);
                },
                fail = typeof errorCallback !== 'function' ? null : function(code) {
                    errorCallback(code);
                };
            callbackID = plus.bridge.callbackId(success, fail);

            return plus.bridge.exec(_BARCODE, "PluginArgs", [callbackID,args]);
        },
        //同步有参有返回值
        PluginArgsSync: function(args){
            return plus.bridge.execSync(_BARCODE, "PluginArgsSync", [args]);
        }
    };
    return ZySoftPlugin;
});