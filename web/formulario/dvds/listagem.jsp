<%-- 
    Document   : listagem (DVDs)
    Created on : 04 de out. de 2025
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaDvds?acao=preparar"/>

<!DOCTYPE html>
<html>
    <head>
        <title>DVDs Cadastrados</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilo.css"/>
    </head>
    <body>

        <h1>DVDs Cadastrados</h1>

        <p>
            <a href="${cp}/formulario/dvds/novo.jsp">Novo DVD</a>
        </p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Ano</th>
                    <th>Data Lanç.</th>
                    <th>Duração (min)</th>
                    <th>Gênero</th>
                    <th>Classificação</th>
                    <th>Ator Principal</th>
                    <th>Ator Coadjuvante</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>
                
                <jsp:useBean
                    id="servicos"
                    scope="page"
                    class="locacaodvds.servicos.DvdServices"/>

                <c:forEach items="${servicos.todos}" var="dvd">
                    <tr>
                        
                        <td>${dvd.titulo}</td>
                        <td>${dvd.anoLancamento}</td>
                        <td>
                            <fmt:formatDate value="${dvd.dataLancamento}" pattern="dd/MM/yyyy"/>
                        </td>
                        <td>${dvd.duracaoEmMinutos}</td>
                        
                        
                        <td>${dvd.genero.descricao}</td>
                        <td>${dvd.classificacaoEtaria.descricao}</td>
                        <td>${dvd.atorPrincipal.nome} ${dvd.atorPrincipal.sobrenome}</td>
                        <td>${dvd.atorCoadjuvante.nome} ${dvd.atorCoadjuvante.sobrenome}</td>
                        
                        <td>
                            <a href="${cp}/${prefixo}Alteracao&id=${dvd.id}">Alterar</a>
                        </td>
                        <td>
                             <a href="${cp}/${prefixo}Exclusao&id=${dvd.id}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

        <p><a href="${cp}/index.jsp">Tela Principal</a></p>

    </body>
</html>