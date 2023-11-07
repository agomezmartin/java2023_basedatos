package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Empleado;

public class AltaEmpleado {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em=factory.createEntityManager();
		//alta
		Empleado empleado=new Empleado(0, "hibernate", "hiber@gmail.com", "I+D", 2000);
		EntityTransaction tx=em.getTransaction();
		tx.begin();//comienza transacción
		em.persist(empleado);
		tx.commit();

	}

}
