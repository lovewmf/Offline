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
        PluginTest: function () {
			console.log("进入插件开始执行")
            return plus.bridge.execSync(_BARCODE, "PluginTest", [Argus]);

        }
    };
    return zysoftplugin;
});