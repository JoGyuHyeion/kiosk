<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">

        <link rel="shortcut icon" href="assets/images/favicon.ico">

        <title>Zircos - Responsive Admin Dashboard Template</title>

        <!--Morris Chart CSS -->
		<link rel="stylesheet" href="../plugins/morris/morris.css">

        <!-- App css -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/core.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/components.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/menu.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="../plugins/switchery/switchery.min.css">

        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <script src="assets/js/modernizr.min.js"></script>

    </head>


    <body>


        <!-- Navigation Bar-->
        <header id="topnav">
            <div class="topbar-main">
                <div class="container">

                    <!-- Logo container-->
                    <div class="logo">
                        <!-- Text Logo -->
                        <!--<a href="index.html" class="logo">-->
                            <!--Zircos-->
                        <!--</a>-->
                        <!-- Image Logo -->
                        <a href="index.html" class="logo">
                            <img src="assets/images/logo.png" alt="" height="30">
                        </a>

                    </div>
                    <!-- End Logo container-->


                    <div class="menu-extras">

                        <ul class="nav navbar-nav navbar-right pull-right">
                            <li class="navbar-c-items">
                                <form role="search" class="navbar-left app-search pull-left hidden-xs">
                                     <input type="text" placeholder="Search..." class="form-control">
                                     <a href=""><i class="fa fa-search"></i></a>
                                </form>
                            </li>

                            <li class="dropdown navbar-c-items">
                                 <a href="#" class="right-menu-item dropdown-toggle" data-toggle="dropdown">
                                    <i class="mdi mdi-email"></i>
                                    <span class="badge up bg-danger">8</span>
                                </a>

                                <ul class="dropdown-menu dropdown-menu-right arrow-dropdown-menu arrow-menu-right dropdown-lg user-list notify-list">
                                    <li class="text-center">
                                        <h5>Messages</h5>
                                    </li>
                                    <li>
                                        <a href="#" class="user-list-item">
                                            <div class="avatar">
                                                <img src="assets/images/users/avatar-2.jpg" alt="">
                                            </div>
                                            <div class="user-desc">
                                                <span class="name">Patricia Beach</span>
                                                <span class="desc">There are new settings available</span>
                                                <span class="time">2 hours ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="user-list-item">
                                            <div class="avatar">
                                                <img src="assets/images/users/avatar-3.jpg" alt="">
                                            </div>
                                            <div class="user-desc">
                                                <span class="name">Connie Lucas</span>
                                                <span class="desc">There are new settings available</span>
                                                <span class="time">2 hours ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="user-list-item">
                                            <div class="avatar">
                                                <img src="assets/images/users/avatar-4.jpg" alt="">
                                            </div>
                                            <div class="user-desc">
                                                <span class="name">Margaret Becker</span>
                                                <span class="desc">There are new settings available</span>
                                                <span class="time">2 hours ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="all-msgs text-center">
                                        <p class="m-0"><a href="#">See all Messages</a></p>
                                    </li>
                                </ul>
                            </li>

                            <li class="dropdown navbar-c-items">
                                 <a href="#" class="right-menu-item dropdown-toggle" data-toggle="dropdown">
                                    <i class="mdi mdi-bell"></i>
                                    <span class="badge up bg-success">4</span>
                                </a>

                                <ul class="dropdown-menu dropdown-menu-right arrow-dropdown-menu arrow-menu-right dropdown-lg user-list notify-list">
                                    <li class="text-center">
                                        <h5>Notifications</h5>
                                    </li>
                                    <li>
                                        <a href="#" class="user-list-item">
                                            <div class="icon bg-info">
                                                <i class="mdi mdi-account"></i>
                                            </div>
                                            <div class="user-desc">
                                                <span class="name">New Signup</span>
                                                <span class="time">5 hours ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="user-list-item">
                                            <div class="icon bg-danger">
                                                <i class="mdi mdi-comment"></i>
                                            </div>
                                            <div class="user-desc">
                                                <span class="name">New Message received</span>
                                                <span class="time">1 day ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="user-list-item">
                                            <div class="icon bg-warning">
                                                <i class="mdi mdi-settings"></i>
                                            </div>
                                            <div class="user-desc">
                                                <span class="name">Settings</span>
                                                <span class="time">1 day ago</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="all-msgs text-center">
                                        <p class="m-0"><a href="#">See all Notification</a></p>
                                    </li>
                                </ul>
                            </li>

                            <li class="dropdown navbar-c-items">
                                <a href="" class="dropdown-toggle waves-effect waves-light profile" data-toggle="dropdown" aria-expanded="true"><img src="assets/images/users/avatar-1.jpg" alt="user-img" class="img-circle"> </a>
                                <ul class="dropdown-menu dropdown-menu-right arrow-dropdown-menu arrow-menu-right user-list notify-list">
                                    <li class="text-center">
                                        <h5>Hi, John</h5>
                                    </li>
                                    <li><a href="javascript:void(0)"><i class="ti-user m-r-5"></i> Profile</a></li>
                                    <li><a href="javascript:void(0)"><i class="ti-settings m-r-5"></i> Settings</a></li>
                                    <li><a href="javascript:void(0)"><i class="ti-lock m-r-5"></i> Lock screen</a></li>
                                    <li><a href="javascript:void(0)"><i class="ti-power-off m-r-5"></i> Logout</a></li>
                                </ul>

                            </li>
                        </ul>
                        <div class="menu-item">
                            <!-- Mobile menu toggle-->
                            <a class="navbar-toggle">
                                <div class="lines">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </div>
                            </a>
                            <!-- End mobile menu toggle-->
                        </div>
                    </div>
                    <!-- end menu-extras -->

                </div> <!-- end container -->
            </div>
            <!-- end topbar-main -->

            <div class="navbar-custom">
                <div class="container">
                    <div id="navigation">
                        <!-- Navigation Menu-->
                        <ul class="navigation-menu">
                            <!-- 기초설정 -->
                            <li class="has-submenu">
                                <a href="#"><i class="mdi mdi-google-pages"></i>기초설정</a>
                                <ul class="submenu megamenu">
                                    <li>
                                        <ul>
                                            <li><a href="myinfo_pswd.html">비밀번호변경</a></li>
                                            <li><a href="section_set.html">과관리</a></li>
                                            <li><a href="page-register.html">Kiosk배경화면</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                              <!-- 직원등록 -->
                              <li class="has-submenu">
                                <a href="#"><i class="mdi mdi-google-pages"></i>직원등록</a>
                                <ul class="submenu megamenu">
                                    <li>
                                        <ul>
                                            <li><a href="staff_table.html">직원등록</a></li>
                                            <li><a href="staff_modifyPage.html">직원조희</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <!-- 갤러리 -->
                            <li class="has-submenu">
                                <a href="#"><i class="mdi mdi-google-pages"></i>갤러리</a>
                                <ul class="submenu megamenu">
                                    <li>
                                        <ul>
                                            <li><a href="page-starter.html">갤러리등록</a></li>
                                            <li><a href="gallery_table.html">갤러리조희</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                             <!-- 동영상 -->
                             <li class="has-submenu">
                                <a href="#"><i class="mdi mdi-google-pages"></i>동영상</a>
                                <ul class="submenu megamenu">
                                    <li>
                                        <ul>
                                            <li><a href="page-starter.html">동영상등록</a></li>
                                            <li><a href="page-login.html">동영상조희</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                              <!-- 공지사항 -->
                              <li class="has-submenu">
                                <a href="#"><i class="mdi mdi-google-pages"></i>공지사항</a>
                                <ul class="submenu megamenu">
                                    <li>
                                        <ul>
                                            <li><a href="notice_modify.html">공지사항등록</a></li>
                                            <li><a href="notice_table.html">공지사항조희</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                            
        
                    </div>
                </div>
            </div>
        
        </header>

        <div class="wrapper">
            <div class="container">

                <!-- Page-Title -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="page-title-box">
                            <div class="btn-group pull-right">
                                <ol class="breadcrumb hide-phone p-0 m-0">
                                    <li>
                                        <a href="#">디지털조직도</a>
                                    </li>
                                    <li>
                                        <a href="#"></a>
                                    </li>
                                    <li class="active">
                                        동영상조회
                                    </li>
                                </ol>
                            </div>
                            <h4 class="page-title">동영상조회</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title end breadcrumb -->

       



                    <div class="col-md-4 col-sm-6">
                        <div class="property-card">
                            <div class="property-image" style="background: url('assets/images/properties/6.jpg') center center / cover no-repeat;">
                        </div>

                            <div class="property-content">
                                <div class="listingInfo">
                                    <p></p>
                                    <div class="">
                                        
                                        <h3 class="text-overflow"><a href="#" class="text-dark">4BHK Alexander Court,New York</a></h3>
                                        
                                        <div class="m-t-20" style="text-align: center">
                                            <button type="button" class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
                                            <button type="button" class="btn btn-danger btn-inline waves-effect waves-light"><i class="glyphicon  glyphicon-trash"></i>삭제</button>
                                        </div>

                                    </div>
                                </div>
                                <!-- end. Card actions -->
                            </div>
                            <!-- /inner row -->
                        </div>
                        <!-- End property item -->
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="property-card">
                            <div class="property-image" style="background: url('assets/images/properties/6.jpg') center center / cover no-repeat;">
                        </div>

                            <div class="property-content">
                                <div class="listingInfo">
                                    <p></p>
                                    <div class="">
                                        
                                        <h3 class="text-overflow"><a href="#" class="text-dark">4BHK Alexander Court,New York</a></h3>
                                        
                                        <div class="m-t-20" style="text-align: center">
                                            <button type="button" class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
                                            <button type="button" class="btn btn-danger btn-inline waves-effect waves-light"><i class="glyphicon  glyphicon-trash"></i>삭제</button>
                                        </div>

                                    </div>
                                </div>
                                <!-- end. Card actions -->
                            </div>
                            <!-- /inner row -->
                        </div>
                        <!-- End property item -->
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="property-card">
                            <div class="property-image" style="background: url('assets/images/properties/6.jpg') center center / cover no-repeat;">
                        </div>

                            <div class="property-content">
                                <div class="listingInfo">
                                    <p></p>
                                    <div class="">
                                        
                                        <h3 class="text-overflow"><a href="#" class="text-dark">4BHK Alexander Court,New York</a></h3>
                                        
                                        <div class="m-t-20" style="text-align: center">
                                            <button type="button" class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
                                            <button type="button" class="btn btn-danger btn-inline waves-effect waves-light"><i class="glyphicon  glyphicon-trash"></i>삭제</button>
                                        </div>

                                    </div>
                                </div>
                                <!-- end. Card actions -->
                            </div>
                            <!-- /inner row -->
                        </div>
                        <!-- End property item -->
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="property-card">
                            <div class="property-image" style="background: url('assets/images/properties/6.jpg') center center / cover no-repeat;">
                        </div>

                            <div class="property-content">
                                <div class="listingInfo">
                                    <p></p>
                                    <div class="">
                                        
                                        <h3 class="text-overflow"><a href="#" class="text-dark">4BHK Alexander Court,New York</a></h3>
                                        
                                        <div class="m-t-20" style="text-align: center">
                                            <button type="button" class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
                                            <button type="button" class="btn btn-danger btn-inline waves-effect waves-light"><i class="glyphicon  glyphicon-trash"></i>삭제</button>
                                        </div>

                                    </div>
                                </div>
                                <!-- end. Card actions -->
                            </div>
                            <!-- /inner row -->
                        </div>
                        <!-- End property item -->
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="property-card">
                            <div class="property-image" style="background: url('assets/images/properties/6.jpg') center center / cover no-repeat;">
                        </div>

                            <div class="property-content">
                                <div class="listingInfo">
                                    <p></p>
                                    <div class="">
                                        
                                        <h3 class="text-overflow"><a href="#" class="text-dark">4BHK Alexander Court,New York</a></h3>
                                        
                                        <div class="m-t-20" style="text-align: center">
                                            <button type="button" class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
                                            <button type="button" class="btn btn-danger btn-inline waves-effect waves-light"><i class="glyphicon  glyphicon-trash"></i>삭제</button>
                                        </div>

                                    </div>
                                </div>
                                <!-- end. Card actions -->
                            </div>
                            <!-- /inner row -->
                        </div>
                        <!-- End property item -->
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="property-card">
                            <div class="property-image" style="background: url('assets/images/properties/6.jpg') center center / cover no-repeat;">
                        </div>

                            <div class="property-content">
                                <div class="listingInfo">
                                    <p></p>
                                    <div class="">
                                        
                                        <h3 class="text-overflow"><a href="#" class="text-dark">4BHK Alexander Court,New York</a></h3>
                                        
                                        <div class="m-t-20" style="text-align: center">
                                            <button type="button" class="btn btn-custom btn-inline waves-effect waves-light">정보수정</button>
                                            <button type="button" class="btn btn-danger btn-inline waves-effect waves-light"><i class="glyphicon  glyphicon-trash"></i>삭제</button>
                                        </div>

                                    </div>
                                </div>
                                <!-- end. Card actions -->
                            </div>
                            <!-- /inner row -->
                        </div>
                        <!-- End property item -->
                    </div>
                    <!-- end col -->
                    <div class="text-right">
                        <ul class="pagination pagination-split m-t-0">
                            <li class="disabled">
                                <a href="#"><i class="fa fa-angle-left"></i></a>
                            </li>
                            <li>
                                <a href="#">1</a>
                            </li>
                            <li class="active">
                                <a href="#">2</a>
                            </li>
                            <li>
                                <a href="#">3</a>
                            </li>
                            <li>
                                <a href="#">4</a>
                            </li>
                            <li>
                                <a href="#">5</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-angle-right"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- end row -->



                <!-- Footer -->
                <footer class="footer text-right">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 text-center">
                                2016 - 2017 © Zircos.
                            </div>
                        </div>
                    </div>
                </footer>
                <!-- End Footer -->

            </div>
        </div>



        <!-- jQuery  -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/detect.js"></script>
        <script src="assets/js/fastclick.js"></script>
        <script src="assets/js/jquery.blockUI.js"></script>
        <script src="assets/js/waves.js"></script>
        <script src="assets/js/jquery.slimscroll.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
        <script src="../plugins/switchery/switchery.min.js"></script>

        <!-- Counter js  -->
        <script src="../plugins/waypoints/jquery.waypoints.min.js"></script>
        <script src="../plugins/counterup/jquery.counterup.min.js"></script>

        <!--Morris Chart-->
		<script src="../plugins/morris/morris.min.js"></script>
		<script src="../plugins/raphael/raphael-min.js"></script>

        <!-- Dashboard init -->
        <script src="assets/pages/jquery.dashboard.js"></script>

        <!-- App js -->
        <script src="assets/js/jquery.core.js"></script>
        <script src="assets/js/jquery.app.js"></script>

    </body>
</html>