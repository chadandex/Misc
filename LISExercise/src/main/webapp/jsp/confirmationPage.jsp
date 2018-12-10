<%-- 
    Author     : Chad
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Confirmation</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="${pageContext.request.contextPath}/css/styles.css?v=2" type="text/css" rel="stylesheet">
    </head>
    <body>
        <h1 align="center">User Confirmed!</h1>
        <hr/>
        <div class="container">
            <div class="col-md-6">
                <h2>Previous Entries</h2>
                <table id="userTable" class="table table-bordered">
                    <tr>
                        <th width="40%">Name</th>              
                        <th width="15%">Age</th>
                        <th width="15%">Title</th>
                        <th width="15%">Hometown</th>
                        <th id="removeTesting" width="15%"></th>

                    </tr>
                    <c:forEach var="currentPerson" items="${personList}">
                        <tr>
                            <td>
                                <c:out value="${currentPerson.personName}"/>
                            </td>
                            <td>
                                <c:out value="${currentPerson.personAge}"/>
                            </td>
                            <td>
                                <c:out value="${currentPerson.personTitle}"/>
                            </td>
                            <td>
                                <c:out value="${currentPerson.personHTown}"/>
                            </td>
                            <td id="removeTesting">
                                <a href="removePerson?personId=${currentPerson.personId}">
                                    Delete
                                </a>
                            </td>

                        </tr>
                    </c:forEach>
                </table> 
            </div>
            <!-- Submitted info -->
            <div class="col-md-6">
                <h2>Confirmed User Info</h2>
                <p><b>Name:</b> <c:out value="${currentP.personName}"/></p>
                <p><b>Age:</b> <c:out value="${currentP.personAge}"/></p>
                <p><b>Title:</b> <c:out value="${currentP.personTitle}"/></p>
                <p><b>Hometown:</b> <c:out value="${currentP.personHTown}"/></p>
            </div>


        </div>
        <div align="center">
            <a href="${pageContext.request.contextPath}/displayHomePage">
                <input type="button" class="btn btn-default" value="Back"/>
            </a>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
