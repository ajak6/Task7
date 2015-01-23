<jsp:include page="template-employee.jsp" />
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Employee Create Fund:</h3>
                    </div>
                    <div class="panel-body" action="create_fund.doe">
                        <form role="form">
                            <fieldset>
                            <div class="form-group">
                                    <input class="form-control" placeholder="Fund Symbol:" name="fundSym" type="text" autofocus>
                                </div>

                                <div class="form-group">
                                    <input class="form-control" placeholder="Fund Name" name="fundName" type="text" >
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
				                <label>
                                      <button type="submit" class="btn btn-primary">Add</button>
                                </label>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="template-bottom.jsp" />