<!DOCTYPE html>
<html>
<head>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <title>UO Ratio Calculator</title>
    <link rel="shortcut icon" href="http://forums.unitedoperations.net/favicon.ico">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-overwrite.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


    <!-- Latest compiled and minified JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/npm.js"></script>
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="https://code.jquery.com/ui/1.11.3/jquery-ui.min.js"></script>

</head>
<body role="document" style="padding-top: 70px;">


<div class="container theme-showcase" role="main">
    <div class="jumbotron">
        <div class="row">
            <div class="col-lg-12">

                <h1 id="title">United Operations Ratio Calculator</h1>


                <p>Enter the amount of players and the desired ratios.</p>

                <div class="panel panel-default">
                    <div class="panel-body">
                        <form action="/calculate" method="POST">
                            <div class="row">

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="bluforid">Blufor Ratio</label>
                                        <input type="number" name="blufor" min="0" step="0.01" class="form-control" onpaste="return false;" id="bluforid" value="<c:out value="${sessionScope.bluforR}"/>">
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                         <label for="redforid">Redfor Ratio</label>
                                         <input type="number" name="redfor" min="0" step="0.01" class="form-control " onpaste="return false;" id="redforid"  value="<c:out value="${sessionScope.redforR}"/>">
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                      <label for="indyid">Independent Ratio</label>
                                       <input type="number" name="indy" min="0" step="0.01" class="form-control " onpaste="return false;" id="indyid"  value="<c:out value="${sessionScope.indyR}"/>">
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="civid">Civilian Ratio. <small>Check for Zeus(will subtract)(not done yet)</small></label>


                                           <div class="input-group">
                                                 <span class="input-group-addon">
                                                   <input type="checkbox" aria-label="...">
                                                 </span>
                                                  <input type="number" name="civ" min="0" step="0.01" class="form-control " onpaste="return false;" id="civid"  value="<c:out value="${sessionScope.civR}"/>">
                                               </div>
                                    </div>
                                </div>
                            </div>



                                <div class="form-group">
                                        <label for="total">Players</label>
                                        <input type="number" min="0" required="true" name="total" class="form-control input-block-level" id="total" value="<c:out value="${sessionScope.total}"/>" />
                                     </div>




                                <div class="form-group">
                                  <button type="submit" id="calculate" class="btn btn-primary btn-lg btn-block" style="margin-top:20px">Calculate</button>
                                </div>



                        </form>

                            <p>Player Distribution:</p>
                            <div class="progress">
                                <div class="progress-bar blufor"  title="Original ratio:  <c:out value="${sessionScope.bluforR}"/>"  style="width:  <c:out value="${sessionScope.bluforPerc}"/>%;"  >
                                <span > <c:out value="${sessionScope.bluforP}"/></span>
                                </div>

                                <div class="progress-bar redfor"  title="Original ratio:  <c:out value="${sessionScope.redforR}"/>"  style="width: <c:out value="${sessionScope.redforPerc}"/>%%">
                                <span ><c:out value="${sessionScope.redforP}"/></span>
                                </div>

                                <div class="progress-bar  indy"  title="Original ratio:  <c:out value="${sessionScope.indyR}"/>"  style="width: <c:out value="${sessionScope.indyPerc}"/>%">
                                <span ><c:out value="${sessionScope.indyP}"/></span>
                                </div>

                                <div class="progress-bar civ hint--bottom" title="Original ratio:  <c:out value="${sessionScope.civR}"/>"   style="width: <c:out value="${sessionScope.civPerc}"/>%">
                                <span ><c:out value="${sessionScope.civP}"/> </span>
                                </div>
                            </div>
                            <p> <c:out value="${sessionScope.spill}"/> </p>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
