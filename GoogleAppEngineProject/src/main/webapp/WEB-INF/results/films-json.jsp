<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="model.Film" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
List<Film> films = (List<Film>) request.getAttribute("films");
Gson gson = new Gson();
String jsonInString = gson.toJson(films); 
response.getWriter().println(jsonInString); 
%>