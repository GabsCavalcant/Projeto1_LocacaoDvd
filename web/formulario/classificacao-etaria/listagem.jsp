<%-- 
    Document   : listagem (Classificacao Etaria)
    Created on : 25 de set. de 2025
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%-- CORRIGIDO: O prefixo aponta para o servlet padronizado "processaClassificacoesEtarias" --%>
<c:set var="prefixo" value="processaClassificacoesEtarias?acao=preparar"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Classificações Etárias Cadastradas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${cp}/css/estilo.css"/>
    </head>
    <body>

        <h1>Classificações Etárias Cadastradas</h1>

        <p>
            <a href="${cp}/formulario/classificacao-etaria/novo.jsp">
                Nova Classificação Etária
            </a>
        </p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Descrição</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>
                
                <%-- CORRIGIDO: O nome da classe de serviço está padronizado --%>
                <jsp:useBean
                    id="servicos"
                    scope="page"
                    class="locacaodvds.servicos.Classificacao_etariaService"/>

                <c:forEach items="${servicos.todos}" var="classificacaoEtaria">
                    <tr>
                        <%-- CORRIGIDO: Usando a variável "classificacaoEtaria" (camelCase) --%>
                        <td>${classificacaoEtaria.id}</td>
                        <td>${classificacaoEtaria.descricao}</td>
                        <td>
                            <a href="${cp}/${prefixo}Alteracao&id=${classificacaoEtaria.id}">Alterar</a>
                        </td>
                        <td>
                            <a href="${cp}/${prefixo}Exclusao&id=${classificacaoEtaria.id}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

        <p><a href="${cp}/index.jsp">Tela Principal</a></p>

    </body>
</html>