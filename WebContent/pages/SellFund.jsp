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
					<c:forEach var="fundInfo" items="${fundInfoList}">
						<tr class="active">
							<form method="POST" action="sellfund.doc">
							<td>fundInfo.name<input type="hidden" name="fundToSell" value="${fundInfo.fund_id}" /></td>
							<td>fundInfo.shares</td>
							<td><input type="number" name="sellshare"></td>
						    <td><input type="submit" value="Sell" /></td>
							</form>
						</tr>
					</c:forEach>
				</tbody>
			</table>


		</div>
	</div>
	<!-- /.row -->
</div>
<jsp:include page="template-bottom.jsp" />