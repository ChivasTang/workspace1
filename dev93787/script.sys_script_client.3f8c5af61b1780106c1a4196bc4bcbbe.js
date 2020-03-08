// 分類:クライアントスクリプト
// テーブル:x_468885_training
// デスクトップ
// onSubmit
function onSubmit() {
    //(7)承認者の入力チェック
    var contractType = g_form.getValue('u_contract_type');
    var contractTypeName;
    if (contractType == 'ins') {
        contractTypeName = "bene";
    } else if (contractType == 'ann') {
        contractTypeName = "pens";
    }
    var inputAmt = g_form.getValue('u_' + contractTypeName + '_amt').replace(/,/g, '');
    var compAmt = g_scratchpad.config_doc[contractTypeName + '_limit_amt'];
    var msg = g_form.getLabelOf('u_' + contractTypeName + '_amt');
    if (inputAmt > compAmt) {
        g_form.addErrorMessage(msg + "が上限額(" + compAmt + ")を超えています");
        return false;
    }
}