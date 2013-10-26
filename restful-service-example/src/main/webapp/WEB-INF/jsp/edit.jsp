<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form commandName="calculationModel">
	<table>
		<tr>
			<td><form:input path="value1" size="2"/></td>
			<td><form:select path="operator" items="${operatorModel.operators}"/></td>
			<td><form:input path="value2" size="2"/></td>
		</tr>
		<tr><td><input type="submit" value="Calculate" /></td></tr>
		<tr><td>${result}</td></tr>
	</table>
</form:form>