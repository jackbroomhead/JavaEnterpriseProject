package controller;

import java.util.ArrayList;

import com.google.gson.Gson;

import model.Film;
import model.FilmDAO;

public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			FilmDAO fdao = new FilmDAO();
			
			ArrayList<Film> films = fdao.getAllFilms();
			
			for (int i=0; i<films.size(); i++) {
				Film oneFilm = films.get(i);
				//System.out.println(oneFilm.toString());
			}
			
			Gson gson = new Gson();
			String allFilmsJson = gson.toJson(films);
		//	System.out.println(allFilmsJson);
			
			Film f = fdao.getFilmByID(10013);
			System.out.println(f.toString());
			System.out.println(gson.toJson(f));
	}

}
