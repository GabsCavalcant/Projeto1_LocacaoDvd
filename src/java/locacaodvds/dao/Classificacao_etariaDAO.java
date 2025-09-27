/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.Classificacao_etaria;
import locacaodvds.jdbc.ConnectionFactory;

/**
 *
 * @author gabri
 */
public class Classificacao_etariaDAO extends DAO<Classificacao_etaria>{

    public Classificacao_etariaDAO() throws SQLException {
        //....
    }

    @Override
    public void salvar(Classificacao_etaria obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
            INSERT INTO
            classificacao_etaria( descricao )
            VALUES( ?);
            """);

        stmt.setString(1, obj.getDescricao());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Classificacao_etaria obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
            UPDATE classificacao_etaria
            SET
                descricao = ?
            WHERE
                id = ?;
            """);

        stmt.setString(1, obj.getDescricao());
        stmt.setInt(2, obj.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Classificacao_etaria obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
            DELETE FROM classificacao_etaria
            WHERE
                id = ?;
            """);

        stmt.setInt(1, obj.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Classificacao_etaria> listarTodos() throws SQLException {
        List<Classificacao_etaria> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                """
            SELECT * FROM classificacao_etaria
            ORDER BY descricao;
            """);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Classificacao_etaria g = new Classificacao_etaria();

            g.setId(rs.getInt("id"));
            g.setDescricao(rs.getString("descricao"));
            lista.add(g);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Classificacao_etaria obterPorId(int id) throws SQLException {
        Classificacao_etaria genero = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                """
            SELECT * FROM classificacao_etaria
            WHERE id = ?;
            """);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            genero = new Classificacao_etaria();

            genero.setId(rs.getInt("id"));
            genero.setDescricao(rs.getString("descricao"));

        }

        rs.close();
        stmt.close();

        return genero;
    }

}
