/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Genero;

/**
 *
 * @author gabri
 */
public class GeneroService {
    
    public List<Genero> getTodos(){
        
        List<Genero> lista = new ArrayList();
        
        try(GeneroDAO dao = new GeneroDAO()){
            lista = dao.listarTodos();
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        return lista;
    
}
}
