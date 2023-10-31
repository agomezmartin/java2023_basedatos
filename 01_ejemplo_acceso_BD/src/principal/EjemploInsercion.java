package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploInsercion {

	public static void main(String[] args) {
		//datos de conexión a la BD
		String cadenaCon="jdbc:mysql://localhost:3306/empresa";
		String user="root";
		String pwd="root";
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			String sql="insert into empleados (nombre,email,departamento,salario) ";
			sql+="values('paco','qqqq@gmail.com','informática',1600)";
			Statement st=con.createStatement();
			st.execute(sql);
			System.out.println("Empleado añadido!!");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
