/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author davide
 */
public class UtenteFactory {

    private static UtenteFactory singleton;
    public static UtenteFactory getInstance()
    {
        if (singleton == null)
            singleton = new UtenteFactory();
        
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

    private UtenteFactory(){
    }
    
    public Utente getUserById(int id)
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "dCurre", "1234");
            
            String query = "select * from utenti " + "where id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if(res.next())
            {
                Utente current = new Utente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setEmail(res.getString("email"));
                current.setPassword(res.getString("password"));
                current.setUrlFotoProfilo(res.getString("urlfotoprofilo"));
                current.setFrasePersonale(res.getString("frasepersonale"));
                
                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getIdByUserAndPassword(String user, String password)
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "dCurre", "1234");
            
            String query = "select id from utenti " + "where nome = ? and password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next())
            {
                int id = res.getInt("id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return -1;
    }
    public ArrayList<Integer> getListaAmiciByUserId(int id)
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "dCurre", "1234");
            
            String query = "select followed from amicizie " + "where follower = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            ArrayList<Integer> arrayList = new ArrayList<>();
            
            // ciclo sulle righe restituite
            while(res.next())
            {
                Integer current = res.getInt("followed");
                arrayList.add(current);
            }
            
            stmt.close();
            conn.close();
            return arrayList;
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }
    public boolean deleteUserFromDatabase(int id)
    {
        PostFactory postList = PostFactory.getInstance();
        if(postList.deleteUserPostsFromDatabase(id) && this.deleteAmicizieFromDatabase(id))
        {
            try
            {
                Connection conn = DriverManager.getConnection(connectionString,"dCurre","1234");

                String query = "delete from utenti " + "where id = ?";

                // Prepared Statement
                PreparedStatement stmt = conn.prepareStatement(query);

                // Si associano i valori
                stmt.setInt(1, id);

                //update della table
                stmt.executeUpdate();

                //chiudo
                stmt.close();
                conn.close();
              return true;
            } catch (SQLException e) {
                e.printStackTrace();
          }
        }
        return false;
    } 
    public boolean deleteAmicizieFromDatabase(int id)
    {
        if(this.deleteFollowedFromDatabase(id) && this.deleteFollowerFromDatabase(id))
            return true;
        else
            return false;
    } 
    public boolean deleteFollowerFromDatabase(int id)
    {
        try{
          Connection conn = DriverManager.getConnection(connectionString,"dCurre","1234");

          String query = "delete from amicizie " + "where follower= ?";

          // Prepared Statement
          PreparedStatement stmt = conn.prepareStatement(query);

          // Si associano i valori
          stmt.setInt(1, id);

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
    public boolean deleteFollowedFromDatabase(int id)
    {
        try{
          Connection conn = DriverManager.getConnection(connectionString,"dCurre","1234");

          String query = "delete from amicizie " + "where followed = ?";

          // Prepared Statement
          PreparedStatement stmt = conn.prepareStatement(query);

          // Si associano i valori
          stmt.setInt(1, id);

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
