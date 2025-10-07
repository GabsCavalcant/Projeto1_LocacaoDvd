<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locação Gabs</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>
    </head>
    <body>
        
       
        <h1 class="titulo-principal">Locação Gabs</h1>
        
        <div class="menu-principal">
            <h2>Cadastros Disponíveis</h2>
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/formulario/dvds/listagem.jsp">Cadastro de DVDs</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/formulario/ator/listagem.jsp">Cadastro de Atores</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/formulario/genero/listagem.jsp">Cadastro de Gêneros</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/formulario/classificacao-etaria/listagem.jsp">Cadastro de Classificações Etárias</a>
                </li>
            </ul>
        </div>

    </body>
</html>