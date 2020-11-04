package model;

import java.util.ArrayList;

import model.Film;
import model.FilmDAO;

public class DAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FilmDAO fdao = new FilmDAO();
		
		//insert film works
//		Film fi = new Film(12346, "Spirited Away", 2000, "Miyazaki", "blank", "good");
//		fdao.insertFilm(fi);
		
		//get film by id works
	//	Film f = fdao.getFilmByID(10013);
		
		//get film by title WORKS
		ArrayList<Film> ft = fdao.getFilmByTitle("Assassins");
		
		//delete works
	//	boolean fd = fdao.deleteFilm(11202);
		
		//amend not working
		Film Fa = new Film(12345, "wars", 2001, "directorman", "daniel radcliffe", "decent");
		fdao.amendFilm(Fa);
		
		
	//	System.out.println("Film found by ID" + f.toString());
		//System.out.println("Film found by title" + ft.toString());
//		System.out.println("Film inserted" + fi.toString());
	System.out.println("Film amended" + Fa.toString());
	
		
		
	}


}
