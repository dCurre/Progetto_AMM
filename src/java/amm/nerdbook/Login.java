/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

/**
 *
 * @author davide
 */
import amm.nerdbook.Classi.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(loadOnStartup = 0)
public class Login extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override
    public void init() {
        String dbConnection = "jdbc:derby://localhost:1527/ammdb";//"jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH; 
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        //IMPOSTO LA CONNECTION STRING PER OGNI FACTORY
        UtenteFactory.getInstance().setConnectionString(dbConnection);
        PostFactory.getInstance().setConnectionString(dbConnection);
        GruppoFactory.getInstance().setConnectionString(dbConnection);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        //Apero la sessione
        HttpSession session = request.getSession();
        
        //Se è impostato, distrugge la sessione
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            if(request.getParameter("deleted") != null && request.getParameter("deleted").equals("true"))
                request.setAttribute("deleteConfirm", true);
            else
            {
                if(request.getParameter("deleted") != null && request.getParameter("deleted").equals("true"))
                    request.setAttribute("deleteConfirm", false);
            }
            request.getRequestDispatcher("/M2/login.jsp").forward(request, response);
            return;
        }
        
        //Se esiste un attributo di sessione loggedIn e questo vale true
        //(Utente già loggato)
        if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true))
        {
            request.getRequestDispatcher("Bacheca").forward(request, response); //manda alla bacheca
            return; //interrompo la servlet login
        }
        else //Se l'utente non è loggato... 
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            if (username != null && password != null) 
            {
                int logID = UtenteFactory.getInstance().getIdByUserAndPassword(username, password);
                
                //se utente valido
                if(logID!=-1)
                {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("logID", logID);
                    
                    Utente userTemp = UtenteFactory.getInstance().getUserById(logID);
                    
                    if(userTemp.getNome() == null || userTemp.getCognome() == null || userTemp.getEmail() == null || userTemp.getFrasePersonale() == null || userTemp.getUrlFotoProfilo() == null)
                    {// se l'utente è incompleto
                        session.setAttribute("nullID", logID); //gli passo il log id
                        request.getRequestDispatcher("Profilo").forward(request, response); //manda al profilo
                    }
                    else
                        request.getRequestDispatcher("Bacheca?utenteBacheca="+logID).forward(request, response);//manda alla bacheca
                    
                    return;
                }
                else //altrimenti se la coppia user/pass non è valida (id==-1)
                {  
                    //ritorno al form del login informandolo che i dati non sono validi
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("/M2/login.jsp").forward(request, response);
                    return;
                }
            }
        }
        
        request.getRequestDispatcher("/M2/login.jsp").forward(request, response);
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