<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
  <title>湖工小菜馆</title>
  <%@ include file="include_import.jsp" %>
  <script>
    $(function(){
    });

  </script>
</head>

<body>
<div class="container-fluid">

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

          <%--引用JSP，从ServletContext域中取得分类信息并显示到导航条上 --%>
          <%@ include file="include_nav.jsp" %>

        </div>
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
    </nav>
  </div>

  <!--
      描述：轮播条
  -->
  <div class="container-fluid">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      </ol>

      <!-- Wrapper for slides -->
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="${pageContext.request.contextPath}../resources/image/restaurant/food_flide01.png" alt="">
          <div class="carousel-caption">

          </div>
        </div>
        <div class="item">
          <img src="${pageContext.request.contextPath}../resources/image/restaurant/food_flide02.png" alt="">
          <div class="carousel-caption">

          </div>
        </div>
        <div class="item">
          <img src="${pageContext.request.contextPath}../resources/image/restaurant/food_flide03.png" alt="">
          <div class="carousel-caption">

          </div>
        </div>
      </div>

      <!-- Controls -->
      <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </div>
  <!--
      描述：商品显示
  -->
  <div class="container-fluid">
    <div class="col-md-12">
      <h2>热门菜品<img src="${pageContext.request.contextPath}../resources/img/title2.jpg" alt=""/></h2>
    </div>
    <div class="col-md-4" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
      <img src="${pageContext.request.contextPath}../resources/image/restaurant/food_haixian_xiaolongxia.png" width="400" height="400" alt=""/>
    </div>
    <div class="col-md-8">
      <div class="col-md-3" style="text-align:center;height:200px;padding:0;">
        <a href="product_info.jsp">
          <img src="${pageContext.request.contextPath}../resources/image/restaurant/food_haixian_niuwa.png" width="200px" height="200px" style="display: inline-block;" alt="">
        </a>
      </div>


      <c:forEach var="p" items="${hotProducts}">
        <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0;">
          <a href="${pageContext.request.contextPath}/showDetail?pid=${p.pid}">
            <img src="${pageContext.request.contextPath}../resources${p.pimage}" width="130" height="130" style="display: inline-block;" alt="">
          </a>
          <p><a href="${pageContext.request.contextPath}/showDetail?pid=${p.pid}" style='color:#666'>${p.pname }</a></p>
          <p><span style="font-size:16px; color: #E4393C; ">&yen;${p.pPrice }</span></p>
        </div>
      </c:forEach>

    </div>
  </div>
>

  <!--
      描述：商品显示
  -->
  <div class="container-fluid">
    <div class="col-md-12">
      <h2>最新菜品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}../resources/img/title2.jpg" alt=""/></h2>
    </div>
    <div class="col-md-3" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
      <img src="${pageContext.request.contextPath}../resources/image/restaurant/food_flide01.png" width="400" height="400" style="display: inline-block;" alt=""/>
    </div>
    <div class="col-md-9">
      <div class="col-md-6" style="text-align:center;height:200px;padding:0;">
        <a href="./product_info.jsp">
          <img src="${pageContext.request.contextPath}../resources/image/restaurant/food_flide02.png" width="516px" height="200px" style="display: inline-block;" alt="">
        </a>
      </div>

      <c:forEach var="p" items="${newProducts}">
        <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0;">
          <a href="${pageContext.request.contextPath}/showDetail?pid=${p.pid}">
            <img src="${pageContext.request.contextPath}../resources${p.pimage}" width="130" height="130" style="display: inline-block;" alt="">
          </a>
          <p><a href="${pageContext.request.contextPath}/showDetail?pid=${p.pid}" style='color:#666'>${p.pname }</a></p>
          <p><span style="font-size:16px; color: #E4393C; ">&yen;${p.pPrice }</span></p>
        </div>
      </c:forEach>

    </div>
  </div>

  <!--
      描述：页脚部分
  -->

    <div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
      Copyright &copy; 2021 HBUT 版权所有
    </div>
  </div>
</div>
</body>

</html>