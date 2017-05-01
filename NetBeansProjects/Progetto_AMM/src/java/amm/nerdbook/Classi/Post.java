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
    
    private int id;
    private Utente owner;
    private String gruppoDiRiferimento; //identifica in quale gruppo si trova il post nel caso sia postato in un gruppo
    private String content;
    private Type postType;
    
    public Post()
    {
        id = 0;
        owner = null;
        gruppoDiRiferimento = "";
        content = "";
        postType = Type.TEXT;
    }
    public Post(int id, Utente owner,String gruppo, String content, Type postType)
    {
        this.id = id;
        this.owner = owner;
        this.gruppoDiRiferimento = gruppo;
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
     * @return the owner
     */
    public Utente getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Utente owner) {
        this.owner = owner;
    }

    /**
     * @return the group
     */
    public String getGruppoDiRiferimento() {
        return this.gruppoDiRiferimento;
    }

    /**
     * @param owner the group to set
     */
    public void setGruppoDiRiferimento(String group) {
        this.gruppoDiRiferimento = group;
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
