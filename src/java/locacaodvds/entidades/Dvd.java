package locacaodvds.entidades;

import java.sql.Date;

public class Dvd {

    private int id;
    private String titulo;
    private int anoLancamento;
    private Date dataLancamento;
    private int duracaoEmMinutos; 

    // Relacionamentos
    private Genero genero;
    private Classificacao_etaria classificacaoEtaria;
    private Ator atorPrincipal;
    private Ator atorCoadjuvante;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

   
    public Date getDataLancamento() {
        return dataLancamento;
    }

    
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Classificacao_etaria getClassificacaoEtaria() {
        return classificacaoEtaria;
    }
    public void setClassificacaoEtaria(Classificacao_etaria classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public Ator getAtorPrincipal() {
        return atorPrincipal;
    }
    public void setAtorPrincipal(Ator atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }

    public Ator getAtorCoadjuvante() {
        return atorCoadjuvante;
    }
    public void setAtorCoadjuvante(Ator atorCoadjuvante) {
        this.atorCoadjuvante = atorCoadjuvante;
    }
}