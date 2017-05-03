/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

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

    private ArrayList<Post> postList = new ArrayList<Post>();

    public PostFactory()
    {    
        UtenteFactory userFactory = UtenteFactory.getInstance();

        //Creazione Post
        Post post0 = new Post(0,userFactory.getUserById(0),null,"Frase a caso1",Post.Type.TEXT);
        postList.add(post0);
        
        Post post1 = new Post(1,userFactory.getUserById(1),"Viaggiatori","Frase a caso2",Post.Type.IMAGE);
        postList.add(post1);
        
        Post post2 = new Post(2,userFactory.getUserById(2),null,"Sempre sia lodato",Post.Type.TEXT);
        postList.add(post2);
        
        Post post3 = new Post(0,userFactory.getUserById(0),null,"Frase a caaaaaaso1",Post.Type.TEXT);
        postList.add(post0);
        
        Post post4 = new Post(1,userFactory.getUserById(1),"Viaggiatori","Frase a cassssso2",Post.Type.IMAGE);
        postList.add(post1);
        
        Post post5 = new Post(2,userFactory.getUserById(2),null,"Sempre sia lodatoooo",Post.Type.TEXT);
        postList.add(post2);
    }

    public Post getPostById(int id)
    {
        for (Post post : this.postList)
            if (post.getId() == id)
                return post;
        
        return null;
    }

    public List getPostListByUser(Utente user)
    {
        List<Post> postListTemp = new ArrayList<Post>();

        for(Post post : this.postList )
        {
            if (post.getOwner().equals(user))
                postListTemp.add(post);
        }
        return postListTemp;
    }
    public List getPostListByGroupName(Gruppo group)
    {

        List<Post> postListTemp = new ArrayList<Post>();

        for(Post post : this.postList )
        {
            if (post.getGruppoDiRiferimento().equalsIgnoreCase(group.getNome()))
                postListTemp.add(post);
        }
        return postListTemp;
    }
}
