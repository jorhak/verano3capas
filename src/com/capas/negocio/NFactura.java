/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capas.negocio;

import com.capas.dato.DFactura;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jorhak
 */
public class NFactura {

    private DFactura dato;

    public NFactura() {
        this.dato = new DFactura();
    }

    public void setDato(Map<String, String> datos) {
        dato.setDato(datos);
    }

    public void setDatoItems(List<Map<String, String>> items) {
        dato.setDatoItems(items);
    }

    public Map<String, String> Registrar() {
        return dato.Registrar();
    }
    
    public Map<String,String> Modificar(){
        return dato.Modificar();
    }

    public List<Map<String, String>> RegistrarItems(String nroFactura) {
        return dato.RegistrarItems(nroFactura);
    }

    public void setDatoItem(Map<String, String> item) {
        dato.setDatoItem(item);
    }

    public Map<String, String> RegistrarItem() {
        return dato.RegistrarItem();
    }

    public boolean EliminarItems(String nroFactura) {
        return dato.EliminarItems(nroFactura);
    }

    public boolean Eliminar(String nroFactura) {
        return dato.Eliminar(nroFactura);
    }

    public boolean EliminarItem(String nroFactura, String id) {
        return dato.EliminarItem(nroFactura, id);
    }

    public Object Buscar(String columnName, Object columnValue) {
        return dato.Buscar(columnName, columnValue);
    }

    public List<Map<String, String>> BuscarItems(String nroFactura) {
        return dato.BuscarItems(nroFactura);
    }

    public Map<String, String> BuscarItem(String nroFactura, String id) {
        return dato.BuscarItem(nroFactura, id);
    }

    public List<Map<String, String>> Listar() {
        return dato.Listar();
    }

    public Map<String, String> comboBox() {
        return dato.comboBox();
    }
}
