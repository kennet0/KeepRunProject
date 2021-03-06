<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>KeepRun - Tables</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>
<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">
	<!--  sidebar -->
   <%@include file="../etc/sidebar.jsp"%>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Tables</h1>
         <!--   <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>
-->
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>WorkDate</th>
                      <th>WorkTime</th>
                      <th>Distance</th>
                      <th>Kcal</th>
                      <th>AvgHR</th>
                      <th>MaxHR</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>WorkDate</th>
                      <th>WorkTime</th>
                      <th>Distance</th>
                      <th>Kcal</th>
                      <th>AvgHR</th>
                      <th>MaxHR</th>
                    </tr>
                  </tfoot>
                 
                  <tbody>
                   
                 <!--  <form action="indexOne" name="workProcessVO"method="post"> -->
                  <c:forEach items="${wList}" var= "WorkProcessVO">
                 <!--  <tr onclick="javascript:document.workProcessVO.submit();"> -->
                 <form name="paging">
                 <input type="hidden" name="deviceId"/>
                 <input type="hidden" name="bno"/>
                 <input type="hidden" name="workDate"/>
                 </form>
                  <tr onclick="location.href='indexOne?deviceId=${WorkProcessVO.deviceId}&workDate=${WorkProcessVO.workDate}'">
                      <td>${WorkProcessVO.workDate}</td>
                      <td>${WorkProcessVO.workTime}</td>
                      <td>${WorkProcessVO.distance}</td>
                      <td>${WorkProcessVO.kcal}</td>
                      <td>${WorkProcessVO.avgHR}</td>
                      <td>${WorkProcessVO.workIntensity}</td>
                      
                  </tr>
                  </c:forEach>
                  <!-- </form>  -->                   
                  </tbody>
                 
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

    <%@include file="../etc/footer.jsp"%>

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>





  	<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
	
	<script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />"></script>
	<script src="<c:url value="/resources/js/sb-admin-2.min.js" />"></script>
	
	  <!-- Page level plugins -->
  	<script src="<c:url value="/resources/vendor/datatables/jquery.dataTables.min.js" />"></script>
  	<script src="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.js" />"></script>

  	<!-- Page level custom scripts -->
  	<script src="<c:url value="/resources/js/demo/datatables-demo.js" />"></script>
	
</body>

</html>
