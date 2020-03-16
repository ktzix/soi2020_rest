package rest.service;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path("MovieDatabase")
public interface IMovieDatabase {
	
	@GET
	@Path("movies")
	public ArrayList<Movie> getMovies();
	
	@GET
	@Path("movies/{id}")
	public Movie getMovie(@QueryParam("id") int id);
	
	
	@POST
	@Path("movies")
	public void addMovie(Movie movie);
	
	@PUT
	@Path("movies/{id}")
	public void updateMovie(Movie movie);
	
	@DELETE
	@Path("movies({id}")
	public void deleteMovie(@QueryParam("id") int id);
	
	@GET
	@Path("movies")
	public void sortMovies(@QueryParam("year") int year, @QueryParam("orderby") String field);
	
	
}
