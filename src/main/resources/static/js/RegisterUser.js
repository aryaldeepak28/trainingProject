function validateEmail(email) {
	const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(String(email).toLowerCase());
}
function validateRegistrationform(event) {
	event.preventDefault();
	var name = document.forms["registrationForm"]["username"].value;
	var email = document.forms["registrationForm"]["email"].value;
	var phone_number = document.forms["registrationForm"]["phone_number"].value;
	var address = document.forms["registrationForm"]["address"].value;
	var password = document.forms["registrationForm"]["password"].value;
	var confirm_password = document.forms["registrationForm"]["confirm_password"].value;
	
	if (name==null || name==""){
		alert("Please enter your name");
	    return false;
	}else if (email==null || email==""){
		alert("Please enter your email address");
	    return false;
	}else if(!validateEmail(email)){
	   	alert("Please enter a valid email address");
	    return false;
	}else if (phone_number==null || phone_number==""){
	    alert("Please enter your phone number");
	    return false;
	}else if (password==null || password==""){
	    alert("Please enter your password");
	    return false;
	}else if (confirm_password==null || confirm_password==""){
	    alert("Please enter confirm password");
	    return false;
	}else if(password != confirm_password){
	   	alert("Please enter same password and confirm password");
        return false;
    }
    
    var url = "http://localhost:8089/api/users";
    var data = {
    	"user_id" : 1,
    	"name" : name,
        "email" : email,
        "password" : password,
        "phone_no" : phone_number,
        "address" : address,
        "reg_date": "",
        "upload_photo" : ""
    };
    console.log(data);
    const other_params = {
        headers : { "content-type" : "application/json; charset=UTF-8" },
        body : JSON.stringify(data),
        method : "POST"
    };
    fetch(url, other_params)
        .then(function(response) {
            if (response.ok) {
            	document.getElementById("registrationForm").reset();
                return response.json();
            } else {
                throw new Error("Could not reach the API: " + response.statusText);
            }
        }).then(function(data) {
        	console.log(data);
        	alert("user registration successful");
            /*document.getElementById("message").innerHTML = data.encoded;*/
        }).catch(function(error) {
        	alert("Some error occurred, Please try again later");
            /*document.getElementById("message").innerHTML = error.message;*/
        });
    return true;
}