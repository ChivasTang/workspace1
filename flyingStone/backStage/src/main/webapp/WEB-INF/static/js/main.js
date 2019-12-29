$.ajaxSetup({cache: false});

var mainLoader = (function () {
    var setFun = {
        pageReady: function () {

        }
    };
    return {
        setFun: setFun
    };
})();

$(function () {
    mainLoader.setFun.pageReady();
});