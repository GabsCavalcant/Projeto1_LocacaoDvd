<%-- 
    Document   : listagem
    Created on : 23 de set. de 2025, 21:26:59
    Author     : gabri
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaGeneros?acao=preparar"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href= "${cp}/css/estilo.css"/>

    </head>
    <body>

    
        <h1>Titulo Cadastrados!</h1>
        <p>
            <a href="${cp}/formulario/genero/novo.jsp">
            Novo Genero.
            </a>
        </p>
        
    <table class="tabelaListagem">
    <thead>
        <tr>
            <th>Id</th>
            <th>Descricao</th>
            <th>Alterar</th>
            <th>Excluir</th>
        </tr>
    </thead>
        
   
     <tbody>
         <%-- BLOCO DE DADOS TEMPORARIAMENTE DESATIVADO PARA TESTE 
    <jsp:useBean
                    id="servicos"
                    scope="page"
                    class="locacaodvds.servicos.GeneroService"/>
    
   
    <c:forEach items="${servicos.todos}" var="genero">
        
        <tr>
            
            <td>${genero.id}</td>
            <td>${genero.descricao}</td>
            
            <td>
                <a href="${cp}/${prefixo}Alteracao&id=${genero.id}"> 
                    Alterar
                </a>
            </td>
            <td>
                <a href="${cp}/${prefixo}Exclusao&id=${genero.id}"> 
                    Excluir
                </a>
            </td>
        </tr>
    </c:forEach>
         --%>
      </tbody>
    </table>
    
    
        
        <p>
            <a href="${cp}/formularios/genero/novo.jsp">
                Novo Gênero
            </a>
        </p>

        <%-- Um link para voltar à página principal do sistema. --%>
        <p><a href="${cp}/index.jsp">Tela Principal</a></p>
        
</body>
</html>
