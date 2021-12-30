<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

	<head>
		<title>信息提示</title>
		<%@ include file="include_import.jsp" %>
</head>

<body>
	<div class="container-fluid">

		<!--
			描述：菜单栏
		-->
		<div class="container-fluid">
			<div class="col-md-3">
			</div>
			<div class="col-md-4">
				<img src="${pageContext.request.contextPath}../resources/image/restaurant/res_logo01.png"  alt="图片无法显示"/>
			</div>
			<div class="text-center" style="padding-top:60px" >
				<ol class="list-inline">
					<%@ include file="include_login.jsp"%>
				</ol>
			</div>
		</div>
		<!--
			描述：导航条
		-->
		<div class="container-fluid">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">首页</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<%@ include file="include_nav.jsp" %>

					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>

		<div class="container-fluid">
			<div class="main_con" style="height:300px;">

				<h3>${msg}</h3>


			</div>
		</div>

	</div>
	<div class="container-fluid">

		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2021 HBUT 版权所有
		</div>
	</div>

</body>

</html>