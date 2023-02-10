/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capas.dato;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import utilidades.Conexion;

/**
 *
 * @author jorhak
 */
public class DFactura {

    private int Nro;
    private String Nit;
    private String Nombre;
    private String Fecha;
    private Double MontoTotal;
    private List<DDetalle> detalle;

    public DFactura() {
        this(0, "", "", "", 0.0);
    }

    public DFactura(int nro, String nit, String nombre, String fecha, Double montoTotal) {
        this.Nro = nro;
        this.Nit = nit;
        this.Nombre = nombre;
        this.Fecha = fecha;
        this.MontoTotal = montoTotal;
        this.detalle = new LinkedList<>();
    }

    public void setDato(Map<String, String> dato) {
        Nro = Integer.parseInt(dato.getOrDefault("nro", "0"));
        Nit = dato.getOrDefault("nit", "");
        Nombre = dato.getOrDefault("nombre", "");
        Fecha = dato.getOrDefault("fecha", "");
        MontoTotal = Double.parseDouble(dato.getOrDefault("montoTotal", ""));
    }

    public void setDatoItem(Map<String, String> dato) {
        detalle.clear();
        DDetalle de = new DDetalle();
        de.setDato(dato);
        detalle.add(de);
    }

    public void setDatoItems(List<Map<String, String>> datos) {
        detalle.clear();

        for (int i = 0; i < datos.size(); i++) {
            DDetalle de = new DDetalle();
            de.setDato(datos.get(i));
            detalle.add(de);
        }
    }

    public Map<String, String> Registrar() {
        boolean proccessed = false;
        String sqlInsert = "insert into factura (nit, nombre, fecha, montoTotal) "
                + "values (?,?,?,?);";

        String sqlUpdate = "update factura "
                + "set nit=?, nombre=? "
                + "where nro=?;";

        String sql = Nro != 0 ? sqlUpdate : sqlInsert;

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, Nit);
            statement.setString(2, Nombre);
            statement.setString(3, Fecha);
            statement.setDouble(4, MontoTotal);

            if (Nro != 0) {
                statement.setString(1, Nit);
                statement.setString(2, Nombre);
                statement.setInt(3, Nro);
            }

            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }
        int nroFactura = Integer.parseInt(getIDFactura());
        return proccessed ? Buscar("nro", nroFactura) : null;
    }
    
    public Map<String, String> Modificar() {
        boolean proccessed = false;

        String sql = "update factura "
                + "set nit=?, nombre=? "
                + "where nro=? ;";

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, Nit);
            statement.setString(2, Nombre);
            statement.setInt(3, Nro);


            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }

        return proccessed ? Buscar("nro", Nro) : null;
    }

    public Map<String, String> RegistrarItem() {
        if (detalle.size() == 1) {
            DDetalle de = detalle.get(0);
            return de.Registrar();
        }

        return null;
    }

    public List<Map<String, String>> RegistrarItems(String nroFactura) {
        List<Map<String, String>> items = new LinkedList<>();

        for (int i = 0; i < detalle.size(); i++) {
            DDetalle de = detalle.get(i);
            de.setNroFactura(nroFactura);
            Map<String, String> dato = de.Registrar();
            items.add(dato);
        }

        return items;
    }

    public boolean Eliminar(String nroFactura) {
        String sql = "delete from factura where nro=?;";
        return Conexion.getInstance().delete(sql, nroFactura);
    }

    public boolean EliminarItem(String nroFactura, String id) {
        return DDetalle.Eliminar(nroFactura, id);
    }

    public boolean EliminarItems(String nroFactura) {
        List<Map<String, String>> datos = DDetalle.Listar(nroFactura);

        for (int i = 0; i < datos.size(); i++) {
            String claseId = datos.get(i).get("id");
            if (!DDetalle.Eliminar(nroFactura, claseId)) {
                return false;
            }
        }
        return !datos.isEmpty() ? true : false;
    }

    public Map<String, String> Buscar(String columnName, Object columnValue) {
        String sql = "select * from factura where %s='%s' limit 1;";
        sql = String.format(sql, columnName, columnValue);

        List<Map<String, String>> resultado = Conexion.getInstance().executeSQLResultList(sql);
        return !resultado.isEmpty() ? resultado.get(0) : null;
    }

    public Map<String, String> BuscarItem(String nroFactura, String id) {
        return DDetalle.Buscar("id", id, "nro", nroFactura);
    }

    public List<Map<String, String>> BuscarItems(String nroFactura) {
        return DDetalle.Listar(nroFactura);
    }

    public List<Map<String, String>> Listar() {
        String sql = "select * from factura order by 1;";
        return Conexion.getInstance().executeSQLResultList(sql);
    }

    public Map<String, String> comboBox() {
        Map<String, String> materia = new LinkedHashMap<>();

        String sql = "select * from factura order by 1;";
        List<Map<String, String>> rows = Conexion.getInstance().executeSQLResultList(sql);

        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);

            String fullname = row.get("nit") + " " + row.get("nombre");
            materia.put(row.get("id"), fullname);
        }
        return materia;
    }

    public String getIDFactura() {
        String sql = "select * from factura order by nro desc limit 1;";
        List<Map<String, String>> rows = Conexion.getInstance().executeSQLResultList(sql);
        Map<String, String> row = rows.get(0);
        String id = row.get("nro");

        return id;
    }
}
