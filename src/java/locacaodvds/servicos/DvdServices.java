/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.DvdDAO;
import locacaodvds.entidades.Dvd;

/**
 *
 * @author gabri
 */
public class DvdServices {
    
    public List<Dvd> getTodos(){
        
        List<Dvd> lista = new ArrayList<>();
        
        try(DvdDAO dao = new DvdDAO()){
            lista = dao.listarTodos();
            
            
        
    }catch(SQLException e){
        e.printStackTrace();
    }
        return lista;
    
}
}
