package com.examen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.examen.config.Conexion;
import com.examen.dao.Metodos;
import com.examen.entity.Cliente;

public class ClienteDaoImpl implements Metodos<Cliente>{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx ;
	@Override
	public int create(Cliente t) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	@Override
	public int update(Cliente t) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	@Override
	public int delete(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	@Override
	public Cliente read(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	@Override
	public List<Cliente> readAll() {
		List<Cliente> lista = new ArrayList<>();
		String SQL = "select * from cliente";
		try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setIdcliente(rs.getInt("idcliente"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
		return lista;
	}
	@Override
	public List<Map<String, Object>> readAll2() {
		 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
