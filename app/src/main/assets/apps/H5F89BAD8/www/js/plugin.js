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
    };
    return ZySoftPlugin;
});