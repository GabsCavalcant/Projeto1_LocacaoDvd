<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Alterar DVD</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${cp}/css/estilo.css"/>
    </head>
    <body>

        <h1>Alterar DVD</h1>
        
        <form method="POST" action="${cp}/processaDvds">
            
            <input type="hidden" name="acao" value="alterar"/>
            <input type="hidden" name="id" value="${requestScope.dvd.id}"/>
            
            <table class="tabelaFormulario">
                <tr>
                    <td class="alinharDireita">Título:</td>
                    <td><input type="text" name="titulo" value="${requestScope.dvd.titulo}" required/></td>
                </tr>
                <tr>
                    <td class="alinharDireita">Ano de Lançamento:</td>
                    <td><input type="number" name="anoLancamento" value="${requestScope.dvd.anoLancamento}" required/></td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data de Lançamento:</td>
                    <td>
                        <input type="date" name="dataLancamento" 
                               value="<fmt:formatDate value='${requestScope.dvd.dataLancamento}' pattern='yyyy-MM-dd'/>" required/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Duração (em minutos):</td>
                    <td><input type="number" name="duracaoEmMinutos" value="${requestScope.dvd.duracaoEmMinutos}" required/></td>
                </tr>
                
                <tr>
                    <td class="alinharDireita">Gênero:</td>
                    <td>
                        <select name="genero_id" required>
                            <c:forEach items="${requestScope.generos}" var="item">
                                <option value="${item.id}" ${item.id == requestScope.dvd.genero.id ? 'selected' : ''}>
                                    ${item.descricao}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td class="alinharDireita">Classificação Etária:</td>
                    <td>
                        <select name="classificacaoEtaria_id" required>
                            <c:forEach items="${requestScope.classificacoes}" var="item">
                                <option value="${item.id}" ${item.id == requestScope.dvd.classificacaoEtaria.id ? 'selected' : ''}>
                                    ${item.descricao}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td class="alinharDireita">Ator Principal:</td>
                    <td>
                        <select name="atorPrincipal_id" required>
                            <c:forEach items="${requestScope.atores}" var="item">
                                <option value="${item.id}" ${item.id == requestScope.dvd.atorPrincipal.id ? 'selected' : ''}>
                                    ${item.nome} ${item.sobrenome}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td class="alinharDireita">Ator Coadjuvante:</td>
                    <td>
                        <select name="atorCoadjuvante_id" required>
                            <c:forEach items="${requestScope.atores}" var="item">
                                <option value="${item.id}" ${item.id == requestScope.dvd.atorCoadjuvante.id ? 'selected' : ''}>
                                    ${item.nome} ${item.sobrenome}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <a href="${cp}/formulario/dvds/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar Alterações"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>