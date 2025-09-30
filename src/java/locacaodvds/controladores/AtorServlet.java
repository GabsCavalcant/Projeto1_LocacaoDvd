package locacaodvds.controladores;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.sql.Date;
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
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String data = request.getParameter("dataEstreia");
                LocalDate dataLocalDate = LocalDate.parse(data);
                Date dataSalvar = Date.valueOf(dataLocalDate);
                
                Ator g = new Ator();
                g.setNome(nome);
                g.setSobrenome(sobrenome);
                g.setData_Estreia(dataSalvar);
                
                dao.salvar(g);

                response.sendRedirect(request.getContextPath() + "/formulario/ator/listagem.jsp");
                return;

            } else if (acao.equals("alterar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String data = request.getParameter("dataEstreia");
                LocalDate dataLocalDate = LocalDate.parse(data);
                Date dataParaSalvar = Date.valueOf(dataLocalDate);

                Ator g = new Ator();
                g.setId(id);
                g.setNome(nome);
                g.setSobrenome(sobrenome);
                g.setData_Estreia(dataParaSalvar);

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
