$.ajaxSetup({cache: false});

var signInLoader = (function () {
    var setFun = {

        pageReady: function () {
        }
    };
    return {
        setFun: setFun
    };
})();

$(function () {
	signInLoader.setFun.pageReady();
});