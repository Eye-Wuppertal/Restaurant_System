<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>

	<head>
		<title>商品详情</title>
		<%@ include file="include_import.jsp" %>

		<style>
			body {
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


		<div class="container">
			<div class="row">
				<div style="border: 1px solid #e4e4e4;width:930px;margin-bottom:10px;padding:10px;">
				${product.pname }
				</div>

				<div style="margin:0 auto;width:950px;height:350px;">
					<div class="col-md-6">
						<img src="${pageContext.request.contextPath}/resources${product.pimage}" style="opacity: 1;width:400px;height:350px;" title="" class="medium" alt="">
					</div>

					<div class="col-md-6">
						<div><strong>${product.pname }</strong></div>
						<div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
							<div>编号：${product.pid }</div>
						</div>

						<div style="margin:10px 0 10px 0;">售价: <strong style="color:#ef0101;">￥：${product.pPrice }</strong></del>
						</div>

						<div style="margin:10px 0 10px 0;">促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)" style="background-color: #f07373;">限时抢购</a> </div>

						<div style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">
							<div style="margin:5px 0 10px 0;">白色</div>

							<form action="${pageContext.request.contextPath}/addCartItem" method="POST">
							<div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">购买数量:
								<label for="quantity">购买数量:</label><input id="quantity" name="count" value="1" maxlength="4" size="10" type="text">
								<input type="hidden" name="pid" value="${product.pid }" />
							</div>

							<div style="margin:20px 0 10px 0;;text-align: center;">
							
							<input style="background: url('${pageContext.request.contextPath}/resources/images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;" value="加入购物车" type="submit">
							&nbsp;</div>
							</form>
						</div>
					</div>
				</div>
				
				<div class="clear"></div>

				<div style="width:950px;margin:0 auto;">
					<div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
						<strong>商品介绍</strong>
					</div>

					<div>
						<img src="${pageContext.request.contextPath}../resources${product.pimage}" alt="">
					</div>

					<div style="background-color:#d3d3d3;width:900px;">
						<table class="table table-bordered">
							<tbody>
								<tr class="active">
									<th><strong>商品评论</strong></th>
								</tr>
								<tr class="warning">
									<th>暂无商品评论信息 <a>[发表商品评论]</a></th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>


		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2021 HBUT 版权所有
		</div>
	</body>

</html>