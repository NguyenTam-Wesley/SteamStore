<%@ include file="../init.jsp" %>

<style>
.publisher-table {
	width: 100%;
	border-collapse: collapse;
}

.publisher-table th, .publisher-table td {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
}

.publisher-table th {
	background-color: #f2f2f2;
	min-width: 150px;
}

.publisher-table td {
	min-width: 250px;
}

.publisher-table a {
	color: #007bff;
	text-decoration: none;
}
</style>

<aui:fieldset>
	<h1 class="publisher-details">Publisher Details</h1>

	<aui:form>
		<table class="publisher-table">
			<tr>
				<th>Publisher ID</th>
				<td>valve</td>
			</tr>
			<tr>
				<th>Publisher Name</th>
				<td>Valve</td>
			</tr>
			<tr>
				<th>Website</th>
				<td><a href="https://www.valvesoftware.com/">https://www.valvesoftware.com/</a></td>
			</tr>
			<tr>
				<th>About</th>
				<td>Valve's debut title, Half-Life, was released in 1998. It
					won more than 50 game of the year awards, and PC Gamer even called
					it the Best PC Game Ever. Since then, we've released dozens of
					titles that changed the world. Today, millions of people play our
					games every day.</td>
			</tr>
		</table>
	</aui:form>
</aui:fieldset>