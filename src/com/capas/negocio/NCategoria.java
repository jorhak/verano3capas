/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capas.negocio;

import com.capas.dato.DCategoria;
import java.util.List;
import java.util.Map;
import utilidades.INegocio;

/**
 *
 * @author jorhak
 */
public class NCategoria implements INegocio {

    private final DCategoria dato;

    public NCategoria() {
        this.dato = new DCategoria();
    }

    @Override
    public void setDato(Map<String, String> request) {
        dato.setDato(request);
    }
    
    @Override
    public void setID(String id) {
        dato.setID(id);
    }

    @Override
    public Map<String, String> Registrar() {
        return dato.Registrar();
    }

    @Override
    public boolean Eliminar(String id) {
        return dato.Eliminar(id);
    }

    @Override
    public Map<String, String> Buscar(String columnName, Object columnValue) {
        return dato.Buscar(columnName, columnValue);
    }

    @Override
    public List<Map<String, String>> Listar() {
        return dato.Listar();
    }

    @Override
    public Map<String, String> ComboBox() {
        return dato.comboBox();
    }
    
    public Map<String, String> Seleccionado(int idCategoria){
        return dato.Seleccionado(idCategoria);
    }
}
