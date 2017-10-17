package com.tecsup.bean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Empresa> getEmpresas() {
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = getConnection();
		String stm = "select nombre, descripcion from Empresas";
		
		List<Empresa> records = new ArrayList<Empresa>();
		try {
			pst = con.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				Empresa emp = new Empresa();
				emp.setNombre(rs.getString(1));
				emp.setDescripcion(rs.getString(2));
				records.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Empresa.setEmpresas(records);
		List<Empresa> empresas = Empresa.getEmpresas();
		
		for(Empresa empresa: empresas){
			System.out.println(empresa.getNombre());
		}
		
		return records;
	}
	
	public List<Paradero> getParaderos(){
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = getConnection();
		String stm = "select e.nombre, p.nombre from empresas e, paraderos p, empresas_has_paraderos "
				+ "where empresas_id_empresa = id_empresa and paraderos_id_paradero= id_paradero";
		List<Paradero> records = new ArrayList<Paradero>();
		try {
			pst = con.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				Paradero emp = new Paradero();
				emp.setNombreEmpresa(rs.getString(1));
				emp.setNombreParadero(rs.getString(2));
				records.add(emp);

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return records;
	}

	public Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3307/prueba";
		String user = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection completed.");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			// TODO Auto-generated catch block
			System.err.println(ex.getMessage());
		} finally {
		}
		return con;
	}

}
