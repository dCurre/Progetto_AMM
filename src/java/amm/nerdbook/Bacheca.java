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
 * @author Tutor_IUM
 */
public class Bacheca extends HttpServlet
{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        
        if(session!=null && session.getAttribute("loggedIn")!=null && session.getAttribute("loggedIn").equals(true))
        {
            String user = request.getParameter("user");
            int userID; //id dell'utente loggato
            
            if(user != null)
            {
                userID = Integer.parseInt(user);
            } else {
                Integer loggedUserID = (Integer)session.getAttribute("logID");
                userID = loggedUserID;
            }
            
            Utente utenteLoggato = UtenteFactory.getInstance().getUserById(userID); //restituisce l'utente loggato
            GruppoFactory listaGruppi = GruppoFactory.getInstance();
            UtenteFactory listaUtenti = UtenteFactory.getInstance();
            PostFactory listaPost = PostFactory.getInstance(); 
            int bachecaPost;
            boolean listaPostChecker;
            
            if(request.getParameter("utenteBacheca") == null && request.getParameter("gruppoBacheca") != null)
            {
                listaPostChecker = true;
                bachecaPost = Integer.parseInt(request.getParameter("gruppoBacheca"));
            }else
            {
                listaPostChecker = false;    
                bachecaPost = Integer.parseInt(request.getParameter("utenteBacheca"));
            }
            
            if(utenteLoggato != null)
            {                
                request.setAttribute("utenteBacheca", bachecaPost);// id dell'utente cliccato nella sidebar
                request.setAttribute("userID", (Integer)session.getAttribute("logID")); // id dell'utente loggato
                request.setAttribute("utenteLoggato", utenteLoggato);
                request.setAttribute("listaGruppi", listaGruppi);
                request.setAttribute("listaUtenti", listaUtenti);
                request.setAttribute("groupOrUser", listaPostChecker);//true se è un post per gruppi, false se post per utenti
                request.setAttribute("appartenenza", listaGruppi.getListaGruppiByUserId(userID));
                request.setAttribute("amicizie", listaUtenti.getListaAmiciByUserId((Integer)session.getAttribute("logID")));
                
                if(listaPostChecker)
                    request.setAttribute("listaPost", listaPost.getPostListByGroupId(bachecaPost));
                else
                    request.setAttribute("listaPost", listaPost.getPostListByUserId(bachecaPost));
            
               
                request.getRequestDispatcher("/M2/bacheca.jsp").forward(request, response);
                
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
                out.println("<title>Servlet Bacheca</title>");            
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