package dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import static helpers.EntityManagerLocator.*;
import model.Alumno;
public class AlumnosDaoImpl implements AlumnosDao {
	
	
	@Override
	public boolean existeAlumno(String dni) {

		return getEntityManager().find(Alumno.class, dni)!=null;
	}
	
	@Override
	public boolean guardarAlumno(Alumno alumno) {
		try {
			EntityTransaction tx=getEntityManager().getTransaction();
			tx.begin();
			getEntityManager().persist(alumno);
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean guardarAlumnos(List<Alumno> alumnos) {
		try {
			EntityTransaction tx=getEntityManager().getTransaction();
			tx.begin();
			for(Alumno alumno:alumnos) {
				getEntityManager().persist(alumno);
			}
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Alumno> alumnos(){
		//no
		return null;
	}
	@Override
	public List<Alumno> alumnos(int curso){
		//no 
		return null;
	}
	@Override
	public boolean eliminarAlumno(String dni) {
		//no
	}
	
}
