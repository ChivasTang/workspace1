// 分類:クライアントスクリプト
// テーブル:x_468885_training
// デスクトップ
// onLoad
function onLoad() {
    //(1)新規レコード時の設定
    if (g_form.isNewRecord()) {
        g_form.setValue('u_status_display', 10);
        g_form.setValue('u_applicant_id', g_user.userID.toString());
        g_form.setValue('u_applicant_department', g_scratchpad.applicant_department);
    }

    //(2)ラベルの変更
    g_form.setLabelOf('u_applicant_id.department', '申請者現所属');
    g_form.setLabelOf('u_assigned_to.department', '承認者現所属');

    //(3)設定文書から取得した選択肢の設定
    var items = g_scratchpad.config_doc['request_reason'].split(',');
    for (var i = 0; i < items.length; i++) {
        g_form.addOption('u_request_reason', items[i], items[i]);
    }


    //(6)契約種類によって表示項目を変更
    var contractType = g_form.getValue('u_contract_type');
    var flgDispIns = false;
    var flgDispAnn = false;
    if (contractType == 'ins') {
        flgDispIns = true;
    } else if (contractType == 'ann') {
        flgDispAnn = true;
    }
    g_form.setDisplay('u_bene_recept', flgDispIns);
    g_form.setDisplay('u_pens_recept', flgDispAnn);
    g_form.setDisplay('u_bene_amt', flgDispIns);
    g_form.setDisplay('u_pens_amt', flgDispAnn);
    g_form.setMandatory('u_bene_recept', flgDispIns);
    g_form.setMandatory('u_pens_recept', flgDispAnn);
    g_form.setMandatory('u_bene_amt', flgDispIns);
    g_form.setMandatory('u_pens_amt', flgDispAnn);

    //現所属の読込専用化、作業者の非表示化
    g_form.setReadOnly('u_applicant_id.department', true);
    g_form.setReadOnly('u_assigned_to.department', true);
    g_form.setDisplay('u_worker_list', false);

}