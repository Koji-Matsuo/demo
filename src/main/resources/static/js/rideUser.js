/**
 * submit します。 
 */
function submit(val){
	let form = document.getElementsByTagName('form')[0];
    form.userId.value = val;
    formSubmit(form,'./../admin/ride_user');
}