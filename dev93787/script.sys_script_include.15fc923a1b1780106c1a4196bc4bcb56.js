// 分類:スクリプトインクルード
// テーブル:x_468885_training
// デスクトップ
// GMTWF2NTTC_Ajax_Training
var GMTWF2NTTC_Ajax_Training = Class.create();
GMTWF2NTTC_Ajax_Training.prototype = Object.extendsObject(global.AbstractAjaxProcessor, {

    //(5)ユーザマスタをsys_idで検索し、部門を返す
    getUserDepartment: function () {
        var userSysID = this.getParameter('sysparm_user_sysid');
        var myGR = new GlideRecord('sys_user');
        myGR.addQuery('sys_id', userSysID);
        myGR.query();
        if (myGR.next()) {
            var item = this.newItem("result");
            item.setAttribute('department', myGR.department);
            item.setAttribute('tel', myGR.phone);
        }
    },

    type: 'GMTWF2NTTC_Ajax_Training'
});