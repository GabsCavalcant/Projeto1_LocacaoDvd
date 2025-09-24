/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import jakarta.persistence.Cache;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.AtorDAO;
import locacaodvds.entidades.Ator;

/**
 *
 * @author gabri
 */
public class AtorService {
    
    public List<Ator> getTodos(){
        
        List<Ator> lista = new ArrayList<>();
        
        try(AtorDAO dao = new AtorDAO()){
            lista = dao.listarTodos();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
}
