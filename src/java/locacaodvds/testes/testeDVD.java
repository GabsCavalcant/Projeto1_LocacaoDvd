/* package locacaodvds.testes;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import locacaodvds.dao.AtorDAO;
import locacaodvds.dao.Classificacao_etariaDAO;
import locacaodvds.dao.DvdDAO;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.Classificacao_etaria;
import locacaodvds.entidades.Dvd;
import locacaodvds.entidades.Genero;

public class testeDVD {

    public static void main(String[] args) {

        // objetos de teste que precisaremos limpar no final
        Genero generoDeTeste = null;
        Classificacao_etaria ceDeTeste = null;
        Ator atorPDeTeste = null;
        Ator atorCDeTeste = null;
        Dvd dvdDeTeste = null;
        
        System.out.println("Iniciando teste do DVDDAO...");

        try {
            // --- SETUP: CRIANDO DADOS DEPENDENTES ---
            System.out.println("\n[SETUP: Criando dados dependentes...]");
            
            try (GeneroDAO generoDAO = new GeneroDAO();
                 Classificacao_etariaDAO ceDAO = new Classificacao_etariaDAO();
                 AtorDAO atorDAO = new AtorDAO()) {

                // Criar e salvar Genero
                generoDeTeste = new Genero();
                generoDeTeste.setDescricao("Ação (Teste)");
                generoDAO.salvar(generoDeTeste);
                generoDeTeste = generoDAO.listarTodos().get(generoDAO.listarTodos().size() - 1);

                // Criar e salvar Classificação Etária
                ceDeTeste = new Classificacao_etaria();
                ceDeTeste.setDescricao("14 Anos (Teste)");
                ceDAO.salvar(ceDeTeste);
                ceDeTeste = ceDAO.listarTodos().get(ceDAO.listarTodos().size() - 1);
                
                // Criar e salvar Ator Principal
                atorPDeTeste = new Ator();
                atorPDeTeste.setNome("Keanu");
                atorPDeTeste.setSobrenome("Reeves (Teste)");
                atorPDeTeste.setData_Estreia(Date.valueOf("1984-01-01"));
                atorDAO.salvar(atorPDeTeste);
                atorPDeTeste = atorDAO.listarTodos().get(atorDAO.listarTodos().size() - 1);

                // Criar e salvar Ator Coadjuvante
                atorCDeTeste = new Ator();
                atorCDeTeste.setNome("Laurence");
                atorCDeTeste.setSobrenome("Fishburne (Teste)");
                atorCDeTeste.setData_Estreia(Date.valueOf("1973-01-01"));
                atorDAO.salvar(atorCDeTeste);
                atorCDeTeste = atorDAO.listarTodos().get(atorDAO.listarTodos().size() - 1);
                
                System.out.println("Dados dependentes criados com sucesso!");
            }

            // --- TESTES DO DVD ---
            try (DvdDAO dvdDAO = new DvdDAO()) {
                
                // 1. SALVAR DVD
                System.out.println("\n[Passo 1: Saalvando um novo DVD]");
                dvdDeTeste = new Dvd();
                dvdDeTeste.setTitulo("Matrix (Teste)");
                dvdDeTeste.setAno_lancamento(1999);
                dvdDeTeste.setData_lancamento(Date.valueOf("1999-05-21"));
                dvdDeTeste.setDuracaoMinutos(136);
                dvdDeTeste.setGenero(generoDeTeste);
                dvdDeTeste.setClass_etaria(ceDeTeste);
                dvdDeTeste.setAtorPrincipal(atorPDeTeste);
                dvdDeTeste.setAtorCoadjuvante(atorCDeTeste);
                dvdDAO.salvar(dvdDeTeste);
                System.out.println("DVD 'Matrix (Teste)' salvo com sucesso!");
                
                // 2. LISTAR
                System.out.println("\n[Passo 2: Listando DVDs]");
                dvdDeTeste = dvdDAO.listarTodos().get(dvdDAO.listarTodos().size() - 1);
                System.out.println("DVD encontrado: " + dvdDeTeste.getTitulo());
                System.out.println("Ator Principal: " + dvdDeTeste.getAtorPrincipal().getNome());
                
                // 3. ATUALIZAR
                System.out.println("\n[Passo 3: Atualizando o DVD]");
                dvdDeTeste.setTitulo("Matrix Reloaded (Teste)");
                dvdDAO.atualizar(dvdDeTeste);
                System.out.println("Título do DVD atualizado!");
                
                // 4. OBTER POR ID
                System.out.println("\n[Passo 4: Buscando DVD por ID]");
                Dvd dvdAtualizado = dvdDAO.obterPorId(dvdDeTeste.getId());
                System.out.println("Título obtido: " + dvdAtualizado.getTitulo());
                
                // 5. EXCLUIR
                System.out.println("\n[Passo 5: Excluindo o DVD]");
                dvdDAO.excluir(dvdAtualizado);
                System.out.println("DVD de teste excluído!");
            }

        } catch (SQLException e) {
            System.err.println("Ocorreu um erro de banco de dados durante o teste!");
            e.printStackTrace();
        }finally {
    // --- LIMPEZA ROBUSTA: EXCLUINDO DADOS DEPENDENTES ---
    System.out.println("\n[LIMPEZA: Excluindo todos os dados de teste...]");
    try (DvdDAO dvdDAO = new DvdDAO();
         GeneroDAO generoDAO = new GeneroDAO();
         Classificacao_etariaDAO ceDAO = new Classificacao_etariaDAO();
         AtorDAO atorDAO = new AtorDAO()) {

        // PASSO 1: Encontrar e excluir QUALQUER DVD de teste que tenha sobrado.
        // Isso libera as chaves estrangeiras.
        List<Dvd> dvdsDeTeste = dvdDAO.listarTodos();
        for (Dvd dvd : dvdsDeTeste) {
            if (dvd.getTitulo().contains("(Teste)")) {
                dvdDAO.excluir(dvd);
                System.out.println("DVD de teste '" + dvd.getTitulo() + "' limpo.");
            }
        }
        
        // PASSO 2: Agora que os "filhos" (DVDs) foram removidos,
        // podemos excluir os "pais" com segurança.
        if (generoDeTeste != null && generoDeTeste.getId() != 0) {
            generoDAO.excluir(generoDeTeste);
            System.out.println("Gênero de teste limpo.");
        }
        if (ceDeTeste != null && ceDeTeste.getId() != 0) {
            ceDAO.excluir(ceDeTeste);
            System.out.println("Classificação Etária de teste limpa.");
        }
        if (atorPDeTeste != null && atorPDeTeste.getId() != 0) {
            atorDAO.excluir(atorPDeTeste);
            System.out.println("Ator Principal de teste limpo.");
        }
        if (atorCDeTeste != null && atorCDeTeste.getId() != 0) {
            atorDAO.excluir(atorCDeTeste);
            System.out.println("Ator Coadjuvante de teste limpo.");
        }

        System.out.println("Limpeza finalizada.");

    } catch (SQLException e) {
        System.err.println("Ocorreu um erro durante a limpeza dos dados de teste.");
        e.printStackTrace();
    }
}}} */