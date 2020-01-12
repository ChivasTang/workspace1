$.ajaxSetup({cache: false});

var mainLoader = (function () {

    var setFun = {
        pageReady: function () {
            setFun.generateLeftMenu();
        },

        // generate left menu
        generateLeftMenu: function () {
            var dataSource={
                "result": "y",
                "msg": "",
                "data":[
                    {
                        "id": "01",
                        "text": "<i class='fas fa-object-group'></i><sup></sup><abbr>勤務<small>Dashboard</small><sub class='theme-l'>\uD83C\uDF38</sub></abbr>",
                        "encoded": false,
                        "expanded": true,
                        "items": [
                            {
                                "id": "0101",
                                "text": "<i class='fas fa-tasks'></i>勤務表<small>Forms</small>",
                                "encoded": false,
                                "expanded": true,
                                "items": [
                                    {
                                        "id": "010101",
                                        "text": "<i class='fas fa-genderless'></i>日勤務時間",
                                        "encoded": false,
                                        "cssClass": "links-form_elements",
                                        "url": "javascript:linkTo(\"/dashboard/forms/\", \"form_elements\");"
                                    },
                                    {
                                        "id": "010102",
                                        "text": "<i class='fas fa-genderless'></i>週勤務計画",
                                        "encoded": false,
                                        "cssClass": "links-form_post",
                                        "url": "javascript:linkTo(\"/dashboard/forms/\", \"form_post\");"
                                    }
                                ]
                            },
                            {
                                "id": "0102",
                                "text": "<i class='fas fa-table'></i>社員管理<small>Grids</small>",
                                "encoded": false,
                                "expanded": true,
                                "items": [
                                    {
                                        "id": "010201",
                                        "text": "<i class='fas fa-genderless'></i>社員一覧",
                                        "encoded": false,
                                        "cssClass": "links-grid_custom",
                                        "url": "/admin/user"
                                    },
                                    {
                                        "id": "010202",
                                        "text": "<i class='fas fa-genderless'></i>証明出力",
                                        "encoded": false,
                                        "cssClass": "links-grid_popup",
                                        "url": "javascript:linkTo(\"/dashboard/grids/\", \"grid_popup\");"
                                    }
                                ]
                            }
                        ]
                    }
                ]
            };
            $('#navPanelBar').kendoPanelBar({
                dataSource: dataSource,
                loadOnDemand: false
            });
            $('#navMenu').kendoMenu({
                orientation: 'vertical',
                dataSource: dataSource
            });
        },
    };
    return {
        setFun: setFun
    };
})();

$(function () {
    mainLoader.setFun.pageReady();
});