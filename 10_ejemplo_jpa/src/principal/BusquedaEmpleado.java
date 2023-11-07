package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Empleado;

public class BusquedaEmpleado {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em=factory.createEntityManager();
		//busque un empleado cuyo código de empleado sea 5
		Empleado empleado=em.find(Empleado.class, 5);
		if(empleado!=null) {
			System.out.println(empleado.getNombre());
		}else {
			System.out.println("No existe");
		}
		

	}

}
