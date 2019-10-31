! function (root, factory) {
    if (typeof exports == 'object' && typeof module != 'undefined') {
        module.exports = factory()
    } else if (typeof define == 'function' && define.amd) {
        define(factory)
    } else {
        /**
         * 插件对象直接扩展到 window 对象上
         * 这个对象的名字，需要自己填写一下。例如：zysoftplugin
         */
        var moduleName = 'zysoftplugin';
        root[moduleName] = factory()
    }
}(this, function () {
    var _BARCODE = 'ZysoftPlugin';
    var zysoftplugin = {
        //科大讯飞语音初始化
        PluginTest: function () {
            console.log("------------------------hello---------------------------------");
            return plus.bridge.exec(_BARCODE, "PluginTest");

        }
    };
    return zysoftplugin;
});