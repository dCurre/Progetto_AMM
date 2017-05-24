/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author davide
 */
public class RiepilogoPost extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        
        if(session!=null && session.getAttribute("loggedIn")!=null && session.getAttribute("loggedIn").equals(true))
        {
            String user = request.getParameter("user");
            int userID;
            
            if(user != null)
            {
                userID = Integer.parseInt(user);
            } else {
                Integer loggedUserID = (Integer)session.getAttribute("logID");
                userID = loggedUserID;
            }
            Utente utente = UtenteFactory.getInstance().getUserById(userID); //singolo user
            UtenteFactory listaUtenti = UtenteFactory.getInstance(); //lista di utenti
            GruppoFactory listaGruppi = GruppoFactory.getInstance(); //lista dei gruppi
            PostFactory listaPost = PostFactory.getInstance();
            int bachecaPost = Integer.parseInt(request.getParameter("idBacheca"));
            boolean listaPostChecker ;
            if(request.getParameter("groupOrUser").equals("true"))
                listaPostChecker = true;
            else
                listaPostChecker = false;
            
            if(utente != null)
            {
                if(request.getParameter("addPost")!= null && request.getParameter("addPost").equals("1"))
                {
                    Post newPost = new Post();
                    newPost.setUser(userID);
                    newPost.setContent(request.getParameter("text"));
                    if(request.getParameter("img").equals(""))
                        newPost.setImg(null);
                    else
                        newPost.setImg(request.getParameter("img"));
                    
                    if(listaPostChecker)//se true è un post per gruppo altrimenti per utente
                    {
                        newPost.setRicevente(null);
                        newPost.setAppartenenza_gruppo(bachecaPost);
                    }
                    else{
                        newPost.setRicevente(bachecaPost);
                        newPost.setAppartenenza_gruppo(null);
                    }
                    if(listaPost.addPostIntoDatabase(newPost))
                        request.setAttribute("ok", 1);
                    else
                        request.setAttribute("ok", 0);
                }
                
                request.setAttribute("testo", request.getParameter("textPost")); //contenuto testo
                request.setAttribute("immagine", request.getParameter("imgPost")); //contenuto immagine
                request.setAttribute("utenteBacheca", bachecaPost);// id dell'utente cliccato nella sidebar
                
                request.setAttribute("listaUtenti", listaUtenti); //lista degli utenti
                request.setAttribute("listaGruppi", listaGruppi); //lista gruppi
                request.setAttribute("userID", (Integer)session.getAttribute("logID")); // id dell'utente loggato
                request.setAttribute("amicizie", listaUtenti.getListaAmiciByUserId((Integer)session.getAttribute("logID")));
                request.setAttribute("appartenenza", listaGruppi.getListaGruppiByUserId(userID));
                request.setAttribute("groupOrUser", listaPostChecker);//true se è un post per gruppi, false se post per utenti

                request.getRequestDispatcher("/M2/riepilogoPost.jsp").forward(request, response);
                
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        else{
            try (PrintWriter out = response.getWriter())
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Profilo</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Non hai effettuato l'accesso!! <a href='Login'>Login</a> </h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }    
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
