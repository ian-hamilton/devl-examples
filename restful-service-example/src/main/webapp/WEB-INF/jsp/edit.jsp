<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 <script type="text/javascript" src="<c:url value="/js/employee.js"/>"></script> 

<fieldset>
	<legend><span>Employee</span></legend>
	Employee Id:<input type="text" id="employeeIdText"/><br>
	First Name:<input type="text" id="firstNameText"/><br>
	Last Name:<input type="text" id="lastNameText"/><br>
	Title:<input type="text" id="titleText"/><br>
	SS#:<input type="text" id="ssText"/><br>
	<input type="button" id="submitFindBtn" value="Find"/>
	<input type="button" id="submitUpdateBtn" value="Update"/>
	<input type="button" id="submitNewBtn" value="New"/>
	<input type="button" id="submitDeleteBtn" value="Delete"/>
	<input type="button" id="submitAllBtn" value="Show All"/>	
</fieldset>

<div id="allDiv">

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
