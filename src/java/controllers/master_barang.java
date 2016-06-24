/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Attributes;
import models.BarangModel;

/**
 *
 * @author amar
 */
@WebServlet(name = "master_barang", urlPatterns = {"/master_barang"})
public class master_barang extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String FORM = "/views/barang/form.jsp";
    private static String LIST = "/views/barang/index.jsp";
    private BarangModel dao;
 
    public master_barang() {
        super();
        dao = new BarangModel();
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet master_barang</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet master_barang at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }*/

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        
        String actionName="";
        String forward="";
        String action;
        if(request.getParameterMap().containsKey("action")!=false){
            action = request.getParameter("action").toString();
        }else{
            action = "index";
        }
        
        if (action.equalsIgnoreCase("add")){
            forward = FORM;
            actionName = "Tambah";
        }else if (action.equalsIgnoreCase("edit")){
            forward = FORM;
            actionName = "Edit";
            String id = request.getParameter("id");
            request.setAttribute("model", dao.findOne(id));
        }else if (action.equalsIgnoreCase("delete")){
            forward = LIST;
            String id = request.getParameter("id");
            dao.delete(id);
        }else{
            forward = LIST;
            request.setAttribute("models", dao.findAll());
        }
        
        String title = "Barang";
        String content = "/views/barang/index.jsp";
        request.setAttribute("title", title);
        request.setAttribute("actionName", actionName);
        request.setAttribute("content", forward);
        request.getRequestDispatcher("/views/layouts/main.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        
        
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
