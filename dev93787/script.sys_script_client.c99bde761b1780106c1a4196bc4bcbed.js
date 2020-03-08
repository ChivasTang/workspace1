// 分類:クライアントスクリプト
// テーブル:x_468885_training
// デスクトップ
// x_468885_training_approver_onChange
function onChange(control, oldValue, newValue, isLoading, isTemplate) {
    if (isLoading) {
        return;
    }

    //(5)承認者の部門を設定
    if (newValue == "") {
        g_form.clearValue('u_assigned_department');
    } else {
        var aj = new GlideAjax('GMTWF2NTTC_Ajax_Training');
        aj.addParam('sysparm_name', 'getUserDepartment');
        aj.addParam('sysparm_user_sysid', newValue);
        aj.getXML(function(response) {
            var item = response.responseXML.getElementsByTagName("result");
            g_form.setValue('u_assigned_department', item[0].getAttribute('department'));
        });
    }
}