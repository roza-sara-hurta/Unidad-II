/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.edu.mx.dao;

import java.util.List;
import utng.edu.mx.model.Transporte;

/**
 *
 * @author sarai
 */
public interface TransporteDAO {
    
    void agregarTransporte(Transporte transporte);
    void borrarTransporte(int idBus);
    void cambiarTransporte(Transporte transporte);
    List<Transporte>desplegarTransporte();
    Transporte elegirTransporte(int idBus);
    
}
