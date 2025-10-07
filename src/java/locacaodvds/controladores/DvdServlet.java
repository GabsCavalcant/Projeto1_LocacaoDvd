package locacaodvds.controladores;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import locacaodvds.dao.AtorDAO;
import locacaodvds.dao.Classificacao_etariaDAO;
import locacaodvds.dao.DvdDAO;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.Classificacao_etaria;
import locacaodvds.entidades.Dvd;
import locacaodvds.entidades.Genero;

@WebServlet(name = "DvdServlet", urlPatterns = {"/processaDvds"})
public class DvdServlet extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        RequestDispatcher disp = null;

        try {
                //Coloquei alguns debus para verificar error
            if (acao.equals("prepararAlteracao")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println("--- DEBUG: Buscando DVD com ID = " + id);
                
                try (DvdDAO dvdDAO = new DvdDAO();
                     GeneroDAO generoDAO = new GeneroDAO();
                     Classificacao_etariaDAO classDAO = new Classificacao_etariaDAO();
                     AtorDAO atorDAO = new AtorDAO()) {
                    
                    Dvd dvd = dvdDAO.obterPorId(id);
                     System.out.println("--- DEBUG: Objeto DVD encontrado: " + (dvd != null ? dvd.getTitulo() : "NULO!"));
                     List<Genero> generos = generoDAO.listarTodos();
                     List<Classificacao_etaria> classificacoes = classDAO.listarTodos();
                     List<Ator> atores = atorDAO.listarTodos();
                    request.setAttribute("dvd", dvd);
                    
                    request.setAttribute("generos", generoDAO.listarTodos());
                    request.setAttribute("classificacoes", classDAO.listarTodos());
                    request.setAttribute("atores", atorDAO.listarTodos());
                    System.out.println("--- DEBUG: Atributos adicionados à requisição.");
                }
                
                disp = request.getRequestDispatcher("/formulario/dvds/alterar.jsp");

            } else if (acao.equals("prepararExclusao")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                try (DvdDAO dao = new DvdDAO()) {
                    Dvd dvd = dao.obterPorId(id);
                    request.setAttribute("dvd", dvd);
                }
                
                disp = request.getRequestDispatcher("/formulario/dvds/excluir.jsp");
               System.out.println("--- DEBUG: Redirecionamento para alterar.jsp preparado.");
            
            } else if (acao.equals("inserir")) {
                
                 
                try (DvdDAO dao = new DvdDAO()) {
                    
                    String titulo = request.getParameter("titulo");
                    int anoLancamento = Integer.parseInt(request.getParameter("anoLancamento"));
                    Date dataLancamento = Date.valueOf(request.getParameter("dataLancamento"));
                    int duracaoEmMinutos = Integer.parseInt(request.getParameter("duracaoEmMinutos"));

                    int genero_id = Integer.parseInt(request.getParameter("genero_id"));
                    int classificacaoEtaria_id = Integer.parseInt(request.getParameter("classificacaoEtaria_id"));
                    int atorPrincipal_id = Integer.parseInt(request.getParameter("atorPrincipal_id"));
                    int atorCoadjuvante_id = Integer.parseInt(request.getParameter("atorCoadjuvante_id"));

                    Genero genero = new Genero();
                    genero.setId(genero_id);

                    Classificacao_etaria ce = new Classificacao_etaria();
                    ce.setId(classificacaoEtaria_id);

                    Ator atorPrincipal = new Ator();
                    atorPrincipal.setId(atorPrincipal_id);

                    Ator atorCoadjuvante = new Ator();
                    atorCoadjuvante.setId(atorCoadjuvante_id);

                    Dvd dvd = new Dvd();
                    dvd.setTitulo(titulo);
                    dvd.setAnoLancamento(anoLancamento);
                    dvd.setDataLancamento(dataLancamento);
                    dvd.setDuracaoEmMinutos(duracaoEmMinutos);
                    dvd.setGenero(genero);
                    dvd.setClassificacaoEtaria(ce);
                    dvd.setAtorPrincipal(atorPrincipal);
                    dvd.setAtorCoadjuvante(atorCoadjuvante);

                    
                    dao.salvar(dvd);
                }
                
                response.sendRedirect(request.getContextPath() + "/formulario/dvds/listagem.jsp");
                return;

            } else if (acao.equals("alterar")) {

                try (DvdDAO dao = new DvdDAO()) {
                
                // Pega o ID do DVD a ser alterado
                int id = Integer.parseInt(request.getParameter("id"));
                
                String titulo = request.getParameter("titulo");
                int anoLancamento = Integer.parseInt(request.getParameter("anoLancamento"));
                Date dataLancamento = Date.valueOf(request.getParameter("dataLancamento"));
                int duracaoEmMinutos = Integer.parseInt(request.getParameter("duracaoEmMinutos"));
                int genero_id = Integer.parseInt(request.getParameter("genero_id"));
                int classificacaoEtaria_id = Integer.parseInt(request.getParameter("classificacaoEtaria_id"));
                int atorPrincipal_id = Integer.parseInt(request.getParameter("atorPrincipal_id"));
                int atorCoadjuvante_id = Integer.parseInt(request.getParameter("atorCoadjuvante_id"));

                Genero genero = new Genero();
                genero.setId(genero_id);

                Classificacao_etaria ce = new Classificacao_etaria();
                ce.setId(classificacaoEtaria_id);

                Ator atorPrincipal = new Ator();
                atorPrincipal.setId(atorPrincipal_id);

                Ator atorCoadjuvante = new Ator();
                atorCoadjuvante.setId(atorCoadjuvante_id);

                Dvd dvd = new Dvd();
                dvd.setId(id); 
                dvd.setTitulo(titulo);
                dvd.setAnoLancamento(anoLancamento);
                dvd.setDataLancamento(dataLancamento);
                dvd.setDuracaoEmMinutos(duracaoEmMinutos);
                dvd.setGenero(genero);
                dvd.setClassificacaoEtaria(ce);
                dvd.setAtorPrincipal(atorPrincipal);
                dvd.setAtorCoadjuvante(atorCoadjuvante);
                
                dao.atualizar(dvd);
                }
                
                response.sendRedirect(request.getContextPath() + "/formulario/dvds/listagem.jsp");
                return;
                
            } else if (acao.equals("excluir")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                try(DvdDAO dao = new DvdDAO()){
                    Dvd dvd = new Dvd();
                    dvd.setId(id);
                    dao.excluir(dvd);
                }
                
                response.sendRedirect(request.getContextPath() + "/formulario/dvds/listagem.jsp");
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