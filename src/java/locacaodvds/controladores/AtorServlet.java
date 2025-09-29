package locacaodvds.controladores;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import locacaodvds.dao.AtorDAO;
import locacaodvds.entidades.Ator;

@WebServlet(name = "AtorServlet", urlPatterns = {"/processaAtores"})
public class AtorServlet extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        RequestDispatcher disp = null;

        try (AtorDAO dao = new AtorDAO()) {

            if (acao.equals("prepararAlteracao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Ator g = dao.obterPorId(id);
                request.setAttribute("ator", g);

                disp = request.getRequestDispatcher("/formulario/ator/alterar.jsp");

            } else if (acao.equals("prepararExclusao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Ator g = dao.obterPorId(id);
                request.setAttribute("ator", g);

                disp = request.getRequestDispatcher("/formulario/ator/excluir.jsp");

            } else if (acao.equals("inserir")) {
                String sobrenome = request.getParameter("sobrenome");
                Ator g = new Ator();
                g.setSobrenome(sobrenome);
                dao.salvar(g);

                response.sendRedirect(request.getContextPath() + "/formulario/ator/listagem.jsp");
                return;

            } else if (acao.equals("alterar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String sobrenome = request.getParameter("sobrenome");
                Ator g = new Ator();
                g.setId(id);
                g.setSobrenome(sobrenome);
                
               

                dao.atualizar(g);

                response.sendRedirect(request.getContextPath() + "/formulario/ator/listagem.jsp");
                return;
            } else if ((acao.equals("excluir"))) {
                int id = Integer.parseInt(request.getParameter("id"));
                Ator g = new Ator();
                g.setId(id);

                dao.excluir(g);
                response.sendRedirect(request.getContextPath() + "/formulario/ator/listagem.jsp");
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (disp != null) {
            disp.forward(request, response);
        }
    }

    // Os métodos doGet e doPost não precisam de alteração
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
