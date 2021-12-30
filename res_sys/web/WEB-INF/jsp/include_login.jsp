<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

				<%--Session域中不存在User对象，则认为是未登录状态 --%>
					<c:if test="${sessionScope.current_user == null }">
						<li><a href="${pageContext.request.contextPath}/goLogin"><font size="8">登录</font></a></li>
						<li><a href="${pageContext.request.contextPath}/goRegister"><font size="8">注册</font></a></li>
					</c:if>
				<%--Session中存在User对象，则认为是已登录状态 --%>
					<c:if test="${sessionScope.current_user != null }">
						<li><font size="6">${sessionScope.current_user.name}</font></li>
						<li><a href="${pageContext.request.contextPath}/order/showMyOrdersByPage"><font size="6">订单</font></a></li>
					</c:if>

<%--					<li><a href="${pageContext.request.contextPath}/showCart">购物车</a></li>--%>
					