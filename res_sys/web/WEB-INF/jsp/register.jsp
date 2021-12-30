<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!doctype html>
<html>
	<head>
		<title>注册</title>
		<meta charset="utf-8" />
		<%--每个页面都要进行的资源引入，提取出去形成一个独立文件，然后被每个JSP页面包含 --%>
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
    color: #3164af;
    font-size: 18px;
    font-weight: normal;
    padding: 0 10px;
}
 </style>
 
<script>
	$(function(){
		//给表单添加onsubmit事件，回调函数返回false，则阻止提交
		$('#frm_register').submit(function(){
			//密码和重复密码是否一致
			var p1 = $('#ipt_password').val();//得到密码框中的内容
			var p2 = $('#ipt_confirmpwd').val();//得到重复密码框中的内容
			
			if( p1 != p2 ){
				return false;
			}
			
		});
		
	});
</script>
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





<div class="container" style="width:100%;background:url('../resources/image/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	


	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<span>会员注册</span>USER REGISTER
		
		<%--注册表单 --%>
		<form action="${pageContext.request.contextPath}/register" id="frm_register" class="form-horizontal" style="margin-top:5px;" method="POST">
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-6">
			      <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名">
			    </div>
			  </div>
			   <div class="form-group">
			    <label  class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
					<label for="ipt_password"></label><input type="password" name="password" class="form-control" id="ipt_password" placeholder="请输入密码">
			    </div>
			  </div>
			   <div class="form-group">
			    <label  class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
					<label for="ipt_confirmpwd"></label><input type="password" class="form-control" id="ipt_confirmpwd" placeholder="请输入确认密码">
			    </div>
			  </div>

			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" name="name" class="form-control" id="usercaption" placeholder="请输入姓名">
			    </div>
			  </div>

			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">电话</label>
			    <div class="col-sm-6">
					<label for="telephone"></label><input type="text" name="telephone" class="form-control" id="telephone" placeholder="请输入手机号">
			    </div>
			  </div>

			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio1" value="男" checked> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="sex" id="inlineRadio2" value="女"> 女
			</label>
			</div>
			  </div>		
			  <div class="form-group">
			    <label  class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-6">
					<label>
						<input type="date" name="birthday" class="form-control"  >
					</label>
				</div>
			  </div>

			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="注册" name="submit" border="0"
				    style="background: url('${pageContext.request.contextPath}/resources/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
			    </div>
			  </div>
			</form>
		<%--注册表单 结束--%>
			
		
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>

	<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2021 HBUT 版权所有
		</div>

</body></html>
