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
    
    private GruppoFactory()//costruttore
    {
        //creo degli utenti e li aggiungo in lista
        
        //utente1
        Gruppo group0 = new Gruppo(0,"Pillone");
        groupList.add(group0);
        
        //utente2
        Gruppo group1 = new Gruppo(1,"Pillinche");
        groupList.add(group1);
        
        //utente3
        Gruppo group2 = new Gruppo(2,"Pilledde");
        groupList.add(group2);
         
    }
    
    public String getNameGroupById(int id)
    {
        for (Gruppo groupTemp : this.groupList) 
        {
            if (groupTemp.getId() == id)
                return groupTemp.getNome();
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
}
