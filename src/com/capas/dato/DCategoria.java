/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capas.dato;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import utilidades.Conexion;
import utilidades.IDato;

/**
 *
 * @author jorhak
 */
public class DCategoria implements IDato{

    private int ID;
    private String Descripcion;

    public DCategoria() {
        this(0, "");
    }

    public DCategoria(int id, String descripcion) {
        this.ID = id;
        this.Descripcion = descripcion;
    }

    @Override
    public void setDato(Map<String, String> dato) {
        ID = Integer.parseInt(dato.getOrDefault("id", "0"));
        Descripcion = dato.getOrDefault("descripcion", "");
    }
    
    @Override
    public void setID(String id) {
        this.ID = Integer.parseInt(id);
    }

    @Override
    public Map<String, String> Registrar() {
        boolean proccessed = false;
        String sqlInsert = "insert into categoria (descripcion) "
                + "values (?);";

        String sqlUpdate = "update categoria "
                + "set descripcion=? "
                + "where id=?;";

        String sql = ID != 0 ? sqlUpdate : sqlInsert;

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, Descripcion);

            if (ID != 0) {
                statement.setInt(2, ID);
            }

            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }

        return proccessed ? Buscar("id", ID) : null;
    }

    @Override
    public boolean Eliminar(String id) {
        String sql = "delete from categoria where id=?;";
        return Conexion.getInstance().delete(sql, id);
    }

    @Override
    public Map<String, String> Buscar(String columnName, Object columnValue) {
        String sql = "select * from categoria where %s='%s' limit 1;";
        sql = String.format(sql, columnName, columnValue);

        List<Map<String, String>> resultado = Conexion.getInstance().executeSQLResultList(sql);
        return !resultado.isEmpty() ? resultado.get(0) : null;
    }

    @Override
    public List<Map<String, String>> Listar() {
        String sql = "select * from categoria order by 1;";
        return Conexion.getInstance().executeSQLResultList(sql);
    }

    @Override
    public Map<String, String> comboBox() {
        Map<String, String> materia = new LinkedHashMap<>();

        String sql = "select * from categoria order by 1;";
        List<Map<String, String>> rows = Conexion.getInstance().executeSQLResultList(sql);

        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);

            String fullname = row.get("codigo") + " " + row.get("codigo");
            materia.put(row.get("id"), row.get("descripcion"));
        }
        return materia;
    }
    
    public Map<String,String> Seleccionado(int idCategoria){
        Map<String, String> categoria = new LinkedHashMap<>();

        String sql = "select * from categoria where id='"+idCategoria+"' order by 1;";
        List<Map<String, String>> rows = Conexion.getInstance().executeSQLResultList(sql);

        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);

            categoria.put(row.get("id"), row.get("descripcion"));
        }
        return categoria;
    }

    
}
