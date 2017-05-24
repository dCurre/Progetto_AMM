/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

/**
 *
 * @author davide
 */
public class Gruppo
{ 
    private int id;
    private String nome;
    private String urlFotoGruppo;
    
    public Gruppo(){
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the urlFotoGruppo
     */
    public String getUrlFotoGruppo() {
        return urlFotoGruppo;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param urlFotoGruppo the urlFotoGruppo to set
     */
    public void setUrlFotoGruppo(String urlFotoGruppo) {
        this.urlFotoGruppo = urlFotoGruppo;
    }

    
}
