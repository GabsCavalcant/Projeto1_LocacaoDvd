<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Gênero</title>
        <link rel="stylesheet" href="${cp}/css/index.css"/>
        
        <link rel="stylesheet" href="${cp}/css/geral.css"/>
    </head>
    <body class="pagina pagina-dvd">
        <h1>Novo Gênero</h1>
        
        <form action="${cp}/processaGeneros" method="post">
            <input type="hidden" name="acao" value="inserir">
            
            <table class="tabelaFormulario">
                <tr>
                    <td class="alinharDireita">Descrição:</td>
                    <td><input type="text" name="descricao" required maxlength="100"></td>
                </tr>
                
               
                <tr>
                    <td>
                      
                        <a href="${cp}/formulario/genero/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"> 
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>