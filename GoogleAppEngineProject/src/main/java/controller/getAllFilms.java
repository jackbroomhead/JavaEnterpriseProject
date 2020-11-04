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

import model.Film;
import model.FilmDAO;

/**
 * Servlet implementation class getAllFilms
 */
@WebServlet(name = "getAllFilms",
urlPatterns = {"/getAllFilms"})
public class getAllFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllFilms() {
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
			out.println(oneFilm);
	} 
		
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
