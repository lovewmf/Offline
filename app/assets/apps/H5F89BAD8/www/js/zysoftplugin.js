document.addEventListener("plusready", function () {
    var _BARCODE = 'ZysoftPlugin',
        B = window.plus.bridge;
    var zysoftplugin =
    {
        //科大讯飞语音初始化
        PluginSpeekInit: function (successCallback, errorCallback) {
            var success = typeof successCallback !== 'function' ? null : function (args) {
                successCallback(args);
            },
                fail = typeof errorCallback !== 'function' ? null : function (code) {
                    errorCallback(code);
                };
            callbackID = B.callbackId(success, fail);

            return B.exec(_BARCODE, "pluginSpeakInit", [callbackID]);

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

            return B.exec(_BARCODE, "PluginSpeak", [callbackID, mess]);

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

            return B.exec(_BARCODE, "PlugingetIPMAC", [callbackID]);
        },
        /**
        * description 科大讯飞语音语速调节
        * @method PluginControl 科大讯飞语音调节 PluginControl。
        * @param {Object} 语音volume 语速rate
        */
        PluginControl: function (Argus) {
            return plus.bridge.execSync(_BARCODE, "PluginControl", [Argus]);
        },
        //结束当前app进程
        PluginEndProcess: function(){
            return plus.bridge.execSync(_BARCODE, "PluginEndProcess");
        },
        //获取系统可用存储空间大小
        PluginSize: function () {
            return plus.bridge.execSync(_BARCODE, "PluginSize");
        },
        //获取文件大小
        PluginFileSize: function (url, successCallback, errorCallback) {
            console.log("+++++++++++++++++++++" + url + "++++++++++++++++");
            var success = typeof successCallback !== 'function' ? null : function (args) {
                    successCallback(args);
                },
                fail = typeof errorCallback !== 'function' ? null : function (code) {
                    errorCallback(code);
                };
            callbackID = plus.bridge.callbackId(success, fail);
            return plus.bridge.exec(_BARCODE, "PluginFileSize", [callbackID, url]);
        },
        PluginTestFunction: function (Argus1, Argus2, Argus3, Argus4, successCallback, errorCallback) {
            var success = typeof successCallback !== 'function' ? null : function (args) {
                successCallback(args);
            },
                fail = typeof errorCallback !== 'function' ? null : function (code) {
                    errorCallback(code);
                };
            callbackID = B.callbackId(success, fail);

            return B.exec(_BARCODE, "PluginTestFunction", [callbackID, Argus1, Argus2, Argus3, Argus4]);
        },
        PluginTestFunctionArrayArgu: function (Argus, successCallback, errorCallback) {
            var success = typeof successCallback !== 'function' ? null : function (args) {
                successCallback(args);
            },
                fail = typeof errorCallback !== 'function' ? null : function (code) {
                    errorCallback(code);
                };
            callbackID = B.callbackId(success, fail);
            return B.exec(_BARCODE, "PluginTestFunctionArrayArgu", [callbackID, Argus]);
        },
        PluginTestFunctionSync: function (Argus1, Argus2, Argus3, Argus4) {
            return B.execSync(_BARCODE, "PluginTestFunctionSync", [Argus1, Argus2, Argus3, Argus4]);
        },
        PluginTestFunctionSyncArrayArgu: function (Argus) {
            return B.execSync(_BARCODE, "PluginTestFunctionSyncArrayArgu", [Argus]);
        }
    };
    window.plus.zysoftplugin = zysoftplugin;

}, true);