/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import java.sql.SQLException;
import java.util.List;
import locacaodvds.entidades.Dvd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.Classificacao_etaria;
import locacaodvds.entidades.Genero;
/**
 *
 * @author gabri
 */
public class DvdDAO extends DAO<Dvd>{
    
    public DvdDAO() throws SQLException{
        
    }

    @Override
    public void salvar(Dvd obj) throws SQLException {
        String sql = "INSERT INTO dvd (titulo, ano_lancamento, data_lancamento, duracao_minutos, " +
                     "genero_id, classificacao_etaria_id, ator_principal_id, ator_coadjuvante_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, obj.getTitulo());
            stmt.setInt(2, obj.getAnoLancamento());
            stmt.setDate(3, obj.getDataLancamento());
            stmt.setInt(4, obj.getDuracaoEmMinutos());
            stmt.setInt(5, obj.getGenero().getId());
            stmt.setInt(6, obj.getClassificacaoEtaria().getId());
            stmt.setInt(7, obj.getAtorPrincipal().getId());
            stmt.setInt(8, obj.getAtorCoadjuvante().getId());
            stmt.executeUpdate();
    }
   }
    @Override
    public void atualizar(Dvd obj) throws SQLException {
        String sql = "UPDATE dvd SET titulo = ?, ano_lancamento = ?, data_lancamento = ?, duracao_minutos = ?, " +
                     "genero_id = ?, classificacao_etaria_id = ?, ator_principal_id = ?, ator_coadjuvante_id = ? " +
                     "WHERE id = ?;";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, obj.getTitulo());
            stmt.setInt(2, obj.getAnoLancamento());
            stmt.setDate(3, obj.getDataLancamento());
            stmt.setInt(4, obj.getDuracaoEmMinutos());
            stmt.setInt(5, obj.getGenero().getId());
            stmt.setInt(6, obj.getClassificacaoEtaria().getId());
            stmt.setInt(7, obj.getAtorPrincipal().getId());
            stmt.setInt(8, obj.getAtorCoadjuvante().getId());
            stmt.setInt(9, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(Dvd obj) throws SQLException {
        String sql = "DELETE FROM dvd WHERE id = ?;";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Dvd> listarTodos() throws SQLException {
        List<Dvd> lista = new ArrayList<>();
      
        String sql = "SELECT " +
                     "d.id AS dvd_id, d.titulo AS dvd_titulo, d.ano_lancamento, d.data_lancamento, d.duracao_minutos, " +
                     "g.id AS genero_id, g.descricao AS genero_descricao, " +
                     "ce.id AS class_id, ce.descricao AS class_descricao, " +
                     "ap.id AS ator_p_id, ap.nome AS ator_p_nome, ap.sobrenome AS ator_p_sobrenome, " +
                     "ac.id AS ator_c_id, ac.nome AS ator_c_nome, ac.sobrenome AS ator_c_sobrenome " +
                     "FROM dvd d " +
                     "JOIN genero g ON d.genero_id = g.id " +
                     "JOIN classificacao_etaria ce ON d.classificacao_etaria_id = ce.id " +
                     "JOIN ator ap ON d.ator_principal_id = ap.id " +
                     "JOIN ator ac ON d.ator_coadjuvante_id = ac.id " +
                     "ORDER BY d.titulo;";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Montagem dos objetos aninhados
                Genero g = new Genero();
                g.setId(rs.getInt("genero_id"));
                g.setDescricao(rs.getString("genero_descricao"));

                Classificacao_etaria ce = new Classificacao_etaria();
                ce.setId(rs.getInt("class_id"));
                ce.setDescricao(rs.getString("class_descricao"));

                Ator ap = new Ator();
                ap.setId(rs.getInt("ator_p_id"));
                ap.setNome(rs.getString("ator_p_nome"));
                ap.setSobrenome(rs.getString("ator_p_sobrenome"));
                
                Ator ac = new Ator();
                ac.setId(rs.getInt("ator_c_id"));
                ac.setNome(rs.getString("ator_c_nome"));
                ac.setSobrenome(rs.getString("ator_c_sobrenome"));

                Dvd dvd = new Dvd();
                dvd.setId(rs.getInt("dvd_id"));
                dvd.setTitulo(rs.getString("dvd_titulo"));
                dvd.setAnoLancamento(rs.getInt("ano_lancamento"));
                dvd.setDataLancamento(rs.getDate("data_lancamento"));
                dvd.setDuracaoEmMinutos(rs.getInt("duracao_minutos"));
                dvd.setGenero(g);
                dvd.setClassificacaoEtaria(ce);
                dvd.setAtorPrincipal(ap);
                dvd.setAtorCoadjuvante(ac);

                lista.add(dvd);
            }
        }
        return lista;
    }

    @Override
    public Dvd obterPorId(int id) throws SQLException {

    Dvd dvd = null;
    String sql = "SELECT " +
                 "d.id AS dvd_id, d.titulo AS dvd_titulo, d.ano_lancamento, d.data_lancamento, d.duracao_minutos, " + 
                 "g.id AS genero_id, g.descricao AS genero_descricao, " +
                 "ce.id AS class_id, ce.descricao AS class_descricao, " +
                 "ap.id AS ator_p_id, ap.nome AS ator_p_nome, ap.sobrenome AS ator_p_sobrenome, " +
                 "ac.id AS ator_c_id, ac.nome AS ator_c_nome, ac.sobrenome AS ator_c_sobrenome " +
                 "FROM dvd d " +
                 "JOIN genero g ON d.genero_id = g.id " +
                 "JOIN classificacao_etaria ce ON d.classificacao_etaria_id = ce.id " +
                 "JOIN ator ap ON d.ator_principal_id = ap.id " +
                 "JOIN ator ac ON d.ator_coadjuvante_id = ac.id " +
                 "WHERE d.id = ?;";

    try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {

        
        stmt.setInt(1, id);

        try (ResultSet rs = stmt.executeQuery()) {
            
            
            if (rs.next()) {


                Genero g = new Genero();
                g.setId(rs.getInt("genero_id"));
                g.setDescricao(rs.getString("genero_descricao"));

                Classificacao_etaria ce = new Classificacao_etaria();
                ce.setId(rs.getInt("class_id"));
                ce.setDescricao(rs.getString("class_descricao"));

                Ator ap = new Ator();
                ap.setId(rs.getInt("ator_p_id"));
                ap.setNome(rs.getString("ator_p_nome"));
                ap.setSobrenome(rs.getString("ator_p_sobrenome"));

                Ator ac = new Ator();
                ac.setId(rs.getInt("ator_c_id"));
                ac.setNome(rs.getString("ator_c_nome"));
                ac.setSobrenome(rs.getString("ator_c_sobrenome"));

                dvd = new Dvd(); 
                dvd.setId(rs.getInt("dvd_id"));
                dvd.setTitulo(rs.getString("dvd_titulo"));
                dvd.setAnoLancamento(rs.getInt("ano_lancamento")); 
                dvd.setDataLancamento(rs.getDate("data_lancamento")); 
                dvd.setDuracaoEmMinutos(rs.getInt("duracao_minutos")); 
                dvd.setGenero(g);
                dvd.setClassificacaoEtaria(ce); 
                dvd.setAtorPrincipal(ap);
                dvd.setAtorCoadjuvante(ac);
            }
        }
    }
    return dvd;
}
}
    
