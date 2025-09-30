<%-- 
    Document   : excluir (Classificacao Etaria)
    Created on : 24 de set. de 2025
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Excluir Ator</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${cp}/css/estilo.css"/>
    </head>
    <body>
        <h1>Excluir Ator</h1>
        
        <p>Você tem certeza que deseja excluir o Ator abaixo?</p>
        
        <div class="dados-exclusao">
           
            <p><strong>ID:</strong> ${requestScope.ator.id}</p>
            <p><strong>ID:</strong> ${requestScope.ator.nome}</p>
            <p><strong>Nome : </strong> ${requestScope.ator.nome} ${requestScope.ator.sobrenome} </p>
            <p><strong>Data Estreia</strong> <fmt:formatDate value="${ator.data_Estreia}" pattern="dd/MM/yyyy"/></p>
            
        </div>
        
        <br>

        
        <form method="post" action="${cp}/processaAtores" class="form-botoes">
            
            <input type="hidden" name="acao" value="excluir"/>
           
            <input type="hidden" name="id" value="${requestScope.ator.id}"/>
            
            <input type="submit" value="Confirmar Exclusão" class="botao-excluir"/>

        </form>

        
        <p>
            <a href="${cp}/formulario/ator/listagem.jsp" class="botao">Voltar</a>
        </p>

    </body>
</html>