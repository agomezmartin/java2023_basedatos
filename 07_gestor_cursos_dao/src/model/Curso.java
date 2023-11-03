package model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {
	private int idCurso;
	private String curso;
	private int duracion;
	private double precio;
	private List<Alumno> alumnos;
	
	@Override
	public String toString() {
		return curso;
	}
	
}
