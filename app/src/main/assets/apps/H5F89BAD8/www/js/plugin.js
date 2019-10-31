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
        PluginSpeekInit: function (successCallback, errorCallback) {
            var success = typeof successCallback !== 'function' ? null : function (args) {
                successCallback(args);
            },
                fail = typeof errorCallback !== 'function' ? null : function (code) {
                    errorCallback(code);
                };
            callbackID = B.callbackId(success, fail);

            return plus.bridge.exec(_BARCODE, "pluginSpeakInit", [callbackID]);

        },
        //科大讯飞语音
        PluginSpeek: function (mess, successCallback, errorCallback) {
            var success = typeof successCallback !== 'function' ? null : function (args) {
                successCallback(args);
            },
                fail = typeof errorCallback !== 'function' ? null : function (code) {
                    errorCallback(code);
                };
            callbackID = B.callbackId(success, fail);

            return plus.bridge.exec(_BARCODE, "PluginSpeak", [callbackID, mess]);

        },
        //获取ip以及mac
        PluginIpMac: function (successCallback, errorCallback) {

            var success = typeof successCallback !== 'function' ? null : function (args) {
                successCallback(args);
            },
                fail = typeof errorCallback !== 'function' ? null : function (code) {
                    errorCallback(code);
                };
            callbackID = B.callbackId(success, fail);

            return plus.bridge.exec(_BARCODE, "PlugingetIPMAC", [callbackID]);
        },
        //重启系统
        PluginRestart: function () {

        },
        PluginTestFunction: function (Argus1, Argus2, Argus3, Argus4, successCallback, errorCallback) {

            var success = typeof successCallback !== 'function' ? null : function (args) {
                successCallback(args);
            },
                fail = typeof errorCallback !== 'function' ? null : function (code) {
                    errorCallback(code);
                };
            callbackID = B.callbackId(success, fail);

            return plus.bridge.exec(_BARCODE, "PluginTestFunction", [callbackID, Argus1, Argus2, Argus3, Argus4]);
        },
    };
    return zysoftplugin;
});