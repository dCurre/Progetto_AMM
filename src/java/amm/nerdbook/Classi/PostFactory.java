/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author davide
 */
public class PostFactory {
    
    //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance()
    {
        if (singleton == null)
            singleton = new PostFactory();
        
        return singleton;
    }
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB
    
    
    private ArrayList<Post> postList = new ArrayList<Post>();

    public PostFactory()
    {    
        UtenteFactory userFactory = UtenteFactory.getInstance();
        //GruppoFactory gruppoFactory = GruppoFactory.getInstance();
        /**
        //Creazione Post
        Post post0 = new Post(0,userFactory.getUserById(0),gruppoFactory.getGroupById(0),"Frase a caso1",Post.Type.TEXT);
        postList.add(post0);
        
        Post post1 = new Post(1,userFactory.getUserById(1),gruppoFactory.getGroupById(0),"../img/fotoLandscapePost.jpg",Post.Type.IMAGE);
        postList.add(post1);
        
        Post post2 = new Post(2,userFactory.getUserById(2),gruppoFactory.getGroupById(0),"Sempre sia lodato",Post.Type.TEXT);
        postList.add(post2);
        
        Post post3 = new Post(3,userFactory.getUserById(0),gruppoFactory.getGroupById(0),"Frase a caaaaaaso1",Post.Type.TEXT);
        postList.add(post3);
        
        Post post4 = new Post(4,userFactory.getUserById(2),gruppoFactory.getGroupById(0),"Alzati e cammina",Post.Type.TEXT);
        postList.add(post4);
        
        Post post5 = new Post(5,userFactory.getUserById(2),gruppoFactory.getGroupById(0),"http://static.qnm.it/www/fotogallery/1200X0/195073/selfie-sosia-di-gesu.jpg",Post.Type.IMAGE);
        postList.add(post5);
        
        Post post6 = new Post(6,userFactory.getUserById(3),gruppoFactory.getGroupById(0),"../img/fotoLandscapePost.jpg",Post.Type.IMAGE);
        postList.add(post6);
        
        Post post7 = new Post(7,userFactory.getUserById(1),gruppoFactory.getGroupById(0),"Frase a caaaaaaso1",Post.Type.TEXT);
        postList.add(post7);
        
        Post post8 = new Post(8,userFactory.getUserById(0),gruppoFactory.getGroupById(0),"../img/fotoLandscapePost.jpg",Post.Type.IMAGE);
        postList.add(post8);
        
        Post post9 = new Post(9,userFactory.getUserById(3),gruppoFactory.getGroupById(0),"../img/allegatoProfilo2.jpg",Post.Type.IMAGE);
        postList.add(post9);*/
    }
    public ArrayList<Post> getPostListByUserId(int id)
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "dCurre", "1234");
            
            String query = "select * from posts " + "where author = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            ArrayList<Post> arrayPost = new ArrayList<>();
            // ciclo sulle righe restituite
            while(res.next())
            {
                Post current = new Post();
                current.setId(res.getInt("id"));
                current.setUser(res.getInt("author"));
                current.setContent(res.getString("content"));
                current.setImg(res.getString("img"));
                
                arrayPost.add(current);
            }
            stmt.close();
            conn.close();
            return arrayPost;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }    
    
}
