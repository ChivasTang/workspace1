// 分類:ビジネスルール
// テーブル:x_468885_training
// デスクトップ
// page_ready
(function executeRule(current, previous) {
    var myGR;
    //(1)申請者所属の取得
    if (current.isNewRecord()) {
        myGR = new GlideRecord('sys_user');
        myGR.addQuery('sys_id', gs.getUser().getID());
        myGR.query();

        var ans = "";
        if (myGR.next()) {
            gs.debug("myGR.departmentの値は:" + myGR.department);
            ans = myGR.department;
        }
        gs.debug(g_scratchpad);
        g_scratchpad.application_department = ans;
    }

    //(3)設定文書（テーブル「x_468885_training_recept_setting」）から項目「申込理由」を取得し、',' で分割して、画面の「申込理由」の選択肢に設定する。
    myGR = new GlideRecord('x_468885_training_recept_setting');
    myGR.query();
    var items = {};
    if (myGR.next()) {
        items['request_reason'] = myGR.u_request_reason.toString();
        items['bene_limit_amt'] = myGR.u_bene_limit_amt.toString();
        items['pens_limit_amt'] = myGR.u_pens_limit_amt.toString();
        g_scratchpad.config_doc = items;
    }

    //(4)ステータスが「作成中」の場合、テーブル「sys_user_has_role」を role = 'x_468885_training.work_dept' で検索し、該当レコードの項目「user」を画面の「作業者」に設定する。
    myGR = new GlideRecord('sys_user_has_role');
    myGR.addQuery('role.name', 'x_468885_training.work_dept');
    myGR.query();
    var list = [];
    while (myGR.next()) {
        list.push(myGR.user.toString());
    }
    gslog(g_scratchpad);
    gslog(list);
    g_scratchpad.worker_list = list;
})(current, previous);