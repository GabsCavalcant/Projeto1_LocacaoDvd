package locacaodvds.testes;

import java.sql.SQLException;
import java.util.List;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Genero;

public class TesteGenero {

    public static void main(String[] args) {

        System.out.println("Iniciando teste do GeneroDAO...");

        try (GeneroDAO dao = new GeneroDAO()) {

            // 1. SALVAR
            System.out.println("\n[Passo 1: Salvando um novo gênero]");
            Genero novoGenero = new Genero();
            novoGenero.setDescricao("Aventura de Teste");
            dao.salvar(novoGenero);
            System.out.println("Gênero 'Aventura de Teste' salvo com sucesso!");

            // 2. LISTAR (para verificação)
            System.out.println("\n[Passo 2: Listando todos os gêneros]");
            List<Genero> todos = dao.listarTodos();
            Genero generoSalvo = null; // Vamos guardar o gênero que salvamos

            for (Genero g : todos) {
                System.out.println("ID: " + g.getId() + " - Descrição: " + g.getDescricao());
                if (g.getDescricao().equals("Aventura de Teste")) {
                    generoSalvo = g;
                }
            }

            // Garante que o resto do teste só continue se o gênero foi salvo
            if (generoSalvo == null) {
                System.out.println("ERRO: Gênero de teste não encontrado após salvar.");
                return; // Encerra o teste
            }

            // 3. ATUALIZAR
            System.out.println("\n[Passo 3: Atualizando o gênero salvo]");
            generoSalvo.setDescricao("Ficção Científica de Teste");
            dao.atualizar(generoSalvo);
            System.out.println("Descrição atualizada para 'Ficção Científica de Teste'!");

            // 4. OBTER POR ID (para verificação)
            System.out.println("\n[Passo 4: Buscando gênero atualizado por ID]");
            Genero generoAtualizado = dao.obterPorId(generoSalvo.getId());
            System.out.println("Descrição obtida: " + generoAtualizado.getDescricao());

            // 5. EXCLUIR
            System.out.println("\n[Passo 5: Excluindo o gênero de teste]");
            dao.excluir(generoAtualizado);
            System.out.println("Gênero de teste excluído com sucesso!");

            // 6. LISTAR (para verificação final)
            System.out.println("\n[Passo 6: Listando todos os gêneros após exclusão]");
            todos = dao.listarTodos();
            for (Genero g : todos) {
                System.out.println("ID: " + g.getId() + " - Descrição: " + g.getDescricao());
            }
            
            System.out.println("\nTeste do GeneroDAO finalizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Ocorreu um erro de banco de dados durante o teste!");
            e.printStackTrace();
        }
    }
}