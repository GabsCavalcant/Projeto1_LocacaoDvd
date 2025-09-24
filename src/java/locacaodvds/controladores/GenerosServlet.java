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

@WebServlet(name = "GenerosServlet", urlPatterns = {"/processaGeneros"})
public class GenerosServlet extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        RequestDispatcher disp = null;

        try (GeneroDAO dao = new GeneroDAO()) {

            if (acao.equals("prepararAlteracao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Genero g = dao.obterPorId(id);
                request.setAttribute("genero", g);

                disp = request.getRequestDispatcher("/formulario/genero/alterar.jsp");

            } else if (acao.equals("prepararExclusao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Genero g = dao.obterPorId(id);
                request.setAttribute("genero", g);

                disp = request.getRequestDispatcher("/formulario/genero/excluir.jsp");

            } else if (acao.equals("inserir")) {
                String descricao = request.getParameter("descricao");
                Genero g = new Genero();
                g.setDescricao(descricao);
                dao.salvar(g);

                response.sendRedirect(request.getContextPath() + "/formulario/genero/listagem.jsp");
                return;

            } else if (acao.equals("alterar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String descricao = request.getParameter("descricao");
                Genero g = new Genero();
                g.setId(id);
                g.setDescricao(descricao);

                dao.atualizar(g);

                response.sendRedirect(request.getContextPath() + "/formulario/genero/listagem.jsp");
                return;
            } else if ((acao.equals("excluir"))) {
                int id = Integer.parseInt(request.getParameter("id"));
                Genero g = new Genero();
                g.setId(id);

                dao.excluir(g);
                response.sendRedirect(request.getContextPath() + "/formulario/genero/listagem.jsp");
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
