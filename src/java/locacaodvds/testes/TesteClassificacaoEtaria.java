package locacaodvds.testes;

import java.sql.SQLException;
import java.util.List;
import locacaodvds.dao.Classificacao_etariaDAO;
import locacaodvds.entidades.Classificacao_etaria;

public class TesteClassificacaoEtaria {

    public static void main(String[] args) {

        System.out.println("Iniciando teste da Classificacao_etariaDAO...");

        // Usamos o nome exato da sua classe DAO
        try (Classificacao_etariaDAO dao = new Classificacao_etariaDAO()) {

            // 1. SALVAR
            System.out.println("\n[Passo 1: Salvando uma nova classificação]");
            Classificacao_etaria novaClassificacao = new Classificacao_etaria();
            novaClassificacao.setDescricao("Livre para Testes");
            dao.salvar(novaClassificacao);
            System.out.println("Classificação 'Livre para Testes' salva com sucesso!");

            // 2. LISTAR (para verificação)
            System.out.println("\n[Passo 2: Listando todas as classificações]");
            List<Classificacao_etaria> todas = dao.listarTodos();
            Classificacao_etaria classificacaoSalva = null;

            for (Classificacao_etaria ce : todas) {
                System.out.println("ID: " + ce.getId() + " - Descrição: " + ce.getDescricao());
                if (ce.getDescricao().equals("Livre para Testes")) {
                    classificacaoSalva = ce;
                }
            }

            if (classificacaoSalva == null) {
                System.out.println("ERRO: Classificação de teste não encontrada após salvar.");
                return; // Encerra o teste
            }

            // 3. ATUALIZAR
            System.out.println("\n[Passo 3: Atualizando a classificação salva]");
            classificacaoSalva.setDescricao("Proibido para Menores de 18 (Teste)");
            dao.atualizar(classificacaoSalva);
            System.out.println("Descrição atualizada para 'Proibido para Menores de 18 (Teste)'!");

            // 4. OBTER POR ID (para verificação)
            System.out.println("\n[Passo 4: Buscando classificação atualizada por ID]");
            Classificacao_etaria classificacaoAtualizada = dao.obterPorId(classificacaoSalva.getId());
            System.out.println("Descrição obtida: " + classificacaoAtualizada.getDescricao());

            // 5. EXCLUIR
            System.out.println("\n[Passo 5: Excluindo a classificação de teste]");
            dao.excluir(classificacaoAtualizada);
            System.out.println("Classificação de teste excluída com sucesso!");

            // 6. LISTAR (para verificação final)
            System.out.println("\n[Passo 6: Listando todas as classificações após exclusão]");
            todas = dao.listarTodos();
            for (Classificacao_etaria ce : todas) {
                System.out.println("ID: " + ce.getId() + " - Descrição: " + ce.getDescricao());
            }
            
            System.out.println("\nTeste da Classificacao_etariaDAO finalizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Ocorreu um erro de banco de dados durante o teste!");
            e.printStackTrace();
        }
    }
}