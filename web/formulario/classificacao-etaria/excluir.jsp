<%-- 
    Document   : excluir (Classificacao Etaria)
    Created on : 24 de set. de 2025
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Excluir Classificação Etária</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${cp}/css/estilo.css"/>
    </head>
    <body>
        <h1>Excluir Classificação Etária</h1>
        
        <p>Você tem certeza que deseja excluir a classificação etária abaixo?</p>
        
        <div class="dados-exclusao">
            <%-- CORRIGIDO: Variável "classificacaoEtaria" sem o _ --%>
            <p><strong>ID:</strong> ${requestScope.classificacaoEtaria.id}</p>
            <p><strong>Descrição:</strong> ${requestScope.classificacaoEtaria.descricao}</p>
        </div>
        
        <br>

        <%-- CORRIGIDO: O "action" aponta para "processaClassificacoesEtarias" --%>
        <form method="post" action="${cp}/processaClassificacoesEtarias" class="form-botoes">
            
            <input type="hidden" name="acao" value="excluir"/>
            <%-- CORRIGIDO: Variável "classificacaoEtaria" sem o _ --%>
            <input type="hidden" name="id" value="${requestScope.classificacaoEtaria.id}"/>
            
            <input type="submit" value="Confirmar Exclusão" class="botao-excluir"/>

        </form>

        <%-- CORRIGIDO: Link "Voltar" fora do form e com o caminho certo --%>
        <p>
            <a href="${cp}/formulario/classificacao-etaria/listagem.jsp" class="botao">Voltar</a>
        </p>

    </body>
</html>