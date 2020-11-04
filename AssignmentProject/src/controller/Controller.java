package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Film;
import model.FilmDAO;
/**
 * this servlet was used as a test, to ensure I could convert films into different formats
 * 
 */
/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		FilmDAO fdao = new FilmDAO();
		
		ArrayList<Film> films = fdao.getAllFilms();
		
		for (int i=0; i<films.size(); i++) {
			Film oneFilm = films.get(i);
			System.out.println(oneFilm.toString());
		} 
		
		
		Gson gson = new Gson();
		String allFilmsJson = gson.toJson(films);
		System.out.println(allFilmsJson);
		
		Film f = fdao.getFilmByID(10001);
		
	
	
	request.setAttribute("films", films);
    String format = request.getParameter("format");
    String outputPage;
    if ("xml".equals(format)) {
      response.setContentType("text/xml");
      outputPage = "/WEB-INF/results/films-xml.jsp";
    } else if ("json".equals(format)) {
      response.setContentType("application/json");
      outputPage = "/WEB-INF/results/films-json.jsp";
    } else {
      response.setContentType("text/plain");
      outputPage = "/WEB-INF/results/films-string.jsp";
    }
    RequestDispatcher dispatcher =
      request.getRequestDispatcher(outputPage);
    dispatcher.include(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
