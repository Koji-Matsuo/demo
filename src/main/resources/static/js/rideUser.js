/**
 * submit します。 
 */
function goToUser(val){
	let form = document.getElementsByTagName('form')[0];
	document.getElementById('userId').value = val;
    formSubmit(form,'./../admin/ride_user');
}