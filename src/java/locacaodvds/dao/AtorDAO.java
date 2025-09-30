/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date; 
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.Genero;

/**
 *
 * @author gabri
 */
public class AtorDAO extends DAO<Ator>{
    
    public AtorDAO()throws SQLException{
        
    }

    @Override
    public void salvar(Ator obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
            INSERT INTO
            ator( nome,sobrenome,data_estreia )
            VALUES( ?,?,?);
            """);

        
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getSobrenome());
        stmt.setDate(3, obj.getData_Estreia());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Ator obj) throws SQLException {
         PreparedStatement stmt = getConnection().prepareStatement(
            """
            UPDATE ator
            SET
                nome = ?,
                sobrenome = ?,
                data_estreia = ?

            WHERE
                id = ?;
            """);

        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getSobrenome());
        stmt.setDate(3, obj.getData_Estreia());
        stmt.setInt(4, obj.getId());

        stmt.executeUpdate();
        stmt.close();    }

    @Override
    public void excluir(Ator obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
            DELETE FROM ator
            WHERE
                id = ?;
            """);

        stmt.setInt(1, obj.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Ator> listarTodos() throws SQLException {
        List<Ator> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
            """
            SELECT * FROM ator
            ORDER BY nome,sobrenome, data_Estreia;
            """);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Ator a = new Ator();

            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setSobrenome(rs.getString("sobrenome"));
            a.setData_Estreia(rs.getDate("data_Estreia"));
            lista.add(a);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Ator obterPorId(int id) throws SQLException {
       Ator ator = null;

        PreparedStatement stmt = getConnection().prepareStatement(
            """
            SELECT * FROM ator
            WHERE id = ?;
            """);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            ator = new Ator();

            ator.setId(rs.getInt("id"));
            ator.setNome(rs.getString("nome"));
            ator.setSobrenome(rs.getString("sobrenome"));
            ator.setData_Estreia(rs.getDate("data_estreia"));

        }

        rs.close();
        stmt.close();

        return ator;
    }
    
   
    
}
