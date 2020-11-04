<%@ page import="com.google.gson.Gson" %>
<%@ page import="model.Film" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.List" %>
<%
List<Film> films = (List<Film>) request.getAttribute("films");
out.println(films); 
%>