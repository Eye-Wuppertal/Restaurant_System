<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html>

	<head>
		<title>我的订单</title>
		<%@ include file="include_import.jsp" %>

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>

			<!--
            	时间：2015-12-30
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="${pageContext.request.contextPath}/resources/img/logo2.png" />
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/resources/img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<%@ include file="include_login.jsp" %>
					</ol>
				</div>
			</div>
			<!--
            	时间：2015-12-30
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

		</nav>

		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong>我的订单</strong>
					<table class="table table-bordered">


						<%--一个tbody是一个订单，所以在此处遍历pageBean中的list属性 --%>
						<c:forEach var="o" items="${pageBean.list}">
						<tbody>
							<tr class="success">
								<th colspan="5">订单编号:${o.oid }  总计：${o.total } 下单时间：${o.ordertime }</th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							
							<%--遍历Order对象中的items属性，显示此订单下的所有订单项（含商品信息） --%>
							<c:forEach var="oi" items="${o.items}">
							<tr>
								<td width="60" width="40%">
									<img src="${pageContext.request.contextPath}/resources${oi.product.pimage}" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank">${oi.product.pname}</a>
								</td>
								<td width="20%">
									￥${oi.product.shopPrice}
								</td>
								<td width="10%">
									${oi.count}
								</td>
								<td width="15%">
									<span class="subtotal">￥${oi.subtotal}</span>
								</td>
							</tr>
							</c:forEach>
							
						</tbody>
						</c:forEach>



					</table>
				</div>
			</div>
			<div style="text-align: center;">
				<ul class="pagination">

					<li ${pageBean.pageNum==1?'class="disabled"':'' }>
						<a href="${pageContext.request.contextPath}/order/showMyOrdersByPage?pageNum=${pageBean.pageNum-1}&pageSize=5" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
					</li>

					<c:forEach var="i" begin="1" end="${pageBean.pageCount}">
					<li ${i==pageBean.pageNum?'class="active"':''}>
						<a href="${pageContext.request.contextPath}/order/showMyOrdersByPage?pageNum=${i}&pageSize=5">${i}</a>
					</li>
					</c:forEach>

					<li ${pageBean.pageNum==pageBean.pageCount?'class="disabled"':'' }>
						<a href="${pageContext.request.contextPath}/order/showMyOrdersByPage?pageNum=${pageBean.pageNum+1}&pageSize=5" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</ul>
			</div>
		</div>

		<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/resources/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2005-2016 明德商城 版权所有
		</div>
	</body>

</html>