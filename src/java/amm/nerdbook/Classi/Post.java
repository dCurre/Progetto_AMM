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
public class Post
{    
    private int id; //id univoco del post
    private int user;//id dello user
    private String content;//stringa di testo
    private String img; //stringa immagine, null se non è presente un'immagine
    private int ricevente;//id del ricevente del post 
    
    public Post(){
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @return the ricevente
     */
    public int getRicevente() {
        return ricevente;
    }

    /**
     * @return the user
     */
    public int getUser() {
        return user;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @param ricevente the ricevente to set
     */
    public void setRicevente(int ricevente) {
        this.ricevente = ricevente;
    }

    /**
     * @param user the user to set
     */
    public void setUser(int user) {
        this.user = user;
    }
    
}
