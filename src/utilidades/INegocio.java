/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utilidades;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jorhak
 */
public interface INegocio {

    public void setDato(Map<String, String> request);
    
    public void setID(String id);

    public Map<String, String> Registrar();

    public boolean Eliminar(String id);

    public Map<String, String> Buscar(String columnName, Object columnValue);

    public List<Map<String, String>> Listar();

    public Map<String, String> ComboBox();
}
