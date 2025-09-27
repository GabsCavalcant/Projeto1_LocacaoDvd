package locacaodvds.controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import locacaodvds.dao.Classificacao_etariaDAO;
import locacaodvds.entidades.Classificacao_etaria;

/**
 *
 * @author gabri
 */

@WebServlet(name = "ClassificacoesEtariasServlet", urlPatterns = {"/processaClassificacoesEtarias"})
public class ClassificacoesEtariasServlet extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        RequestDispatcher disp = null;

        try (Classificacao_etariaDAO dao = new Classificacao_etariaDAO()) {

            if (acao.equals("prepararAlteracao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Classificacao_etaria ce = dao.obterPorId(id);
                request.setAttribute("classificacaoEtaria", ce);
                disp = request.getRequestDispatcher("/formulario/classificacao-etaria/alterar.jsp");

            } else if (acao.equals("prepararExclusao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Classificacao_etaria ce = dao.obterPorId(id);
                request.setAttribute("classificacaoEtaria", ce);
                disp = request.getRequestDispatcher("/formulario/classificacao-etaria/excluir.jsp");

            } else if (acao.equals("inserir")) {
                String descricao = request.getParameter("descricao");
                Classificacao_etaria ce = new Classificacao_etaria();
                ce.setDescricao(descricao);
                dao.salvar(ce);
                response.sendRedirect(request.getContextPath() + "/formulario/classificacao-etaria/listagem.jsp");
                return;

            } else if (acao.equals("alterar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String descricao = request.getParameter("descricao");
                Classificacao_etaria ce = new Classificacao_etaria();
                ce.setId(id);
                ce.setDescricao(descricao);
                dao.atualizar(ce);
                response.sendRedirect(request.getContextPath() + "/formulario/classificacao-etaria/listagem.jsp");
                return;

            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Classificacao_etaria ce = new Classificacao_etaria();
                ce.setId(id);
                dao.excluir(ce);
                response.sendRedirect(request.getContextPath() + "/formulario/classificacao-etaria/listagem.jsp");
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (disp != null) {
            disp.forward(request, response);
        }
    }
    
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