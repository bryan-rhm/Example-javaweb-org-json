/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.util.Scanner;
import models.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
@WebServlet(name = "controller", loadOnStartup = 1, urlPatterns = {"/setnombre", "/cartelera", "/comprar","/confirmacion"})
public class controller extends HttpServlet {

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
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        String url = "";

        if (path.equals("/cartelera") && session.getAttribute("cliente") != null) {

            // build a URL
            String s = "https://api.themoviedb.org/4/list/40757?api_key=";
            String key = "1955749dd63aad118485097594f67090";
            //String key = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxOTU1NzQ5ZGQ2M2FhZDExODQ4NTA5NzU5NGY2NzA5MCIsInN1YiI6IjVhMjgzYTdhYzNhMzY4MGI4ODEwN2Q0NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.v_PdsyS7Uu9_DNea_qs48WTMvRxTfMlstK5UpPE7jhQ";
            s += URLEncoder.encode(key, "UTF-8");
           try {
                URL api = new URL(s);
                Scanner sc = new Scanner(api.openStream());
                String str = new String();
                while (sc.hasNext()) {
                    str += sc.nextLine();
                }
                sc.close();
                // build a JSON object
                JSONObject obj = new JSONObject(str);
                obj.getJSONArray("results").toList();
                session.setAttribute("proximamente", obj.getJSONArray("results").toList());               
           }catch(Exception e){
               System.out.println("Error connecting to the API");
           }

            ArrayList<pelicula> peliculas = new ArrayList();
            pelicula Transformer = new pelicula("Transformers", "A");
            pelicula Cars = new pelicula("Cars", "A");
            pelicula Avengers = new pelicula("Avengers", "A");
            peliculas.add(Cars);
            peliculas.add(Transformer);
            peliculas.add(Avengers);
            int filas = 5;
            int columnas = 5;
            sala Sala1 = new sala(peliculas, filas, columnas, 30);
            transacciones transaccion = new transacciones((persona) session.getAttribute("cliente"), Sala1);
            session.setAttribute("Sala1", Sala1);
            session.setAttribute("transaccion", transaccion);
            session.setAttribute("peliculas", peliculas);
            session.setAttribute("filas", filas);
            session.setAttribute("columnas", columnas);
            url = "/WEB-INF/views" + path + ".jsp";

        } else if (path.equals("/comprar") && session.getAttribute("cliente") != null && session.getAttribute("transaccion") != null) {
  
           //transaccion.asignarPelicula(Sala1.getPeliculas().get());
            request.setAttribute("idPelicula",request.getQueryString());
            url = "/WEB-INF/views" + path + ".jsp";
        } else {
            url = "/";
        }
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (IOException | ServletException ex) {
            System.out.println(ex);
        }
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
        //processRequest(request, response);
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        if (path.equals("/setnombre")) {
            persona cliente = new persona(request.getParameter("nombre"));
            session.setAttribute("cliente", cliente);
            try {
                request.getRequestDispatcher("/").forward(request, response);
            } catch (IOException | ServletException ex) {
                System.out.println(ex);
            }
        }else if (path.equals("/confirmacion")){
            try {
                 String url = "/WEB-INF/views" + path + ".jsp";
                request.getRequestDispatcher( "/WEB-INF/views/confirmacion.jsp").forward(request, response);
            } catch (IOException | ServletException ex) {
                System.out.println(ex);
            }            
        }
            

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
