<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
<head>
		<title>登录</title>
		<%@ include file="include_import.jsp" %>
		

<style>
  body{
	  margin: 0 auto;
  }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #666;
    font-size: 22px;
    font-weight: normal;
    padding-right:17px;
}
 </style>
</head>
<body>
	
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

	
	
	
	
	
	
<div class="container"  style="width:100%;height:460px;background:#2cc3ff url('${pageContext.request.contextPath}/resources/image/restaurant/login_bg.jpg') no-repeat;">
<div class="row"> 
	<div class="col-md-7">
	</div>
	
	<div class="col-md-5">
				<div style="width:440px;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:60px;background:#fff;">
				<span>登录</span>USER LOGIN

				<div>&nbsp;</div>
				
				<%--此表单提交到/login --%>
<form action="${pageContext.request.contextPath}/login" method="post" class="form-horizontal">
  
 <div class="form-group">
    <label for="username" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-6">
      <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名">
    </div>
  </div>
   <div class="form-group">
    <label class="col-sm-2 control-label">密码</label>
    <div class="col-sm-6">
		<label for="inputPassword2"></label><input type="password" name="password" class="form-control" id="inputPassword2" placeholder="请输入密码">
    </div>
  </div>
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> 自动登录
        </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label>
          <input type="checkbox"> 记住用户名
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
	    <input type="submit"  width="100" value="登录" border="0" style="background: url('${pageContext.request.contextPath}/resources/images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
	    height:35px;width:100px;color:white;">
    </div>
  </div>
</form>
</div>			
	</div>
</div>
</div>	

		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2021 HBUT 版权所有
		</div>
</body></html>