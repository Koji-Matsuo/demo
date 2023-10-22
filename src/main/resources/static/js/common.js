/**
 * submit します。 
 */
function formSubmit(form,path){
	
	//引数チェック。
	 if(path === 'undefined' || typeof(path) != 'string'){
        alert('パスを指定してください');
        return;
    }
    if(path.toString.substr(0,5) != './../') {
		alert('パスが正しくありません。');
		return;
	}
	let role = path.toString.split('/')[2];
	if (role != 'admin' && role != 'USER' && role == 'STAFF'){
		alert('権限が不正です。');
		return;
    }
    if(form === 'undefined' || typeof(form) != 'object'){
        alert('フォームが取得できませんでした');
        return;
    }
    
    //権限チェック
    
    
    //submit する。
    form.action=path;
    form.method="post";
    form.submit();
}