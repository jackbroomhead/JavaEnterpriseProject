package model;

import java.util.ArrayList;

import model.Film;
import model.FilmDAO;

/**
 * this class is used to test that the DAO can interact with the database
 * @author jackbroomhead
 *
 */

public class DAOTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FilmDAO fdao = new FilmDAO();
		
		//insert film
		Film fi = new Film(12388, "The Great Hack", 2000, "Netflix", "Snowdon", "good");
		fdao.insertFilm(fi);
		
		//get film by id
		Film f = fdao.getFilmByID(10001);
		
		//get film by title
		ArrayList<Film> ft = fdao.getFilmByTitle("Assassins");
		
		//delete works
		boolean fd = fdao.deleteFilm(11000);
		
		//amend not working
	Film Fa = new Film(12345, "wars", 2001, "directorman", "daniel radcliffe", "decent");
	fdao.amendFilm(Fa);
		
		
		System.out.println("Film found by ID" + f.toString());
		System.out.println("Film found by title" + ft.toString());
		System.out.println("Film inserted" + fi.toString());
	System.out.println("Film amended" + Fa.toString());
	
		
		
	}


}
