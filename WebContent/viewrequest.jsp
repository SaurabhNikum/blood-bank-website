<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@page import="db_Blood_Package.*"%>

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
                 <a  href="viewmybloodbank.jsp"><i class="fa fa-edit fa-3x"></i>View My Bank Details</a>
                    </li>			
				  <li>
					  <li>
                        <a  href="addbloodbankcamp.jsp"><i class="fa fa-edit fa-3x"></i>Add BloodBank Camp</a>
                    </li>
                    <li>
                        <a  href="viewcamp.jsp"><i class="fa fa-edit fa-3x"></i>View Blood Bank Camps</a>
                    </li>
                     <li>
                        <a  href="updatestock.jsp"><i class="fa fa-edit fa-3x"></i>Update Blood Stock</a>
                    </li>
                     <li>
                        <a  href="viewrequest.jsp"><i class="fa fa-edit fa-3x"></i>View/Approve/Disapprove Request</a>
                    </li>
                   
	                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        
      <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
         		<h2>&nbsp&nbspView Blood Bank Camp</h2>
           <div class="col-md-12">
                                              
						<table border="1" id="displaytable" class="table table-bordered" style="display.none" >
								          <thead>
								          <tr>
								          				<th>RID</th>
								        			    <th>UNAME</th>
														<th>UCONTACT</th>
														<th>UBLOODGROUP</th>
														<th>BID</th>
														<th>BNAME</th>
														<th>APPROVE</th>
														<th>DISAPPROVE</th>
													
								          </tr>
								          <% 
                                          Statement statement = null;
                                          ResultSet resultSet = null;
                                          %>
                                          <%
                                          try{
                                          Connection conn=Bank_Database.Connect();
                                          statement=conn.createStatement();
                                          String sql ="select * from request";
                                          resultSet = statement.executeQuery(sql);
                                          while(resultSet.next()){
                                          %>
                                          <tbody>
                                                   <tr>
                                                   <td><%=resultSet.getString("rid") %></td>
                                                   <td><%=resultSet.getString("uname") %></td>
                                                   <td><%=resultSet.getString("ucontact1") %></td>
                                                   <td><%=resultSet.getString("bloodgroup") %></td>
                                                   <td><%=resultSet.getString("bid1") %></td>
                                                   <td><%=resultSet.getString("bname1") %></td>
                                                   
                                                   <td><a href="deleterequest.jsp?id10=<%=resultSet.getString("rid") %>" onclick="return confirm_alert(this);">Approve</a></td>
									 			   <td><a href="viewrequest.jsp?idid=<%=resultSet.getString("rid") %>" onclick="return confirm_alert(this);">Disapprove</a></td>
									
                                                   </tr>
                                          </tbody>
                                                   <%
                                                   }
                                                   //connection.close();
                                                   } catch (Exception e) {
                                                   e.printStackTrace();
                                                   }
                                                   %>
								          
										</thead>
				 </table>                  
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