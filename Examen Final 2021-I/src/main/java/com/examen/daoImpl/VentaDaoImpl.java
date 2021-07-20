package com.examen.daoImpl;

import com.examen.config.Conexion;
import com.examen.dao.Metodos;
import com.examen.entity.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VentaDaoImpl implements Metodos<Venta>{

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx ;
	    @Override
	    public int create(Venta t) {
	        int x = 0;
	        String SQL = "INSERT INTO venta (fecha, tipodoc, idsucursal, idcliente) VALUES(?, ?, ?, ?)";
	        try {
	            cx = Conexion.getConexion();
	            ps = cx.prepareStatement(SQL);
	            ps.setString(1, t.getFecha());
	            ps.setString(2, t.getTipodoc());
	            ps.setInt(3, t.getIdsucursal());
	            ps.setInt(4, t.getIdcliente());
	            x = ps.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Error: "+e);
	        }
	      return x;
	        
	    }

	    @Override
	    public int update(Venta t) {
	        int x = 0;
	        String SQL = "UPDATE venta SET fecha = ?, tipodoc = ?,  idsucursal = ?, idcliente = ? WHERE idventa = ?";
	        try {
	            cx = Conexion.getConexion();
	            ps = cx.prepareStatement(SQL);
	            ps.setString(1, t.getFecha());
	            ps.setString(2, t.getTipodoc());
	            ps.setInt(3, t.getIdsucursal());
	            ps.setInt(4, t.getIdcliente());
	            ps.setInt(5, t.getIdventa());
	            x = ps.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Error: "+e);
	        }
	      return x;     
	    }

	    @Override
	    public int delete(int id) {
	        int x = 0;
	        String SQL = "DELETE FROM venta WHERE idventa = ?";
	        try {
	            cx = Conexion.getConexion();
	            ps = cx.prepareStatement(SQL);
	            ps.setInt(1, id);
	            x = ps.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Error: "+e);
	        }
	      return x;            
	    }

	    @Override
	    public Venta read(int id) {
	        Venta venta = new Venta();
	        String SQL = "SELECT *from venta WHERE idventa =?";
	        try {
	            cx = Conexion.getConexion();
	            ps = cx.prepareStatement(SQL);
	            ps.setInt(1, id);
	            rs = ps.executeQuery();
	            while(rs.next()){
	                venta.setIdventa(rs.getInt("idventa"));
	                venta.setFecha(rs.getString("fecha"));
	                venta.setTipodoc(rs.getString("tipodoc"));
	                venta.setIdsucursal(rs.getInt("idsucursal"));
	                venta.setIdcliente(rs.getInt("idcliente"));
	            }
	        } catch (SQLException e) {
	            System.out.println("Error: "+e);
	        }
	      return venta;
	    }

	    @Override
	    public List<Venta> readAll() {
	                 return null;
	    }

	    @Override
	    public List<Map<String, Object>> readAll2() {
	       List<Map<String, Object>> lista = new ArrayList<>();
	        String SQL = "SELECT v.idventa, v.fecha as fecha, v.tipodoc as documento, s.idsucursal, s.nomsucursal as sucursal, c.idcliente, concat(c.nombres,' ', c.apellidos) as cliente from venta as v " +
	                                " join sucursal as s on v.idsucursal =s.idsucursal" +
	                                " join cliente as c on v.idcliente =c.idcliente";
	        try {
	            cx = Conexion.getConexion();
	            ps = cx.prepareStatement(SQL);
	            rs = ps.executeQuery();
	            while(rs.next()){
	                Map<String, Object> map = new HashMap<>();
	                map.put("idventa", rs.getInt("idventa"));
	                map.put("fecha", rs.getString("fecha"));
	                map.put("documento", rs.getString("documento"));
	                map.put("idsucursal", rs.getInt("idsucursal"));
	                map.put("sucursal", rs.getString("sucursal"));
	                map.put("idcliente", rs.getInt("idcliente"));
	                map.put("cliente", rs.getString("cliente"));
	                lista.add(map);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error: "+e);
	        }
	      return lista;
	    }
	
}
