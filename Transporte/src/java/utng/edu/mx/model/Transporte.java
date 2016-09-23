/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.edu.mx.model;

/**
 *
 * @author sarai
 */
public class Transporte {
    private int idBus;
    private String fabricante;
    private String descripcion;
    private String modelo;
    private int placa;
    
    public Transporte (){
        this(0,"","","",0);
    }

    public Transporte(int idBus, String fabricante, String descripcion, String modelo, int placa) {
        this.idBus = idBus;
        this.fabricante = fabricante;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.placa = placa;
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Transporte{" + "idBus=" + idBus + ", fabricante=" + fabricante + ", descripcion=" + descripcion + ", modelo=" + modelo + ", placa=" + placa + '}';
    }

   
    
    
    
}
