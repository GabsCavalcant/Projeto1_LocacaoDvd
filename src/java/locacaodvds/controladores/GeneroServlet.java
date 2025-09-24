package locacaodvds.controladores;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Genero;

// Nome da classe e do servlet no plural para seguir a convenção
@WebServlet(name = "GenerosServlet", urlPatterns = {"/processaGeneros"})
public class GeneroServlet extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("--- DEBUG SERVLET --- Ação recebida: [" + request.getParameter("acao") + "]");

        String acao = request.getParameter("acao");
        RequestDispatcher disp = null;

        // O try-catch para SQLException agora está aqui dentro
        try (GeneroDAO dao = new GeneroDAO()) {

            if (acao.equals("prepararAlteracao")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                Genero g = dao.obterPorId(id);
                request.setAttribute("genero", g);
                
                disp = request.getRequestDispatcher("/formularios/genero/alterar.jsp");

            } else if (acao.equals("prepararExclusao")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                Genero g = dao.obterPorId(id);
                request.setAttribute("genero", g);
                
                disp = request.getRequestDispatcher("/formularios/genero/excluir.jsp");
            
            }

        } catch (SQLException e) {
            // Imprime o erro no console do servidor
            e.printStackTrace();
        }

        if (disp != null) {
            disp.forward(request, response);
        }
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // Agora o doGet e doPost ficam mais simples
        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // E o doPost também
        processRequest(request, response);
    }
}