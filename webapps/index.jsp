<%@page contentType="text/html;charset=GBK"%>
<%@ page import="com.ding9.util.UrlRewriteManager" %>
<%@ page import="com.ding9.util.Environment" %>
<html>
<%
response.sendRedirect(UrlRewriteManager.dynamic2static("/index.do"));
%>
</html>