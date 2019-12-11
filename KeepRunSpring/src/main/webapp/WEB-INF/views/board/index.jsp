<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 


<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>KeepRun - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

  
 <%@include file="../etc/sidebar.jsp"%>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
         
            <h1 class="h3 mb-0 text-gray-800">${dayWorkProcessData.workDate} WorkOut Data</h1>
           <!--  <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a> -->
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Work Intensity (60%~75% is good)</div>
                      <input type="hidden" id="workIntensity" value="${dayWorkProcessData.workIntensity}">
                        <script src="<c:url value="/resources/js/workIntensityIf.js"/>"></script>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${dayWorkProcessData.workIntensity} % <br><script>resultStatus();</script> </div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-calendar fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-success text-uppercase mb-1">Distance</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${dayWorkProcessData.distance} m</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Average HeartRate</div>
                      <div class="row no-gutters align-items-center">
                        <div class="col-auto">
                          <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${dayWorkProcessData.avgHR} bpm</div>
                        </div>
                        <div class="col">
                         <!--  <div class="progress progress-sm mr-2">
                            <div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                          </div> -->
                        </div>
                      </div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pending Requests Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">Workout Time</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${dayWorkProcessData.workTime} Minutes</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-comments fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Content Row -->

          <div class="row">

            <!-- Area Chart -->
             <c:forEach items="${weekKcal}" var="kcal" varStatus="status" begin="0" end="6">
         	  <input type="hidden" id="kcal${status.index}"  value="${kcal}" >
            </c:forEach>
            
            
            <div class="col-xl-8 col-lg-7">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Week Burned Kcal</h6>
                <!--   <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                      <div class="dropdown-header">Dropdown Header:</div>
                      <a class="dropdown-item" href="#">Action</a>
                      <a class="dropdown-item" href="#">Another action</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                  </div> -->
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-area">
                    <canvas id="myAreaChart"></canvas>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pie Chart -->
          
            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Remaining Weight</h6>
                  <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                      <div class="dropdown-header">Dropdown Header:</div>
                      <form method=post>
                      <div id="weight">
                          <a class="dropdown-item" href="#">Target Weight:<input type="text" id="targetWeight" name="userTargetWeight" value="${userInfo.userTargetWeight}" style="width:40px; height:20px;"></a>
	                      <a class="dropdown-item" href="#">Current Weight:<input type="text" id="currentWeight" name="userCurrentWeight"  value="${userInfo.userCurrentWeight}" style="width:40px; height:20px;"></a>
	                      <input type="hidden" id="startWeight" name="startWeight"  value="${userInfo.userWeight}" style="width:40px; height:20px;"></a>
	                       <input type="hidden" name="deviceId"  value="${userInfo.deviceId}" style="width:40px; height:20px;"></a>
	                      <a class="dropdown-item" href="#"> <input type="submit" style="width:120px; height:20px;" value="Confirm"></a>
	                   </div>
	                   </form>
	                 
                    
                     <div class="dropdown-divider"></div>
                     <!--  <a class="dropdown-item" href="#">Something else here</a> -->
                    </div> 
                    
                  </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-pie pt-4 pb-2">
                    <canvas id="myPieChart"></canvas>
                  </div>
                  <div class="mt-4 text-center small">
                    <span class="mr-2">
                      <i class="fas fa-circle text-primary"></i>Remained Weight
                    </span>
                    <span class="mr-2">
                      <i class="fas fa-circle text-success"></i>Current Weight
                    </span>
                    <!-- <span class="mr-2">
                      <i class="fas fa-circle text-info"></i> Referral
                    </span> -->
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->
        
      </div>
   	 <c:forEach items="${dayDeviceData}" var="DayDeviceData" varStatus="status">
          <input type="hidden" id="gpsLatitude${status.index}"  value="${DayDeviceData.gpsLatitude}" >
          <input type="hidden" id="gpsLongitude${status.index}"  value="${DayDeviceData.gpsLongitude}" >
       </c:forEach>
        <input type="hidden" id="gpsCount"  value="${fn:length(dayDeviceData)}" >
      
      <div id="map" style="width:100%;height:350px;"></div>
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
  


  <!-- Bootstrap core JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

  <!-- Core plugin JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

  <!-- Custom scripts for all pages-->
  <script src="<c:url value="/resources/js/sb-admin-2.min.js"/>"></script>

  <!-- Page level plugins -->
  <script src="<c:url value="/resources/vendor/chart.js/Chart.min.js"/>"></script>

  <!-- Page level custom scripts -->
  <script src="<c:url value="/resources/js/demo/chart-area-demo.js"/>"></script>
  <script src="<c:url value="/resources/js/demo/chart-pie-demo.js"/>"></script>
  <!--  Map -->
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7f4606bd3d5b1a196067643559d14eb2"></script>
  <script src="<c:url value="/resources/js/kakaoMap.js"/>"></script>
  
  <script>
   	 		chartPie();
            function changeValue() {
            	document.getElementById("targetWeight").value=document.getElementById("targetWeight").value;
    			document.getElementById("currentWeight").value=document.getElementById("currentWeight").value;
    			chartPie();
    		}
            
            
 </script>
 

</body>

</html>
