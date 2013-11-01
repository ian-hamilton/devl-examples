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
	
	$("#submitDeleteBtn").click(function() {
		var uri = "/restful-service-example/employee/" + $("#employeeIdText").val();
		$.ajax({
		    type: "DELETE",
		    url: uri,
		    success: function(data){
		    	callback(data);
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