package com.examen.controller;

import com.examen.daoImpl.VentaDaoImpl;
import com.examen.entity.Venta;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VentaController extends HttpServlet {
	private final VentaDaoImpl vent = new VentaDaoImpl();
	private final Gson gson = new Gson();
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
	         PrintWriter out = response.getWriter();
	         int id = 0;
	        int op = Integer.parseInt(request.getParameter("opc"));
	        switch(op){
	            case 1:  out.println(gson.toJson(vent.readAll2()));
	                            break;
	            case 2:  out.println(gson.toJson(vent.create(new Venta(request.getParameter("fecha"),request.getParameter("tipodoc"), Integer.parseInt(request.getParameter("idsucur")), Integer.parseInt(request.getParameter("idcli"))))));
	                            break;
	            case 3:   Venta s = new Venta();
	                            s.setIdventa(Integer.parseInt(request.getParameter("idvent")));
	                            s.setFecha(request.getParameter("fecha"));
	                            s.setTipodoc(request.getParameter("tipodoc"));
	                            s.setIdsucursal(Integer.parseInt(request.getParameter("idsucur")));
	                            s.setIdcliente(Integer.parseInt(request.getParameter("idcli")));
	                            out.println(gson.toJson(vent.update(s )));
	                            break;
	            case 4: out.println(gson.toJson(vent.delete(Integer.parseInt(request.getParameter("idvent")))));
	                        break;
	            case 5: out.println(gson.toJson(vent.read(Integer.parseInt(request.getParameter("idvent")))));
	                        break;
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
