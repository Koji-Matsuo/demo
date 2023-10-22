/**
 * submit します。
 * form 画面のform　
 * path 画面のパス
 * isRole 権限チェックを行うか　true 行う false 行わない 
 */
function formSubmit(form, path, isRole = true){
	
	//引数チェック。
	 if(path === 'undefined' || typeof(path) != 'string' || path === ''){
        alert('パスを指定してください');
        return;
    }
    if(path.substr(0,5) != './../') {
		alert('パスが正しくありません。');
		return;
	}
	let pathRole = path.split('/')[2];
	if (pathRole != 'admin' && pathRole != 'user' && pathRole == 'staff'){
		alert('パスの権限が不正です。');
		return;
    }
    if(form === 'undefined' || typeof(form) != 'object'){
        alert('フォームが取得できませんでした');
        return;
    }
    if (isRole) {
		//ajaxでroleを取得する.
    	let role = ''
    	$.when(
			$.ajax({
			    url: './../api/role',
			    type: 'GET',
			    dataType: 'json',
			  })
			  .done(function(data) {
			      // 通信成功時の処理を記述
			      const jsonString = JSON.stringify(data); 
			      const json = JSON.parse(jsonString);
			      role = json.roleCode;
			  })
			  .fail(function() {
			      // 通信失敗時の処理を記述
			      alert('通信に失敗しました。');
				  return;
			})
		).done(function(){
			//権限チェック
		    if ( role == 'ADMIN' && pathRole == 'admin'
		      || role == 'STAFF' && pathRole == 'staff'
		      || role == 'USER'  && pathRole == 'user') {
			    submit(form, path);
			} else {
				alert('権限がありません。');
				return;
			}
		});
	    
	} else {
		submit(form, path);  
	}
}

function submit(form, path){
	form.action=path;
	form.method='post';
	form.submit(); 
}

