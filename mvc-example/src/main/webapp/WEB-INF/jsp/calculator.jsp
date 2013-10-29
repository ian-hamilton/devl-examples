<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form commandName="calculationModel">
	<table>
		<tr>
			<td><form:input path="value1" size="2"/></td>
			<form:errors path="value1" cssClass="errors" />
			<td><form:select path="operator" items="${operatorModel.operators}"/></td>
			<td><form:input path="value2" size="2"/></td>
			<form:errors path="value2" cssClass="errors" />
		</tr>
		<tr><td><input type="submit" value="Calculate" /></td></tr>
		<tr><td>${result}</td></tr>
	</table>
</form:form>