$.ajaxSetup({cache: false});

var loginLoader = (function () {
    var setFun = {

        pageReady: function () {
        }
    };
    return {
        setFun: setFun
    };
})();

$(function () {
    loginLoader.setFun.pageReady();
});