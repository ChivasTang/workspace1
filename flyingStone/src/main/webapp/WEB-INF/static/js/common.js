$.ajaxSetup({cache: false});

var commFunc = (function () {
    var setFun = {

        pageReady: function () {
        },

        isEmpty: function (str) {
            return undefined === str || null === str || !str || "" === str;
        }
    };
    return {
        setFun: setFun
    };
})();

$(function () {
    commFunc.setFun.pageReady();
});