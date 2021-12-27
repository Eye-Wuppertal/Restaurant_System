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
            	时间：2015-12-30
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="${pageContext.request.contextPath}../resources/img/logo2.png"  alt=""/>
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}../resources/img/header.png"  alt=""/>
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
									￥${oi.product.shopPrice }
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
					商品金额: <strong style="color:#ff6600;">￥${order.total }元</strong>
				</div>

			</div>

			<div>
				<hr/>
				<form id="frm_confirmOrder" action="${pageContext.request.contextPath}/order/confirmOrder" method="post" class="form-horizontal" style="margin-top:5px;margin-left:150px;">
				<%--需要提交当前订单的OID --%>
					<input type="hidden" name="oid" value="${order.oid }"/>
					<div class="form-group">
						<label for="ipt_name" class="col-sm-1 control-label">收货人</label>
						<div class="col-sm-5">
							<input name="name" type="text" class="form-control" id="ipt_name" placeholder="请输收货人">
						</div>
					</div>
					<div class="form-group">
						<label for="ipt_address" class="col-sm-1 control-label">地址</label>
						<div class="col-sm-5">
							<input name="address" type="text" class="form-control" id="ipt_address" placeholder="请输入收货地址">
						</div>
					</div>
					<div class="form-group">
						<label for="ipt_telephone" class="col-sm-1 control-label">电话</label>
						<div class="col-sm-5">
							<input name="telephone" type="text" class="form-control" id="ipt_telephone" placeholder="请输入联系方式">
						</div>
					</div>
				</form>

				<hr/>

				<div style="margin-top:5px;margin-left:150px;">
					<strong>选择银行：</strong>
					<p>
						<br/>
						<label>
							<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>
							工商银行
						</label>
						<img src="${pageContext.request.contextPath}../resources/bank_img/icbc.bmp" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>
						</label>中国银行
						<img src="${pageContext.request.contextPath}../resources/bank_img/bc.bmp" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>
						</label>农业银行
						<img src="${pageContext.request.contextPath}../resources/bank_img/abc.bmp" alt=""/>
						<br/>
						<br/>
						<label>
							<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>
							交通银行
						</label>
						<img src="${pageContext.request.contextPath}../resources/bank_img/bcc.bmp" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>
						</label>平安银行
						<img src="${pageContext.request.contextPath}../resources/bank_img/pingan.bmp" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>
						</label>建设银行
						<img src="${pageContext.request.contextPath}../resources/bank_img/ccb.bmp" alt=""/>
						<br/>
						<br/>
						<label>
							<input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>
							光大银行
						</label>
						<img src="${pageContext.request.contextPath}../resources/bank_img/guangda.bmp" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>
						</label>招商银行
						<img src="${pageContext.request.contextPath}../resources/bank_img/cmb.bmp" alt=""/>

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

		<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}../resources/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
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