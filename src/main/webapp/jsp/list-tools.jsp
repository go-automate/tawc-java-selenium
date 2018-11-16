<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css">   		
        <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <!-- Custom styles for this template -->
        <link href="../css/theme.css" rel="stylesheet">
        <title>Tools Page</title>
    </head>

    <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="https://safebear.co.uk/">SafeBear</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/add-ex.html">Additional Exercises</a></li>

                        <li class="active"><a href="/">Logout</a></li>

                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

    <div class="container">
        <p></p>
        <p><b>Login Successful</b></p>
        <div class="jumbotron">
            <h1>Welcome Tester!</h1>
            <p>Here's a list of our favourite automation tools, why not try adding, deleting and searching the list using your automation skills? </p>
        </div>
            <h2>Search Here</h2>
            <!--Search Form -->
            <form action="/tools" method="get" id="seachToolForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="toolName" id="toolName" class="form-control" required="true" placeholder="Type the Name or Use of the tool"/>
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
                <br></br>
                <br></br>
            </form>

            <!--Tools List-->
            <c:if test="${not empty message}">                
                <div class="alert alert-success">
                    ${message}
                </div>
            </c:if> 
            <form action="/tools" method="post" id="toolForm" role="form" >
                <input type="hidden" id="idTool" name="idTool">
                <input type="hidden" id="action" name="action">
                <c:choose>
                    <c:when test="${not empty toolList}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Name</td>
                                    <td>Use</td>
                                    <td>Website</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <c:forEach var="tool" items="${toolList}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${idTool == tool.id}">
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>
                                        <a href="/tools?idTool=${tool.id}&searchAction=searchById">${tool.id}</a>
                                    </td>                                    
                                    <td>${tool.name}</td>
                                    <td>${tool.use}</td>
                                    <td>${tool.website}</td>
                                    <td><a href="#" id="remove" 
                                           onclick="document.getElementById('action').value = 'remove';document.getElementById('idTool').value = '${tool.id}';
                                                    
                                                    document.getElementById('toolForm').submit();">
                                            <span class="glyphicon glyphicon-trash"/>
                                        </a>
                                                   
                                    </td>
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No tools found matching your search criteria
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            <form action ="jsp/new-tool.jsp">
                <br></br>
                <button type="submit" class="btn btn-primary  btn-md">New Tool</button>
            </form>
            <br></br>

        <div class="jumbotron">
            <h2>Additional Exercises</h2>
             <p>Bored already? Try some new challenges with our Additional Exercises</p>
             <form action="/add-ex.html">
                <br></br>
                <button type="submit" class="btn btn-lg btn-success">Additional Exercises</button>
             </form>
        </div>
        </div>
    </body>
</html>