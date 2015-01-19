<jsp:include page="template-customer.jsp" />
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Request Check</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form role="form">
								<div class="form-group">
									<label>Current Balance: </label>
									<p class="form-control-static">10000</p>
								</div>
								<div class="form-group">
									<label>Cash to withdrawal</label> <input class="form-control"
										placeholder="Enter amount">
								</div>
								<button type="submit" class="btn btn-default">Submit
									Button</button>
							</form>
						</div>
					</div>
					<!-- /.row (nested) -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->

<jsp:include page="template-bottom.jsp" />
