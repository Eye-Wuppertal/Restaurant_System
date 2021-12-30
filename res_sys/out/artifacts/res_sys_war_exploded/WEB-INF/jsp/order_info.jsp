<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>

	<head>
		<title>确认订单</title>
		<%@ include file="include_import.jsp" %>
		<script>
			$(function(){
				$('#btn_submit').click(function(){
					//当点击下面的“确认订单”图片时，提交表单
					$('#frm_confirmOrder').submit();
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
					<strong>订单详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th colspan="5">订单编号:${order.oid }</th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							
						<%--遍历的是order对象的items集合，此List集合中是OrderItem对象 --%>
						<c:forEach var="oi" items="${order.items }">
							<tr>
								<td>
									<img src="${pageContext.request.contextPath}../resources${oi.product.pimage}" width="70" height="60" alt="">
								</td>
								<td>
									<a target="_blank">${oi.product.pname }</a>
								</td>
								<td>
									￥${oi.product.pPrice }
								</td>
								<td>
									${oi.count }
								</td>
								<td>
									<span class="subtotal">￥${oi.subtotal }</span>
								</td>
							</tr>
						</c:forEach>
						
							
						</tbody>
					</table>
				</div>

				<div style="text-align:right;margin-right:120px;">
					共计: <strong style="color:#ff6600;">￥${order.total }元</strong>
				</div>

			</div>

			<div>
				<hr/>
				<form id="frm_confirmOrder" action="${pageContext.request.contextPath}/order/confirmOrder" method="post" class="form-horizontal" style="margin-top:5px;margin-left:150px;">
				<%--需要提交当前订单的OID --%>
					<input type="hidden" name="oid" value="${order.oid }"/>

				</form>

				<hr/>

				<div style="margin-top:5px;margin-left:150px;">
<%--					<strong>选择支付方式：</strong>--%>
<%--					<p>--%>
<%--						<br/>--%>
<%--						<label>--%>
<%--							<input type="radio" name="pd_FrpId" value="wepay" checked="checked"/>--%>
<%--							微信支付--%>
<%--						</label>--%>
<%--						<img src="${pageContext.request.contextPath}../resources/image/restaurant/wepay.png" width="200" height="100" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--						<label>--%>
<%--							&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--							<input type="radio" name="pd_FrpId" value="alipay"/>--%>
<%--						</label>支付宝支付--%>
<%--						<img src="${pageContext.request.contextPath}../resources/image/restaurant/alipay.png" width="200" height="100" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--						<label>--%>
<%--							&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--							<input type="radio" name="pd_FrpId" value="meitpay"/>--%>
<%--						</label>美团支付--%>
<%--						<img src="${pageContext.request.contextPath}../resources/image/restaurant/meitpay.png" width="200" height="100" alt=""/>--%>
<%--						<br/>--%>
<%--						<br/>--%>


					</p>
					<hr/>
					<p style="text-align:right;margin-right:100px;">
						<img id="btn_submit" src="${pageContext.request.contextPath}../resources/images/finalbutton.gif" width="204" height="51"
							 style="cursor:pointer;" alt=""/>
					</p>
					<hr/>

				</div>
			</div>

		</div>


		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2021 HBUT 版权所有
		</div>

	</body>

</html>