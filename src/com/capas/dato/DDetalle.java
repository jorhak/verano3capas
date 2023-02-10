/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capas.dato;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import utilidades.Conexion;

/**
 *
 * @author jorhak
 */
public class DDetalle {

    private int ID;
    private int NroFactura;
    private int Cantidad;
    private Double Precio;
    private int CodigoProducto;

    public DDetalle() {
        this(0, 0, 0.0, 0, 0);
    }

    public DDetalle(int id, int cantidad, Double precio, int nroFactura, int codigoProducto) {
        this.ID = id;
        this.NroFactura = nroFactura;
        this.Cantidad = cantidad;
        this.Precio = precio;
        this.CodigoProducto = codigoProducto;
    }

    public void setDato(Map<String, String> dato) {
        ID = Integer.parseInt(dato.getOrDefault("id", "0"));
        NroFactura = Integer.parseInt(dato.getOrDefault("nroFactura", "0"));
        Cantidad = Integer.parseInt(dato.getOrDefault("cantidad", ""));
        Precio = Double.parseDouble(dato.getOrDefault("precio", ""));
        CodigoProducto = Integer.parseInt(dato.getOrDefault("codigoProducto", ""));
    }

    public void setNroFactura(String nroFactura) {
        this.NroFactura = Integer.parseInt(nroFactura);
    }

    public Map<String, String> Registrar() {
        boolean proccessed = false;
        String sqlInsert = "insert into detalle (nro, cantidad, precio, codigoProducto) "
                + "values (?,?,?,?);";

        String sqlUpdate = "update detalle "
                + "set cantidad=?, precio=? "
                + "where id=?;";

        String sql = ID != 0 ? sqlUpdate : sqlInsert;

        try {
            PreparedStatement statement = Conexion.getInstance().getConnection().prepareStatement(sql);
            statement.setInt(1, NroFactura);
            statement.setInt(2, Cantidad);
            statement.setDouble(3, Precio);
            statement.setInt(4, CodigoProducto);

            if (ID != 0) {
                statement.setInt(1, Cantidad);
                statement.setDouble(2, Precio);
                statement.setDouble(3, ID);
                
            }

            proccessed = Conexion.getInstance().executeSQL(statement);
        } catch (SQLException e) {
        }

        return proccessed ? Buscar("nro", NroFactura, "id", ID) : null;
    }

    public static boolean Eliminar(String nroFactura, String id) {
        String sql = "delete from detalle where nro=? and id=?;";
        return Conexion.getInstance().delete(sql, nroFactura, id);
    }

    public static Map<String, String> Buscar(String columnName0, Object value0, String columnName1, Object value1) {
        String sql = "select * from detalle where %s='%s' and %s='%s' limit 1;";
        sql = String.format(sql, columnName0, value0, columnName1, value1);

        List<Map<String, String>> resultado = Conexion.getInstance().executeSQLResultList(sql);
        return !resultado.isEmpty() ? resultado.get(0) : null;
    }

    public static List<Map<String, String>> Listar(String nro) {
        String sql = "select * from detalle where nro='%s';";
        sql = String.format(sql, nro);
        return Conexion.getInstance().executeSQLResultList(sql);
    }
}
