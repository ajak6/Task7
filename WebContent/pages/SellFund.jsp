<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="databeans.Position"%>
<%@ page import="databeans.Fund"%>

<jsp:include page="template-customer.jsp" />
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">User Profile</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-8">
			<table class="table">
				<thead>
					<tr>
						<th>Fund</th>
						<th>Shares</th>
						<th>Amount to Sell</th>
						<th>Sell</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="position" items="${positionList}">
						<tr class="active">
							<form method="POST" action="sellfund.do">
							<td>position.fund_id<input type="hidden" name="fundToSell" value="${position.fund_id}" /></td>
							<td>position.shares</td>
							<td><input type="number" name="sellshare"></td>
						    <td><input type="submit" value="Sell" /></td>
							</form>
						</tr>
						

					</c:forEach>
				</tbody>
			</table>

			<table class="table">
				<tbody>
					<tr class="active">
						<td>Name</td>
						<td>Stella Long</td>
					</tr>
					<tr class="success">
						<td>Address</td>
						<td>3000 Centre Ave, Apt. 101</td>
					</tr>
					<tr class="active">
						<td>Last Trading Day</td>
						<td>01/10/2015</td>
					</tr>
					<tr class="success">
						<td>Cash Balance ($)</td>
						<td>100,000,000</td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
	<!-- /.row -->
</div>
<jsp:include page="template-bottom.jsp" />