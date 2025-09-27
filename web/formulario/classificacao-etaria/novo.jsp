<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Classificação Etária</title>
        <link rel="stylesheet" href="${cp}/css/estilo.css"/>
    </head>
    <body>
        <h1>Novo Classificação Etária</h1>
        
        <form action="${cp}/processaClassificacoesEtarias" method="POST">
            <input type="hidden" name="acao" value="inserir">
            
            <table class="tabelaFormulario">
                <tr>
                    <td class="alinharDireita">Descrição:</td>
                    <td><input type="text" name="descricao" required maxlength="100"></td>
                </tr>
                
               
                <tr>
                    <td>
                      
                        <a href="${cp}/formulario/classificacao-etaria/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"> 
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>