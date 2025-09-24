<%-- 
    Document   : excluir
    Created on : 24 de set. de 2025, 19:52:14
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${cp}/css/estilo.css"/>
        <title>Exclusão</title>
    </head>
    <body>
        <h1>Exclua!!!</h1>
        
         <p>Você tem certeza que deseja excluir o gênero abaixo?</p>
         <div> 
         
             <p>ID: ${requestScope.genero.id}</p>   
             <p>Descricao ${requestScope.genero.descricao}</p>   
         </div>
        
        <form method="POST" action="${cp}/processaGeneros" >
            
           
        
            <input type="hidden" name="acao" value="excluir">
            <input type="hidden" name="id" value="${requestScope.genero.id}"/>
            <input type="submit" value="Confirmar Exclusao" class="botao-excluir">
            <a href="${cp}/formulario/genero/listagem.jsp" class="botao">Voltar</a>
 
        
        </form>
    </body>
</html>
