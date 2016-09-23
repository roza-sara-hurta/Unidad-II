/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.edu.mx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utng.edu.mx.model.Transporte;
import utng.edu.mx.util.UtilDB;

/**
 *
 * @author sarai
 */
public class TransporteDAOImp implements TransporteDAO{
    
        private Connection connection;

    public TransporteDAOImp() {
        connection = UtilDB.getConnection();
    }
    public void agregarTransporte(Transporte transporte) {

        try {
            String consulta = "INSERT INTO transportes(fabricante,descripcion,modelo,placa) values(?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(consulta);
            pstm.setString(1, transporte.getFabricante());
            pstm.setString(2, transporte.getDescripcion());
            pstm.setString(3, transporte.getModelo());  
            pstm.setInt(4, transporte.getPlaca());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
   
    public void borrarTransporte(int idBus) {
        try {
            String consulta = "DELETE FROM transportes where idbus = ?";
            PreparedStatement pstm = connection.prepareStatement(consulta);
            pstm.setInt(1, idBus);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public void cambiarTransporte(Transporte transporte) {
        try {
            String consulta = "UPDATE transportes SET fabricante = ?, descripcion = ?, modelo = ?, placa = ? "
                    + " WHERE idbus = ?";
            PreparedStatement pstm = connection.prepareStatement(consulta);
            pstm.setString(1, transporte.getFabricante());
            pstm.setString(2, transporte.getDescripcion());
            pstm.setString(3, transporte.getModelo());  
            pstm.setInt(4, transporte.getPlaca());
            pstm.setInt(5, transporte.getIdBus());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

     }
        @Override
      public List<Transporte> desplegarTransporte() {
        List<Transporte> transportes = new ArrayList<Transporte>();

        try {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM transportes ");
            while (rst.next()) {
                Transporte transporte = new Transporte(
                        rst.getInt("idbus"),
                        rst.getString("fabricante"),
                        rst.getString("descripcion"),
                        rst.getString("modelo"),
                        rst.getInt("placa")
                );
                transportes.add(transporte);
            }
            rst.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transportes;
    }
    
      public Transporte elegirTransporte(int idBus) {

        Transporte transporte = null;
        try {
            String consulta = "SELECT * FROM transportes WHERE idbus = ?";
            PreparedStatement pstm = connection.prepareStatement(consulta);
            pstm.setInt(1, idBus);
            ResultSet rst = pstm.executeQuery();

            while (rst.next()) {
                transporte = new Transporte(
                        rst.getInt("idbus"),
                        rst.getString("fabricante"),
                        rst.getString("descripcion"),
                        rst.getString("modelo"),
                         rst.getInt("placa"));
            }
            
        } catch (SQLException e) {
        }
        return transporte;
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
}
