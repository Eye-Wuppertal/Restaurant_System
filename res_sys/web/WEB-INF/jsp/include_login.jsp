<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

				<%--Session域中不存在User对象，则认为是未登录状态 --%>
					<c:if test="${sessionScope.current_user == null }">
						<li><a href="${pageContext.request.contextPath}/goLogin">登录</a></li>
						<li><a href="${pageContext.request.contextPath}/goRegister">注册</a></li>
					</c:if>
				<%--Session中存在User对象，则认为是已登录状态 --%>
					<c:if test="${sessionScope.current_user != null }">
						<li>${sessionScope.current_user.name}</li>
						<li><a href="${pageContext.request.contextPath}/order/showMyOrdersByPage">我的订单</a></li>
					</c:if>

					<li><a href="${pageContext.request.contextPath}/showCart">购物车</a></li>
					