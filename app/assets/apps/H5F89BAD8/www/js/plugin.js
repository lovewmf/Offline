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
        PluginTest: function (successCallback, errorCallback) {
            var success = typeof successCallback !== 'function' ? null : function (args) {
                successCallback(args);
            },
                fail = typeof errorCallback !== 'function' ? null : function (code) {
                    errorCallback(code);
                };
            callbackID = B.callbackId(success, fail);

            return plus.bridge.exec(_BARCODE, "pluginTest", [callbackID]);

        }
    };
    return zysoftplugin;
});