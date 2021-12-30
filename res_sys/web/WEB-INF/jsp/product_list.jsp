<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>

	<head>
		<title>商品列表</title>
		<%@ include file="include_import.jsp" %>

		<style>
			body {
				margin: 0 auto;
				width: 100%;
			}
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
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
							<a class="navbar-brand" href="${pageContext.request.contextPath}/index">首页</a>
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


		<div class="row" style="width:1210px;margin:0 auto;">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/index">首页</a></li>
				</ol>
			</div>

		<%--遍历保存在Model中的名为pageBean的对象的list属性，此属性才是集合，才能被遍历，pageBean对象是不能被遍历的 --%>
		<c:forEach var="p" items="${pageBean.list}">
			<div class="col-md-2" style="height:260px;">
				<a href="${pageContext.request.contextPath}/showDetail?pid=${p.pid}">
					<img src="${pageContext.request.contextPath}../resources${p.pimage}" width="170" height="170" style="display: inline-block;" alt="">
				</a>
				<p><a href="${pageContext.request.contextPath}/showDetail?pid=${p.pid}" style='color:green'>${p.pname }</a></p>
				<p><span style="color: #FF0000; ">价格：&yen;${p.pPrice }</span></p>
			</div>
		</c:forEach>


		</div>

		<!--分页 -->
		<div style="width:380px;margin: 50px auto 0;">
			<ul class="pagination" style="text-align:center; margin-top:10px;">
				<%--上一页 --%>
				<li ${pageBean.pageNum==1?' class="disabled"':'' }>
					<a href="${pageContext.request.contextPath}/showByCidByKeywordByPage?cid=${param.cid}&pageNum=${pageBean.pageNum-1}&pageSize=12" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
				</li>
				
				<%--循环次数为总页数 --%>
				<c:forEach var="i" begin="1" end="${pageBean.pageCount}">
					<%--判断本次循环生成的页号是否是当前页，是，则添加样式“class=active”，此页号，高亮显示 --%>
					<li ${pageBean.pageNum==i?'class="active"':'' }>
						<%--使用EL表达式中的内置对象param得到请求中的参数的值 --%>
						<a href="${pageContext.request.contextPath}/showByCidByKeywordByPage?cid=${param.cid}&pageNum=${i}&pageSize=12">${i}</a>
					</li>
				</c:forEach>

				<%--下一页 --%>
				<li ${pageBean.pageNum==pageBean.pageCount?' class="disabled"':'' }>
					<a href="${pageContext.request.contextPath}/showByCidByKeywordByPage?cid=${param.cid}&pageNum=${pageBean.pageNum+1}&pageSize=12" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
				</li>
			</ul>
		</div>
		<!-- 分页结束=======================        -->

		<!--
       		商品浏览记录:
        -->
		<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

			<h4 style="width: 50%;float: left;font: 14px/30px 微软雅黑;"> 浏览记录 </h4>
			<div style="width: 50%;float: right;text-align: right;"><a href="">more</a></div>
			<div style="clear: both;"></div>

			<div style="overflow: hidden;">

				<ul style="list-style: none;">
					<li style="width: 150px;height: 216px;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;"><img src="${pageContext.request.contextPath}" width="130px" height="130px"  alt="无法加载该图片"/></li>
				</ul>

			</div>
		</div>


		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2021 HBUT 版权所有
		</div>

	</body>

</html>