<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Ator</title>
        <link rel="stylesheet" href="${cp}/css/index.css"/>
        <link rel="stylesheet" href="${cp}/css/ator.css"/>
    </head>
    <body>
        <h1>Novo Ator</h1>
        
        <form action="${cp}/processaAtores" method="POST">
            <input type="hidden" name="acao" value="inserir">
            
            <table class="tabelaFormulario">
                <tr>
                    <td class="alinharDireita">Nome</td>
                    <td><input type="text" name="nome" required maxlength="100"></td>
                </tr>
                 <tr>
                    <td class="alinharDireita">Sobrenome</td>
                    <td><input type="text" name="sobrenome" required maxlength="100"></td>
                </tr>
                
                 <tr>
                    <td class="alinharDireita">Data Estreia</td>
                    <td><input type="date" name="dataEstreia" required maxlength="100"></td>
                </tr>
                
               
                <tr>
                    <td>
                      
                        <a href="${cp}/formulario/ator/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"> 
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>