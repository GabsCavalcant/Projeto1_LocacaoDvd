/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.entidades;

import java.sql.Date;

/**
 *
 * @author gabri
 */
public class Ator {
    private int id;
    private String nome;
    private String sobrenome;
    private Date data_Estreia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getData_Estreia() {
        return data_Estreia;
    }

    public void setData_Estreia(Date data_Estreia) {
        this.data_Estreia = data_Estreia;
    }
    
}
