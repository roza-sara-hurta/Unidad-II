/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.edu.mx.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utng.edu.mx.dao.TransporteDAO;
import utng.edu.mx.dao.TransporteDAOImp;
import utng.edu.mx.model.Transporte;
/**
 *
 * @author sarai
 */
@WebServlet(name = "TransporteController", urlPatterns = {"/TransporteController"})
public class TransporteController extends HttpServlet {
    

    private static final String LISTAR_TRANSPORTES = "/listarTransportes.jsp";
    private static final String AGREAGAR_O_CAMBIAR = "/transporte.jsp";
    private TransporteDAO dao;

    public TransporteController() {
        dao = new TransporteDAOImp();

    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTAR_TRANSPORTES;
            int idBus = Integer.parseInt(request.getParameter("idBus"));
            dao.borrarTransporte(idBus);
            request.setAttribute("transportes",dao.desplegarTransporte());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREAGAR_O_CAMBIAR;
            int idBus = Integer.parseInt(request.getParameter("idBus"));
            Transporte transporte = dao.elegirTransporte(idBus);
            request.setAttribute("transporte", transporte);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREAGAR_O_CAMBIAR;

        } else {
            forward = LISTAR_TRANSPORTES;
            request.setAttribute("transportes", dao.desplegarTransporte());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

}


  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         Transporte transporte = new Transporte();
        String idBus = request.getParameter("idBus");
        transporte.setFabricante(request.getParameter("fabricante"));
        transporte.setDescripcion(request.getParameter("descripcion"));
        transporte.setModelo(request.getParameter("modelo"));
             transporte.setPlaca(Integer.parseInt(request.getParameter("placa")));


        if (idBus == null || idBus.isEmpty()) {
            dao.agregarTransporte(transporte);

        } else {
            transporte.setIdBus(Integer.parseInt(idBus));
            dao.cambiarTransporte(transporte);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTAR_TRANSPORTES);
        request.setAttribute("transportes", dao.desplegarTransporte());
        view.forward(request, response);
    }
       
   

  

}
