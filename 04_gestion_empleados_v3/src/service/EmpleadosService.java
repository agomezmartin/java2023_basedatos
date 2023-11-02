package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<Empleado> empleadosPorDepartamento(String dep){
		List<Empleado> empleados=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){				
			String sql="select * from empleados where departamento=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dep);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				empleados.add(new Empleado(rs.getInt("idEmpleado"),
							rs.getString("nombre"),
							rs.getString("email"),
							rs.getString("departamento"),
							rs.getDouble("salario")
						));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();		
		}
		return empleados;
	}
	
}
