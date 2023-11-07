package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Empleado;

public class EliminarEmpleado {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em=factory.createEntityManager();
		//eliminar empleado de código 5
		Empleado emp=em.find(Empleado.class, 5);
		if(emp!=null) {
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.remove(emp);
			tx.commit();
			System.out.println("Eliminado");
		}else {
			System.out.println("No existe");
		}

	}

}
