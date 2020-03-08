// 分類:クライアントスクリプト
// テーブル:x_468885_training
// デスクトップ
// x_468885_training_contactType_onChange
function onChange(control, oldValue, newValue, isLoading, isTemplate) {
    if (isLoading) {
        return;
    }

    //(6)契約種類によって表示項目を変更
    var flgDispIns = false;
    var flgDispAnn = false;
    if (newValue == 'ins') {
        flgDispIns = true;
        g_form.clearValue('u_pens_recept');
        g_form.clearValue('u_pens_amt');
    } else if (newValue == 'ann') {
        flgDispAnn = true;
        g_form.clearValue('u_bene_recept');
        g_form.clearValue('u_bene_amt');
    }
    g_form.setMandatory('u_bene_recept', flgDispIns);
    g_form.setMandatory('u_pens_recept', flgDispAnn);
    g_form.setMandatory('u_bene_amt', flgDispIns);
    g_form.setMandatory('u_pens_amt', flgDispAnn);
    g_form.setDisplay('u_bene_recept', flgDispIns);
    g_form.setDisplay('u_pens_recept', flgDispAnn);
    g_form.setDisplay('u_bene_amt', flgDispIns);
    g_form.setDisplay('u_pens_amt', flgDispAnn);


}