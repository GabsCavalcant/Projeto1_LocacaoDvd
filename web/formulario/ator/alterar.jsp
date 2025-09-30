<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Alterar Ator</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilo.css"/>
    </head>
    <body>
        <h1>Alterar Ator</h1>
        
        <form method="post" action="${cp}/processaAtores">
            
            <input type="hidden" name="acao" value="alterar"/>
            <input type="hidden" name="id" value="${requestScope.ator.id}"/>
            
            <table class="tabelaFormulario">
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        <input type="text" name="nome" 
                               value="${requestScope.ator.nome}" 
                               required maxlength="100"/>
                    </td>
                </tr>
                
                <tr>
                    <td class="alinharDireita">Sobrenome:</td>
                    <td>
                        <input type="text" name="sobrenome" 
                               value="${requestScope.ator.sobrenome}" 
                               required maxlength="100"/>
                    </td>
                </tr>
               
                <tr>
                    <td class="alinharDireita">Data de Estreia:</td>
                    <td>
                        <input type="date" name="dataEstreia"
                               value="<fmt:formatDate value='${requestScope.ator.data_Estreia}' pattern='yyyy-MM-dd'/>" 
                               required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formulario/ator/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar Alterações"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>