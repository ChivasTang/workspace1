// 分類:UIアクション
// テーブル:x_468885_training
// デスクトップ
// btnToApproval
var myGR = new GlideRecord('sysapproval_approver');
myGR.addQuery('sysapproval', current.sys_id.toString());
myGR.addQuery('state', 'requested');
myGR.addQuery('approver', gs.getUserID());
myGR.query();
if (myGR.next()) {
    current.update();
    var url = 'sysapproval_approver.do?sys_id=' + myGR.sys_id;
    gs.setRedirect(url);
} else {
    gs.addErrorMessage("承認レコードが存在しません。");
}