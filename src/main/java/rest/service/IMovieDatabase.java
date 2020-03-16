package rest.service;
import java.util.List;

import javax.ws.rs.*;


@Path("MovieDatabase")
public interface IMovieDatabase {
	
	@GET
	@Path("movies")
	public List<Movie> getMovies();
	
	@GET
	@Path("movies/{id}")
	public Movie getMovie(@QueryParam("id") int id);
	
	
	@POST
	@Path("movies")
	public void addMovie(Movie movie);
	
	@PUT
	@Path("movies/{id}")
	public void updateMovie(@PathParam("id") Integer id,   Movie movie);
	
	@DELETE
	@Path("movies({id}")
	public void deleteMovie(@QueryParam("id") int id);
	
	@GET
	@Path("movies")
	public List<Movie> sortMovies(@QueryParam("year") int year, @QueryParam("orderby") String field);
	
	
}
