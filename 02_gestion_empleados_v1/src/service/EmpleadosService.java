package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Empleado;

public class EmpleadosService {
	String cadenaCon="jdbc:mysql://localhost:3306/empresa";
	String user="root";
	String pwd="root";
	public boolean altaEmpleado(Empleado empleado) {
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
			/*String sql="insert into empleados (nombre,email,departamento,salario) ";
			sql+="values('"+empleado.getNombre()+"','"+empleado.getEmail()+"','"+empleado.getDepartamento()+"',"+empleado.getSalario()+")";
			Statement st=con.createStatement();
			st.execute(sql);
			return true;*/
			//opción con PreparedStatement
			String sql="insert into empleados (nombre,email,departamento,salario) values (?,?,?,?)";
			//se crea el preparestatement a partir de la sql
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getEmail());
			ps.setString(3, empleado.getDepartamento());
			ps.setDouble(4, empleado.getSalario());
			ps.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
		public boolean eliminarEmpleado(String email) {
			try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){				
				String sql="delete from empleados where email=?";
				//se crea el preparestatement a partir de la sql
				PreparedStatement ps=con.prepareStatement(sql);
				//sustituimos parámetros por valores
				ps.setString(1, email);
				ps.execute();
				return true;
			}
			catch(SQLException ex) {
				ex.printStackTrace();
				return false;
			}
		}
		public boolean modificarSalarioEmpleado(double nuevoSalario, int idEmpleado) {
			
			try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){				
				String sql="update empleados set salario=? where idEmpleado=?";
				//se crea el preparestatement a partir de la sql
				PreparedStatement ps=con.prepareStatement(sql);
				//sustituimos parámetros por valores
				ps.setDouble(1, nuevoSalario);
				ps.setInt(2, idEmpleado);
				ps.execute();
				return true;
			}
			catch(SQLException ex) {
				ex.printStackTrace();
				return false;
			}
		}
	//eliminar empleados por email
	//modificar salario de empleado: se recibe el idEmpleado y el nuevo salario

}
