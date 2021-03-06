<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des produits</title>
</head>
<body>
   <h1> Recherche</h1>
  <form action="search.aspx" method="post">
      ID : <input type ="text" name="id" value="${researched }">
      <input type="submit" value="Rechercher">
  </form>
  <hr />
   <h1> Ajouter : </h1>
    <form action="add.aspx" method="post">
      <table border="1" width="30%">
        <tr>
          <td>NOM</td>
          <td><input type ="text" name="nom"></td>        
        </tr>
        <tr>
          <td>DESCRIPTION</td>
          <td><input type ="text" name="description"></td>        
        </tr>
        <tr>
          <td>PRIX</td>
          <td><input type ="text" name="price"></td>        
        </tr>
        <tr>
          <td colspan = "2"><input type="submit" value="Ajouter"></td>
        </tr>
      </table>       
             
  </form>
  <hr /> <br />
  <h1> Liste de produits</h1>
  <table border="1" width="50%">   
   <tr>
    <th>ID</th>
    <th>Nom</th>
    <th>Description</th>
    <th>Prix</th>
    <th>Option</th>
   </tr>
  <!-- // Liste produits --> 
  <c:forEach items= "${listeproduit}" var="o">
   <tr>
    <td>${o.idP }</td>
    <td>${o.nom }</td>
    <td>${o.description }</td>
    <td>${o.price }</td>
    <td><a href = "delete.aspx?id=${o.idP }">Supprimer</a></td>
   </tr>
  
  </c:forEach>
      
  </table>
</body>
</html>