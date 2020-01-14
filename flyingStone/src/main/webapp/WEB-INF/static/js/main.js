$.ajaxSetup({cache: false});

var mainLoader = (function () {

    var setFun = {
        pageReady: function () {
            setFun.getNavBar();
        },
        getNavBar: function () {
            $.ajax({
                url:"lib/ikki/dist/json/nav.json",
                type:"GET",
                contentType:"json",
                success:function(resData){
                    console.log(resData);
                    $('#navPanelBar').kendoPanelBar({
                        dataSource: resData.data,
                        loadOnDemand: false
                    });
                    $('#navMenu').kendoMenu({
                        orientation: 'vertical',
                        dataSource: resData.data
                    });
                }
            });
        }
    };
    return {
        setFun: setFun
    };
})();

$(function () {
    mainLoader.setFun.pageReady();
});