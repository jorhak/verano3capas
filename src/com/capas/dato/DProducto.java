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
public class DProducto implements IDato{
    private int Codigo;
    private String Nombre;
    private String Precio;
    private int IdCategoria;

    public DProducto() {
        this(0, "", "", 0);
    }

    public DProducto(int codigo, String nombre, String precio, int idCategoria) {
        this.Codigo = codigo;
        this.Nombre = nombre;
        this.Precio = precio;
        this.IdCategoria = idCategoria;
    }

    @Override
    public void setDato(Map<String, String> request) {
        Codigo = Integer.parseInt(request.getOrDefault("codigo", "0"));
        Nombre = request.getOrDefault("nombre", "");
        Precio = request.getOrDefault("precio", "");
        IdCategoria = Integer.parseInt(request.getOrDefault("idCategoria", "0"));
    }
    
    @Override
    public void setID(String codigo) {
        this.Codigo = Integer.parseInt(codigo);
    }

    @Override
    public Map<String, String> Registrar() {
        boolean proccessed = false;
        String sqlInsert = "insert into producto (nombre, precio, idCategoria) "
                + "values (?,?,?);";

        String sqlUpdate = "update producto "
                + "set nombre=?, precio=? "
                + "where codigo=?;";

        String sql = Codigo != 0 ? sqlUpdate : sqlInsert;

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, Nombre);
            statement.setString(2, Precio);
            statement.setInt(3, IdCategoria);

            if (Codigo != 0) {
                statement.setInt(3, Codigo);
            }

            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }

        return proccessed ? Buscar("codigo", Codigo) : null;
    }

    @Override
    public boolean Eliminar(String codigo) {
        String sql = "delete from producto where codigo=?;";
        return Conexion.getInstance().delete(sql, codigo);
    }

    @Override
    public Map<String, String> Buscar(String columnName, Object columnValue) {
        String sql = "select * from producto where %s='%s' limit 1;";
        sql = String.format(sql, columnName, columnValue);

        List<Map<String, String>> resultado = Conexion.getInstance().executeSQLResultList(sql);
        return !resultado.isEmpty() ? resultado.get(0) : null;
    }

    @Override
    public List<Map<String, String>> Listar() {
        String sql = "select * from producto order by 1;";
        return Conexion.getInstance().executeSQLResultList(sql);
    }

    @Override
    public Map<String, String> comboBox() {
        Map<String, String> materia = new LinkedHashMap<>();

        String sql = "select * from producto order by 1;";
        List<Map<String, String>> rows = Conexion.getInstance().executeSQLResultList(sql);

        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);

            String fullname = row.get("codigo") + " " + row.get("codigo");
            materia.put(row.get("codigo"), row.get("nombre"));
        }
        return materia;
    }

    
}
