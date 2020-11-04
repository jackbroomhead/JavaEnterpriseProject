package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import model.Film;
import model.FilmDAO;

/**
 * Servlet implementation class PopulateTable
 */
@WebServlet("/PopulateTable")
public class PopulateTable extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
/*		PrintWriter out = response.getWriter();
		FilmDAO fdao = new FilmDAO();
		
		ArrayList<Film> films = fdao.getAllFilms();
		
		
		for (int i=0; i<films.size(); i++) {
			Film oneFilm = films.get(i);
		}
		Gson gson = new Gson();
		String allFilmsJSON = gson.toJson(films);
		out.println(gson.toJson(films)); */
		
		ArrayList<Film> films = new ArrayList<Film>();
		FilmDAO fdao = new FilmDAO();
		films = fdao.getAllFilms();
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(films, new TypeToken<List<Film>>() {}.getType());
		
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
