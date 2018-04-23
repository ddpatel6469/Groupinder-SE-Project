/* 
 * @authors Rahul Chhapgar, Darshan Patel
 * Team 7 ||  Software Engineering 
 * Date format : mm/dd/yyyy
*/

function validate(){

	if (!/^[a-zA-Z]*$/g.test(document.myform.name.value)) {
		alert("Invalid name");
		document.myform.name.focus();
		return false;
	}	// Darshan_Patel *version-2* 07/10/2017
	
	if (document.myform.name.value == "") {
		alert("Enter your name");
		document.myform.name.focus();
		return false;
	}	// Rahul_Chhapgar *version-2* 07/12/2017 
	
	
	
	
	if (document.myform.email.value == "") {
		alert("Enter email id");
		document.myform.email.focus();
		return false;
	}	// Rahul_Chhapgar *version-2* 07/12/2017
	
	var x = document.myform.email.value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        document.myform.email.focus();
        return false;
    } //Shaunak_sangdod *version-3* 07/15/2017
	
	
	
	

	
	
	
	
	

	var decimal = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,15}/;
	if (document.myform.password.value.match(decimal))
		;
	else {
		alert('Password must be 8 to 15 Characters , at least 1 upper case and 1 number and 1 lower case')
		return false;
	}	// Darshan_Patel *version-2* 07/10/2017
	
	if (document.myform.password.value == "") {
		alert("Enter password");
		document.myform.password.focus();
		return false;
	}	// Rahul_Chhapgar *version-2* 07/12/2017

	if (document.myform.password.value != document.myform.retypepassword.value) {
		alert("Password doesn't match");
		document.myForm.password.focus();
		return false;
	}	// Darshan_Patel *version-2* 07/10/2017
	
	if (document.myform.retypepassword.value == "") {
		alert("Enter password again");
		document.myform.retypepassword.focus();
		return false;
	}	// Rahul_Chhapgar *version-2* 07/12/2017

	var decimal = /^[0-9]{10,10}$/;
	if (document.myform.mobileno.value.match(decimal))
		;
	else {
		alert('Not a valid mobile number')
		return false;
	}	// Darshan_Patel *version-2* 07/10/2017
	
	if (document.myform.mobileno.value == "") {
		alert("Enter mobile number");
		document.myform.mobileno.focus();
		return false;
	}	// Rahul_Chhapgar *version-2* 07/12/2017
}