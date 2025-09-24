<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora de DVDs V1.0</title>
        
        <%-- Usando o Context Path para garantir que o link do CSS sempre funcione --%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        
        <h1>Locadora de DVDs V1.0</h1>
        
        <h2>Cadastros Disponíveis</h2>
        <ul>
            <li>
                <%-- Este é o único link funcional por enquanto --%>
                <a href="${pageContext.request.contextPath}/formulario/genero/listagem.jsp">
                    Cadastro de Gêneros
                </a>
            </li>
            <li>
                <%-- Este link será implementado nos próximos passos --%>
                <a href="#">Cadastro de Classificações Etárias</a>
            </li>
            <li>
                <%-- Este link será implementado nos próximos passos --%>
                <a href="#">Cadastro de Atores</a>
            </li>
            <li>
                <%-- Este link será implementado nos próximos passos --%>
                <a href="#">Cadastro de DVDs</a>
            </li>
        </ul>

    </body>
</html>