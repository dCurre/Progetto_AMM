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
public class GruppoFactory
{
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance()
    {
        if (singleton == null)
            singleton = new GruppoFactory();
        
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
    
    public GruppoFactory(){
    }
    
    public ArrayList<Integer> getListaGruppiByUserId(int id)
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "dCurre", "1234");
            
            String query = "select followed from gruppi_appartenenza " + "where follower = ?";
            
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
    public Gruppo getGruppoById(int id)
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "dCurre", "1234");
            
            String query = "select * from gruppi " + "where id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if(res.next())
            {
                Gruppo current = new Gruppo();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setUrlFotoGruppo(res.getString("urlfotogruppo"));
                
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
}
