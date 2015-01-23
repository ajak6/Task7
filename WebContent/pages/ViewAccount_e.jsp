<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="databeans.Position"%>
<%@ page import="databeans.Customer"%>
<%@ page import="databeans.Fund"%>
<%@ page import="databeans.Fund_Price_History"%>
<jsp:include page="template-employee.jsp" />
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"> User Profile</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                            <div class="input-group custom-search-form">
                            <form action="view_account_e.doe">
                            <input type="text" class="form-control" id="username" placeholder="Username...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </form>
                            </div>
                </div>
            </div>
            <c:if test="${item['target']!=null}">
            <div class="row">
                <div class="col-lg-8">
                    <table class="table">
                <tbody>
                    <tr class="active">
                        <td>
                            Name:
                        </td>
                        <td>
                            <c:out value="${target.customerName}" />
                        </td>
                    </tr>
                    <tr class="success">
                        <td>
                            Address
                        </td>
                        <td>
                             <c:out value="${target.addr_line1}+,+${target.addr_line2}+,+${target.city}" />
                        </td>
                    </tr>
                    <tr class="active">
                        <td>
                            Last Trading Day
                        </td>
                        <td>
                            <c:out value="${date}" />
                        </td>
                    </tr>
                    <tr class="success">
                        <td>
                            Cash Balance ($)
                        </td>
                        <td>
                           <c:out value="${target.cash}" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <table class="table">
                <thead>
                    <tr>
                        <th>
                            Fund
                        </th>
                        <th>
                            Shares
                        </th>
                        <th>
                            Value
                        </th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var = "fundInfo" items = "${fundInfoList}">
                    <tr class="danger">
                        <td>
                            ${fundInfo.fund_id}
                        </td>
                        <td>
                            ${fundInfo.shares}
                        </td>
                        <td>
                            ${fundInfo.price}
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
                </div>
            </div>
            </c:if>
            <!-- /.row -->
        </div>
        <jsp:include page="template-bottom.jsp" />