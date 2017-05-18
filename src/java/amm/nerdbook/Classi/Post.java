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
    public enum Type
    {
        TEXT, IMAGE
    };
    
    private int id; //id univoco del post
    private int user;
    private Gruppo gruppo; //identifica in quale gruppo si trova il post nel caso sia postato in un gruppo
    private String content;//stringa di testo
    private String img; //stringa immagine
    private Type postType;// tipologia di post
    
    public Post()
    {
        id = 0;
        user = 0;
        content = "";
        postType = Type.TEXT;
    }
    public Post(int id, int user, String content, Type postType)
    {
        this.id = id;
        this.user = user;
        this.content = content;
        this.postType = postType;
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
     * @return the user
     */
    public int getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(int user) {
        this.user = user;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the postType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    }
    
}
