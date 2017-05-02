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
    
    public UtenteFactory()//costruttore
    {
        //creo degli utenti e li aggiungo in lista
        
        //utente1
        Utente user0 = new Utente(0,"Davide","Curreli","davidecurreli@mail.com","123","img/fotoProfilo1.jpg","We picciò");
        userList.add(user0);
        
        //utente2
        Utente user1 = new Utente(1,"Gigi","Serreli","ggserreli@mail.com","abcd","img/fotoProfilo2.jpg","Ciaoo");
        userList.add(user1);
        
        //utente3
        Utente user2 = new Utente(2,"Gesù","Cristo","camminosullacqua@mail.com","abcd","img/fotoProfilo3.jpg","Che Papa' sia con te!");
        userList.add(user2);
        
        //utente3
        Utente user3 = new Utente(3,"Andrea","Mutolo","andreamutolo@mail.com","abcd","img/fotoLandscapePost.jpg","We");
        userList.add(user3);
    }
    
    public ArrayList<String> getNominativo() //restituisce un array con tutti i nomi
    {
        ArrayList<String> arrayTempNomi = new ArrayList<>();
        for(Utente temp : this.userList)
            arrayTempNomi.add(temp.getNome() + " " + temp.getCognome());
        
        return arrayTempNomi;
    }
    
    public ArrayList<String> getFotoProfilo() //restituisce un array con tutti i nomi
    {
        ArrayList<String> arrayFoto = new ArrayList<>();
        for(Utente temp : this.userList)
            arrayFoto.add(temp.getUrlFotoProfilo());
        
        return arrayFoto;
    }
    
    public int getArrayListSize()
    {
        int count = 0;
        
        for(Utente userTemp : this.userList)
            count++;
        
        return count;
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
