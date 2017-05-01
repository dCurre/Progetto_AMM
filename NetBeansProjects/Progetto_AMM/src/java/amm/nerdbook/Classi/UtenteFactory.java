/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

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
    
    private ArrayList<Utente> userList = new ArrayList<>();
    
    private UtenteFactory()//costruttore
    {
        //creo degli utenti e li aggiungo in lista
        
        //utente1
        Utente user0 = new Utente(0,"Davide","Curreli","davidecurreli@mail.com","abcd","img/FotoProfilo1.jpg");
        userList.add(user0);
        
        //utente2
        Utente user1 = new Utente(1,"Gigi","Serreli","ggserreli@mail.com","abcd","img/FotoProfilo2.jpg");
        userList.add(user1);
        
        //utente3
        Utente user2 = new Utente(2,"Gesù","Cristo","camminosullacqua@mail.com","abcd","img/FotoProfilo3.jpg");
        userList.add(user2);
         
    }
    
    public Utente getUserById(int id)
    {
        for (Utente userTemp : this.userList) 
        {
            if (userTemp.getId() == id)
                return userTemp;
        }
        return null;
    }
    public int getIdByUserAndPassword(String user, String password)
    {
        for(Utente userTemp : this.userList)
        {
            if(userTemp.getNome().equals(user) && userTemp.getPassword().equals(password))
                return userTemp.getId();
        }
        return -1;
    }
}
