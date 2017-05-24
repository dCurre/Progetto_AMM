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

    public PostFactory(){
    }
    public ArrayList<Post> getPostListByUserId(int id)
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "dCurre", "1234");
            
            String query = "select * from posts " + "where ricevente = ?";
            
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
    public ArrayList<Post> getPostListByGroupId(int id)
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "dCurre", "1234");
            
            String query = "select * from posts " + "where appartenenza_gruppo = ?";
            
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
    public boolean addPostIntoDatabase(Post post)
    {
        try{
            Connection conn = DriverManager.getConnection(connectionString,"dCurre","1234");
           
            String query = "INSERT INTO posts (id, author, content, img, ricevente, appartenenza_gruppo) "
                    + "values (default, ? , ? , ? , ?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            //inserisco nello statement i valori
            stmt.setInt(1, post.getUser());
            stmt.setString(2, post.getContent());
            stmt.setString(3, post.getImg());
            if(post.getRicevente() != null)
                stmt.setInt(4, post.getRicevente());
            else
                stmt.setString(4, null);
            if(post.getAppartenenza_gruppo() != null)
                stmt.setInt(5, post.getAppartenenza_gruppo());
            else
                stmt.setString(5, null);
            
            //update della table
            stmt.executeUpdate();
            
            //chiudo
            stmt.close();
            conn.close();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    } 
}
