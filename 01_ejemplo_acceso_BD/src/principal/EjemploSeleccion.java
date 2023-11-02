package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploSeleccion {

	public static void main(String[] args) {
		String cadenaCon="jdbc:mysql://localhost:3306/empresa";
		String user="root";
		String pwd="root";
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd)){
			String sql="select nombre from empleados";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("nombre"));
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
