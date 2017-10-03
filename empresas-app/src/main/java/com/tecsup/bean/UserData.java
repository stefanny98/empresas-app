package com.tecsup.bean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		String stm = "select nombre, descripcion from empresas";
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
