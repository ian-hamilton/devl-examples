<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>

</head>
<body>

<script>
function callback(employee) {
	$("#employeeIdText").val(employee.employeeId);
	$("#firstNameText").val(employee.firstName);
	$("#lastNameText").val(employee.lastName);
	$("#titleText").val(employee.title);
	$("#ssText").val(employee.socialSecurity);
}

function EmployeeModel(employeeId, firstName, lastName, title, socialSecurity) {
	this.employeeId = employeeId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.title = title;
	this.socialSecurity = socialSecurity;
}

$("document").ready(function(){
	$("#submitFindBtn").click(function() {
		var uri = "/restful-service-example/employee/" + $("#employeeIdText").val();
		$.ajax({
		    type: "GET",
		    url: uri,
		    success: function(data){
		    	callback(data);
		    },
		    failure: function(errMsg) {
		        alert(errMsg);
		    }
		});
	});
	
	$("#submitUpdateBtn").click(function() {
		var uri = "/restful-service-example/employee/" + $("#employeeIdText").val();
		var myemployee = new EmployeeModel($("#employeeIdText").val(),
				$("#firstNameText").val(),
				$("#lastNameText").val(),
				$("#titleText").val(),
				$("#ssText").val()
		);
		$.ajax({
		    type: "POST",
		    url: uri,
	        data: JSON.stringify(myemployee),
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
		    success: function(data){
		    	callback(data);
		    },
		    failure: function(errMsg) {
		        alert(errMsg);
		    }
		});
	});
	
	$("#submitNewBtn").click(function() {
		var uri = "/restful-service-example/employee/";
		var myemployee = new EmployeeModel(null,
				$("#firstNameText").val(),
				$("#lastNameText").val(),
				$("#titleText").val(),
				$("#ssText").val()
		);
		$.ajax({
		    type: "PUT",
		    url: uri,
	        data: JSON.stringify(myemployee),
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
		    success: function(rdata){
		    	callback(rdata);
		    },
		    failure: function(errMsg) {
		        alert(errMsg);
		    }
		});
	});
	
	$("#submitAllBtn").click(function() {
		$("#allDiv").empty();
		var uri = "/restful-service-example/employee/";
		$.ajax({
		    type: "GET",
		    url: uri,
		    success: function(data){
		    	 $.each(data, function(i, emp){
		    	     $("#allDiv").append(emp.employeeId + " " + emp.firstName + " " + emp.lastName  + " " + emp.title + " " + emp.socialSecurity).append("<br>");
		    	 });
		    },
		    failure: function(errMsg) {
		        alert(errMsg);
		    }
		});
	});
});
</script>

<fieldset>
	<legend>Employee</legend>
	Employee Id:<input type="text" id="employeeIdText"/><br>
	First Name:<input type="text" id="firstNameText"/><br>
	Last Name:<input type="text" id="lastNameText"/><br>
	Title:<input type="text" id="titleText"/><br>
	SS#:<input type="text" id="ssText"/><br>
	<input type="button" id="submitFindBtn" value="find"/>
	<input type="button" id="submitUpdateBtn" value="update"/>
	<input type="button" id="submitNewBtn" value="new"/>
	<input type="button" id="submitAllBtn" value="Show All"/>
</fieldset>

<div id="allDiv">

</div>

</body>
</html>
