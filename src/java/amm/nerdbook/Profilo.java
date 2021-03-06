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
public class Profilo extends HttpServlet {

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
               
            Utente utenteLoggato = UtenteFactory.getInstance().getUserById(userID);            
            UtenteFactory listaUtenti = UtenteFactory.getInstance(); //lista di utenti
            GruppoFactory listaGruppi = GruppoFactory.getInstance(); //lista dei gruppi
            PostFactory listaPost = PostFactory.getInstance(); //lista dei gruppi
            
            if(utenteLoggato != null)
            {   
                if(request.getParameter("deleteUser") != null && request.getParameter("deleteUser").equals("delete"))
                {
                    if(listaUtenti.deleteUserFromDatabase(userID))
                        request.getRequestDispatcher("Login?logout=1&deleted=true").forward(request, response); //manda al logout con messaggio positivo
                    else
                        request.getRequestDispatcher("Login?logout=1&deleted=false").forward(request, response); //manda al logout con messaggio negativo
                }
                
                
                if(request.getParameter("confPass") != null && request.getParameter("pass").equals(request.getParameter("confPass")))
                {
                    listaUtenti.refreshUserDataById(userID, request.getParameter("name"), request.getParameter("surname"), request.getParameter("email"),
                            request.getParameter("pass"), request.getParameter("url"), request.getParameter("frase"));
                    
                    request.setAttribute("wrongPass", false);
                    request.setAttribute("nullData", false);
                }
                else
                {
                    if(request.getParameter("confPass") != null)
                        request.setAttribute("wrongPass", true);  
                }
                if(utenteLoggato.getNome() == null || utenteLoggato.getCognome() == null || utenteLoggato.getEmail() == null || utenteLoggato.getFrasePersonale() == null || utenteLoggato.getUrlFotoProfilo() == null)
                    request.setAttribute("nullData", true);
                
                request.setAttribute("utenteLoggato", utenteLoggato);
                request.setAttribute("userID", (Integer)session.getAttribute("logID"));
                request.setAttribute("listaUtenti", listaUtenti); //lista degli utenti
                request.setAttribute("amicizie", listaUtenti.getListaAmiciByUserId((Integer)session.getAttribute("logID")));
                 request.setAttribute("appartenenza", listaGruppi.getListaGruppiByUserId(userID));
                request.setAttribute("listaGruppi", listaGruppi);
                
                request.getRequestDispatcher("/M2/profilo.jsp").forward(request, response);
                
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
            
            
        }else{
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
