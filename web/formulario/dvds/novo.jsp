<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Novo DVD</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${cp}/css/estilo.css"/>
    </head>
    <body>

        <h1>Novo DVD</h1>

        <form method="post" action="${cp}/processaDvds">

            <input type="hidden" name="acao" value="inserir"/>

            <table class="tabelaFormulario">
                <tr>
                    <td class="alinharDireita">Título:</td>
                    <td><input type="text" name="titulo" required/></td>
                </tr>
                <tr>
                    <td class="alinharDireita">Ano de Lançamento:</td>
                    <td><input type="number" name="anoLancamento" required/></td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data de Lançamento:</td>
                    <td><input type="date" name="dataLancamento" required/></td>
                </tr>
                <tr>
                    <td class="alinharDireita">Duração (em minutos):</td>
                    <td><input type="number" name="duracaoEmMinutos" required/></td>
                </tr>
                <tr>
                    <td class="alinharDireita">Gênero:</td>
                    <td>
                        <jsp:useBean id="generoServices" class="locacaodvds.servicos.GeneroService"/>
                        <select name="genero_id" required>
                            <option value="">-- Selecione --</option>
                            <c:forEach items="${generoServices.todos}" var="item">
                                <option value="${item.id}">${item.descricao}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Classificação Etária:</td>
                    <td>
                        <jsp:useBean id="classificacaoServices" class="locacaodvds.servicos.Classificacao_etariaService"/>
                        <select name="classificacaoEtaria_id" required>
                            <option value="">-- Selecione --</option>
                            <c:forEach items="${classificacaoServices.todos}" var="item">
                                <option value="${item.id}">${item.descricao}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Ator Principal:</td>
                    <td>
                        <jsp:useBean id="atorServices" class="locacaodvds.servicos.AtorService"/>
                        <select name="atorPrincipal_id" required>
                            <option value="">-- Selecione --</option>
                            <c:forEach items="${atorServices.todos}" var="item">
                                <option value="${item.id}">${item.nome} ${item.sobrenome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Ator Coadjuvante:</td>
                    <td>
                        <select name="atorCoadjuvante_id" required>
                            <option value="">-- Selecione --</option>
                            <c:forEach items="${atorServices.todos}" var="item">
                                <option value="${item.id}">${item.nome} ${item.sobrenome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${cp}/formulario/dvds/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>