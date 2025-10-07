<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Alterar Classificação Etária</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/index.css"/>
        <link rel="stylesheet" href="${cp}/css/geral.css"/>
    </head>
    <body>

        <h1>Alterar Classificação Etária</h1>
        
       
        <form method="post" action="${cp}/processaClassificacoesEtarias">
            
            <input type="hidden" name="acao" value="alterar"/>
            <input type="hidden" name="id" value="${requestScope.classificacaoEtaria.id}"/>
            
            <table class="tabelaFormulario">
                <tr>
                    <td class="alinharDireita">Descrição:</td>
                    <td>
                        <%-- CORRIGIDO: O caractere '<' extra foi removido daqui --%>
                        <input type="text" name="descricao" 
                               value="${requestScope.classificacaoEtaria.descricao}" 
                               required maxlength="100"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formulario/classificacao-etaria/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar Alterações"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>