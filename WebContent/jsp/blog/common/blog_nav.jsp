<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!-- DC iMenu Start -->
    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item" href="${pageContext.request.contextPath}/">Home</a>
          <c:forEach items="${ navItems }" var="nav" varStatus="itemStatus">
          	 <a class="blog-nav-item" href="${pageContext.request.contextPath}/jsp/blog/blog_contact?id=${ nav.id }">${ nav.title }</a>
          </c:forEach>
<%--           <a class="blog-nav-item" href="${pageContext.request.contextPath}/jsp/blog/blog_contact">Contact</a> --%>
<%--           <a class="blog-nav-item" href="${pageContext.request.contextPath}/jsp/blog/blog_contact">About</a> --%>
        </nav>
      </div>
    </div>
<!-- DC iMenu End -->