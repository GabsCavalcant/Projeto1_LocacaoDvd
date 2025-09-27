/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;
import java.sql.SQLException;
import java.util.ArrayList;
import locacaodvds.entidades.Classificacao_etaria;
import locacaodvds.dao.Classificacao_etariaDAO;
import java.util.List;

/**
 *
 * @author gabri
 */
public class Classificacao_etariaService {
    
    public List<Classificacao_etaria> getTodos(){
        
        List<Classificacao_etaria> lista = new ArrayList<>();
        
        try(Classificacao_etariaDAO dao = new Classificacao_etariaDAO()) {
           
                    
            lista = dao.listarTodos();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }return lista;
    }
        
}
