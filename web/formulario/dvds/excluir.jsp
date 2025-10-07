<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Excluir DVD</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${cp}/css/estilo.css"/>
    </head>
    <body>

        <h1>Excluir DVD</h1>

        <p>Você tem certeza que deseja excluir o DVD abaixo permanentemente?</p>
        
        <div class="dados-exclusao">
            <p><strong>Título:</strong> ${requestScope.dvd.titulo}</p>
            <p><strong>Ano de Lançamento:</strong> ${requestScope.dvd.anoLancamento}</p>
            <p><strong>Gênero:</strong> ${requestScope.dvd.genero.descricao}</p>
            <p><strong>Ator Principal:</strong> ${requestScope.dvd.atorPrincipal.nome} ${requestScope.dvd.atorPrincipal.sobrenome}</p>
        </div>
        
        <br>

        <form method="post" action="${cp}/processaDvds" class="form-botoes">
            
            <input type="hidden" name="acao" value="excluir"/>
            <input type="hidden" name="id" value="${requestScope.dvd.id}"/>
            
            <input type="submit" value="Confirmar Exclusão" class="botao-excluir"/>
            <a href="${cp}/formulario/dvds/listagem.jsp" class="botao">Voltar</a>

        </form>

    </body>
</html>