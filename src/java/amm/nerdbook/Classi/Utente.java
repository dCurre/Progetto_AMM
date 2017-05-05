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
public class Utente
{
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String urlFotoProfilo;
    private String frasePersonale;
    
    public Utente()//costruttore che setta tutto a vuoto o 0
    {
        id = 0;
        nome = "";
        cognome = "";
        email = "";
        password = "";
        urlFotoProfilo = "";
        frasePersonale = "";
    }
    public Utente(int id, String nome, String cognome, String email, String password, String urlFotoProfilo, String fraseP)
    {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.urlFotoProfilo = urlFotoProfilo;
        this.frasePersonale = fraseP;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }

    /**
     * @return the frasePersonale
     */
    public String getFrasePersonale() {
        return frasePersonale;
    }

    /**
     * @param frasePersonale the frasePersonale to set
     */
    public void setFrasePersonale(String frasePersonale) {
        this.frasePersonale = frasePersonale;
    }
    
    @Override
    public boolean equals(Object anotherUser) {
        if (anotherUser instanceof Utente)
            if (this.getId() == ((Utente)anotherUser).getId()) return true;
        return false;
    }
}
