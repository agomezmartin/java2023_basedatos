package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Curso;
import static helpers.ConnectionLocator.getConnection;
public class CursosDaoImpl implements CursosDao {
	
	
	@Override
	public boolean existeCurso(int idCurso) {
		//implementar
	}
	@Override
	public boolean guardarCurso(Curso curso) {
		//implementar
	}
	@Override
	public List<Curso> cursos(){
		//no
		return null;
	}
	@Override
	public List<Curso> cursosFechas(LocalDate f1, LocalDate f2) {
		//no
		return null;
	}
}
