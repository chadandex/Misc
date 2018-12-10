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
        <title>LIS Exercise</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/styles.css?v=2" type="text/css" rel="stylesheet">
    </head>
    <body>
        <div align="center">
            <h1>Enter User Data</h1>
        </div>
        <hr/>
        <div class="container">
            <div class="col-md-6">
                <h2>Add New User</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createPerson">
                    <div class="form-group">
                        <label for="add-name" class="col-md-4 control-label">Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="personName" placeholder="Name" maxlength="30" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-age" class="col-md-4 control-label">Age:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="personAge" placeholder="Age" maxlength="3"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-title" class="col-md-4 control-label">Title:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="personTitle" placeholder="Title" maxlength="30" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-hometown" class="col-md-4 control-label">Hometown:</label>
                        <div class="col-md-8">
                            <input type="lat" class="form-control" name="personHTown" placeholder="Hometown" maxlength="45"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Submit Info"/>
                        </div>
                    </div>
                </form>

            </div> <!-- End col div -->
        </div> <!-- End container -->

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
