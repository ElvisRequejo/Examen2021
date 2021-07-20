package com.examen.daoImpl;

import com.examen.config.Conexion;
import com.examen.dao.Metodos;
import com.examen.entity.Sucursal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SucursalDaoImpl implements Metodos<Sucursal>{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx ;
	
	@Override
	public int create(Sucursal t) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int update(Sucursal t) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int delete(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Sucursal read(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Sucursal> readAll() {
		List<Sucursal> lista = new ArrayList<>();
        String SQL = "select * from sucursal";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Sucursal s = new Sucursal();
                s.setIdsucursal(rs.getInt("idfacultad"));
                s.setNomsucursal(rs.getString("nomsucursal"));
                lista.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
      return lista;// TODO Auto-generated method stub
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
