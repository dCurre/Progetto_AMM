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
public class GruppoFactory
{
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance()
    {
        if (singleton == null)
            singleton = new GruppoFactory();
        
        return singleton;
    }
    
    private ArrayList<Gruppo> groupList = new ArrayList<>();
    
    public GruppoFactory()//costruttore
    {
        //creo degli utenti e li aggiungo in lista
        
        //utente1
        Gruppo group0 = new Gruppo(0,"Gruppo A","img/fotoProfilo1.jpg");
        groupList.add(group0);
        
        //utente2
        Gruppo group1 = new Gruppo(1,"Gruppo B","img/fotoProfilo1.jpg");
        groupList.add(group1);
        
        //utente3
        Gruppo group2 = new Gruppo(2,"Gruppo C","img/fotoProfilo1.jpg");
        groupList.add(group2);
         
    }
    
    public Gruppo getGroupById(int id)
    {
        for (Gruppo groupTemp : this.groupList) 
        {
            if (groupTemp.getId() == id)
                return groupTemp;
        }
        return null;
    }
    public int getIdByName(String name)
    {
        for(Gruppo groupTemp : this.groupList)
        {
            if(groupTemp.getNome().equals(name))
                return groupTemp.getId();
        }
        return -1;
    }
    public ArrayList<String> getNomeGruppo() //restituisce un array con tutti i nomi
    {
        ArrayList<String> arrayTempNomi = new ArrayList<>();
        for(Gruppo temp : this.groupList)
            arrayTempNomi.add(temp.getNome());
        
        return arrayTempNomi;
    }
    public ArrayList<String> getFotoGruppo() //restituisce un array con tutti i nomi
    {
        ArrayList<String> arrayFoto = new ArrayList<>();
        for(Gruppo temp : this.groupList)
            arrayFoto.add(temp.getUrlFotoGruppo());
        
        return arrayFoto;
    }
    public int getArrayListSize()
    {
        int count = 0;
        
        for(Gruppo groupTemp : this.groupList)
            count++;
        
        return count;
    }
}
