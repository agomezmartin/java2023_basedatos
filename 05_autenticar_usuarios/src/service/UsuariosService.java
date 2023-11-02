package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UsuariosService {
	String cadenaCon="jdbc:mysql://localhost:3306/empresa";
	String user="root";
	String pwd="root";
	
	public boolean autenticar(User user) {
		try(Connection con=DriverManager.getConnection(cadenaCon, this.user, pwd)){
			String sql="select * from usuarios where password=? and usuario=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUsuario());
			ResultSet rs=ps.executeQuery();
			/*if(rs.next()) {
				return true;
			}else {
				return false;
			}*/
			return rs.next();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public User getUser(String usuario) {
		try(Connection con=DriverManager.getConnection(cadenaCon, this.user, pwd)){
			String sql="select * from usuarios where and usuario=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, usuario);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new User(usuario,rs.getString("password"));
			}
			return null;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
