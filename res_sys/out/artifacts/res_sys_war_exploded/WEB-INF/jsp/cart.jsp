<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html>

	<head>
		<title>购物车</title>
		<%@ include file="include_import.jsp" %>
		<script type="text/javascript">
			$(function(){
				//给“提交订单”按钮绑定单击事件，被单击时，提交表单
				$('#btn_submit').click(function(){
					$('#frm_order').submit();//提交表单
				});
			});
		
		</script>
		
		<style>
			body {
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
			
			.container .row div {
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

				<div style="margin: 10px auto 0;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">订单详情</strong>
					
					<form id="frm_order" action="${pageContext.request.contextPath}/order/generateOrder" method="post">
					
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>菜品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>

						<%--遍历Session域中的cart购物车对象的items属性（Map集合）
							使用JSTL中的forEach标签遍历Map集合时，遍历的是Map集合中的一个键值对
							也就是说ci中包含key和value   001 -> 小米6
						 --%>
						<c:forEach var="ci" items="${cart.items}">
							<tr>
								<td>
									<input type="hidden" name="pid" value="${ci.key}">
									<img src="${pageContext.request.contextPath}../resources${ci.value.product.pimage}" width="70" height="60" alt="">
								</td>
								<td>
									<a target="_blank">${ci.value.product.pname }</a>
								</td>
								<td>
									￥${ci.value.product.pPrice }
								</td>
								<td>
									<label>
										<input type="text" name="count" value="${ci.value.count}" maxlength="4" size="10">
									</label>
								</td>
								<td>
									<span class="subtotal">￥${ci.value.subTotal }</span>
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/removeCartItem?pid=${ci.key}" class="delete">删除</a>
								</td>
							</tr>
						</c:forEach>


						</tbody>
					</table>
					</form>
					
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					<em style="color:#ff6600;">

			</em> &nbsp; 共计: <strong style="color:#ff6600;">￥${cart.total }元</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="#" id="clear" class="clear">清空购物车</a>
					
					<input id="btn_submit" type="button" width="100" value="提交订单" border="0" style="background: url('${pageContext.request.contextPath}../resources/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
					
				</div>
			</div>

		</div>


		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2021 HBUT 版权所有
		</div>

	</body>

</html>