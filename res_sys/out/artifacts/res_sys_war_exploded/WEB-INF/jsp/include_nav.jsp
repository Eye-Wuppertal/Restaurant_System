<%@ page contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>


	<ul class="nav navbar-nav">
		<%--遍历ServletContext域中的所有分类信息并显示 --%>
		<c:forEach var="i" items="${all_categorys}">    
			<li><a href="${pageContext.request.contextPath}/showByCidByKeywordByPage?cid=${i.cid}">${i.cname}</a></li>
	    </c:forEach>
	</ul>
	<form action="${pageContext.request.contextPath}/showByCidByKeywordByPage" method="POST" class="navbar-form navbar-right" role="search">
		<div class="form-group">
			<label>
				<input type="text" name="keyword" class="form-control" placeholder="请输入搜索关键字">
			</label>
		</div>
		<button type="submit" class="btn btn-default">搜索</button>
	</form>

