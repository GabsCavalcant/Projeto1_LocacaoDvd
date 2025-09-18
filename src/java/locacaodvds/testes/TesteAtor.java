package locacaodvds.testes;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import locacaodvds.dao.AtorDAO;
import locacaodvds.entidades.Ator;

public class TesteAtor {

    public static void main(String[] args) {

        System.out.println("Iniciando teste do AtorDAO...");

        try (AtorDAO dao = new AtorDAO()) {

            // 1. SALVAR
            System.out.println("\n[Passo 1: Salvando um novo ator]");
            Ator novoAtor = new Ator();
            novoAtor.setNome("Tom");
            novoAtor.setSobrenome("Hanks (Teste)");
            // Criando um java.sql.Date a partir de uma String no formato YYYY-MM-DD
            novoAtor.setData_Estreia(Date.valueOf("1980-01-15"));
            dao.salvar(novoAtor);
            System.out.println("Ator 'Tom Hanks (Teste)' salvo com sucesso!");

            // 2. LISTAR (para verificação)
            System.out.println("\n[Passo 2: Listando todos os atores]");
            List<Ator> todos = dao.listarTodos();
            Ator atorSalvo = null;

            for (Ator a : todos) {
                System.out.println(
                    "ID: " + a.getId() + 
                    " - Nome: " + a.getNome() + " " + a.getSobrenome() +
                    " - Estreia: " + a.getData_Estreia()
                );
                if (a.getSobrenome().equals("Hanks (Teste)")) {
                    atorSalvo = a;
                }
            }

            if (atorSalvo == null) {
                System.out.println("ERRO: Ator de teste não encontrado após salvar.");
                return; // Encerra o teste
            }

            // 3. ATUALIZAR
            System.out.println("\n[Passo 3: Atualizando o ator salvo]");
            atorSalvo.setNome("Thomas"); // Mudando o nome
            atorSalvo.setData_Estreia(Date.valueOf("1981-03-20")); // Mudando a data
            dao.atualizar(atorSalvo);
            System.out.println("Ator atualizado com sucesso!");

            // 4. OBTER POR ID (para verificação)
            System.out.println("\n[Passo 4: Buscando ator atualizado por ID]");
            Ator atorAtualizado = dao.obterPorId(atorSalvo.getId());
            System.out.println(
                "Nome obtido: " + atorAtualizado.getNome() +
                " - Nova Estreia: " + atorAtualizado.getData_Estreia()
            );

            // 5. EXCLUIR
            System.out.println("\n[Passo 5: Excluindo o ator de teste]");
            dao.excluir(atorAtualizado);
            System.out.println("Ator de teste excluído com sucesso!");

            // 6. LISTAR (para verificação final)
            System.out.println("\n[Passo 6: Listando todos os atores após exclusão]");
            todos = dao.listarTodos();
            for (Ator a : todos) {
                System.out.println(
                    "ID: " + a.getId() + 
                    " - Nome: " + a.getNome() + " " + a.getSobrenome()
                );
            }
            
            System.out.println("\nTeste do AtorDAO finalizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Ocorreu um erro de banco de dados durante o teste!");
            e.printStackTrace();
        }
    }
}