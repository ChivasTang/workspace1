// 分類:スクリプトインクルード
// テーブル:x_468885_training
// デスクトップ
// GMTWF2NTTC_Com_Training
var GMTWF2NTTC_Com_Training = Class.create();
GMTWF2NTTC_Com_Training.prototype = {

    //承認画面へボタンの表示判定
    getDispApprovalBtn: function (current) {
        if (current.u_status_display == 20) {
            if (gs.getUser().getID() == current.u_assigned_to) {
                return true;
            } else {
                return false;
            }
        } else if (current.u_status_display == 30) {
            return this._chkUserInclude(current.u_worker_list);
        } else {
            return false;
        }
    },

    //読込権限の判定
    getRightRead: function (current) {
        if (current.isNewRecord()) {
            return true;
        } else if (gs.getUser().getID() == current.u_applicant_id || gs.getUser().getID() == current.u_assigned_to || this._chkUserInclude(current.u_worker_list)) {
            return true;
        } else if (gs.hasRole('x_com_training.main_dept')) {
            return true;
        } else if (current.u_applicant_department.toString() == this._getUserDepartment(gs.getUser().getID())) {
            return true;
        }
        return false;
    },

    //編集権限の判定
    getRightWrite: function (current) {
        if (current.isNewRecord()) {
            return true;
        } else if (current.u_status_display == 10) {
            if (gs.getUser().getID() == current.u_applicant_id) {
                return true;
            }
        } else if (current.u_status_display == 20) {
            if (gs.getUser().getID() == current.u_assigned_to) {
                return true;
            }
        } else if (current.u_status_display == 30) {
            if (this._chkUserInclude(current.u_worker_list)) {
                return true;
            }
        }
        return false;
    },

    //指定したユーザーの部門を取得
    _getUserDepartment: function (userSysID) {
        var myGR = new GlideRecord('sys_user');
        myGR.addQuery('sys_id', userSysID);
        myGR.query();
        if (myGR.next()) {
            return myGR.department.toString();
        }
        return "";
    },

    //ログインユーザーがリストに含まれているかの判定
    _chkUserInclude: function (userList) {
        var list = userList.split(',');
        for (var i = 0; i < list.length; i++) {
            if (list[i] == gs.getUser().getID().toString()) {
                return true;
            }
        }
        return false;
    },

    type: 'GMTWF2NTTC_Com_Training'
};