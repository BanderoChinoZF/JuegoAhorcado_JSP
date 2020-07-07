/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luisa
 */
@WebServlet(name = "Ahorcado", urlPatterns = {"/Ahorcado"})
public class Ahorcado extends HttpServlet {
    
    //DECLARAMOS LAS VARIABLES
    private final static String[] PALABRAS={"AHORITA","ACERTIJO","OAXACA","HAMACA"};
    private static int inten=5;
    

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
       
        //LOGICA
        HttpSession sesion = request.getSession(true);
        
        int maxint = Integer.parseInt((String)sesion.getAttribute("maxint"));
        String palabra = (String)sesion.getAttribute("palabra");
        String aciertos;
        String errados;
        
        if(palabra == null)
        {
            Random oran = new Random();
            palabra = PALABRAS[oran.nextInt(PALABRAS.length)];
            
            aciertos="";
            errados="";
            
            sesion.setAttribute("palabra", palabra);
            sesion.setAttribute("aciertos", aciertos);
            sesion.setAttribute("errados", errados);
            
        }else
        {
            aciertos = (String) sesion.getAttribute("aciertos");
            errados = (String) sesion.getAttribute("errados");
            String letra = request.getParameter("letra");
            
            if(palabra.indexOf(letra)>=0)
            {
                aciertos+=letra;
            }else
            {
                errados+=letra;
            }
            
            sesion.setAttribute("aciertos",aciertos);
            sesion.setAttribute("errados",errados);
        }
        
        //VISTA
        PrintWriter out = response.getWriter();
        try
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Ahorcado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            
            out.println("<h2>JUEGO</h2>");
            out.println("<h3>Selecciona Una Letra: </h3>");
            
            boolean terminado = true;
            out.println("<h2>");
            for(int i=0; i<palabra.length(); i++)
            {
                String letra = palabra.substring(i,i+1);
                if(aciertos.indexOf(letra)>=0)
                {
                    out.println(""+letra);
                }else
                {
                    out.println(""+"_");
                    terminado = false;
                } 
            }
            out.println("</h2>");
            
            if(maxint > errados.length())
            {
                out.println("<br><br><br>");
                for(char car='A'; car<='Z'; car++)
                {
                    if(aciertos.indexOf(car)==-1 && errados.indexOf(car)==-1)
                    {
                        out.println("<a class='btn btn-success' href=Ahorcado?letra=" + car +">"+car+"</a>");
                    }
                }
                
                out.println("<br> <h2>Oportunidades De Errar: "+(maxint-errados.length())+"</h2>");
            }else
            {
                sesion.invalidate();
                out.println("<br> <h1>JUEGO TERMINADO</h1>");
                out.println("<br> <a class='btn btn-danger' href='index.jsp'>REGRESAR</a>");
            }
            
            if(terminado)
            {
                sesion.invalidate();
                out.println("<br> <h1>JUEGO COMPLETO</h1>");
                out.println("<br> <a class='btn btn-danger' href='index.jsp'>REGRESAR</a>");
            }
            
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            
        }finally
        {
            out.close();
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
