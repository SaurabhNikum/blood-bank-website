-<%@page import="java.util.*" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>HAMARA SABKA BLOOD BANK</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

</head>
<body onload="access()">
<%
//AbstractDao abstractDao=new AbstractDao();
%>

    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" style="font-size:19px" href="#">HAMARA SABKA BLOOD BANK</a> 
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;"> &nbsp; <a href="index.jsp" class="btn btn-danger square-btn-adjust">Logout</a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
             <ul class="nav" id="main-menu">
				<li class="text-center">
            <img src="assets/img/find_user.png" class="user-image img-responsive" style="height: 100px;"/>
				</li>
				  <li>
                        <a  href="addbloodbank.jsp"><i class="fa fa-edit fa-3x"></i>Add Blood Bank</a>
                    </li>
                    <li>
                        <a  href="viewbloodbank.jsp"><i class="fa fa-edit fa-3x"></i>View Blood Bank</a>
                    </li>
                     <li>
                        <a  href="viewuser.jsp"><i class="fa fa-edit fa-3x"></i>View User</a>
                    </li>
                     <li>
                        <a  href="healthtips.jsp"><i class="fa fa-edit fa-3x"></i>Add Health Tips</a>
                    </li>
                     <li>
                        <a  href="viewhealthtips.jsp"><i class="fa fa-edit fa-3x"></i>View Health Tips</a>
                    </li>                    

                    
	                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        
      <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
         		<h2>&nbsp&nbspAdd Health Tips</h2>
         		 <div class="col-md-12">
          <div class="card">
        <form action="AddHealthTipsServlet" method="post">
                
                <div class="form-group row">
                <input type="hidden" name="action" value="add"/>
    			<label for="inputEmail3" class="col-sm-3 form-control-label">Health Tips</label>
                  <div class="col-sm-9">
                    <textarea  name="htips" placeholder="Enter Health tips"  required></textarea>
                  </div>
                </div>
                <div class="form-group row m-b-0">
                  <div class="col-sm-offset-3 col-sm-9">
                    <button type="submit" class="btn btn-primary">Add Health tips</button>
                  </div>
                </div>
                

                
              </form>
            </div>
        </div>
         		</div>
                   
                </div>
                                       
	 </div>
					                    </div>                                           
                                         
                    </div>
               
           
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>

   
</body>
</html>
