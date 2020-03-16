package rest.service;

import java.util.ArrayList;
import java.util.Collections;

public class MovieDatabase implements IMovieDatabase{

	static ArrayList<Movie> movies = new ArrayList<>();
	
	@Override
	public ArrayList<Movie> getMovies() {
		
		return movies;
	}

	@Override
	public Movie getMovie(int id) {
	
		Movie temp = new Movie();
		
		for (int i=0; i< movies.size(); i++)
		{
			if(movies.get(i).getId() == id)
				temp = movies.get(i);
			
		}
		
		return temp;
	}

	@Override
	public void addMovie(Movie movie) {
		
		movie.setId(movie.getId());
		
		
		movies.add(movie);
		
	}

	@Override
	public void updateMovie(Movie movie) {
		
		for ( int i=0; i<movies.size(); i++)
		{
			if(movies.get(i).getId() == movie.getId())
			{
				movies.get(i).setActor(movie.getActor());
			movies.get(i).setDirector(movie.getDirector());
			movies.get(i).setTitle(movie.getTitle());
			movies.get(i).setYear(movie.getYear());
			}else 
				
			{
				addMovie(movie); 
			}
		}
		
	}

	@Override
	public void deleteMovie(int id) {
		for( int i=0; i<movies.size(); i++)
		{
			if(movies.get(i).getId() == id)
				movies.remove(i);
			
		}
		
	}

	@Override
	public void sortMovies(int year, String field) {
		
		ArrayList<Movie> temp = movies;
		
		if( field == "Title")
		{
			Collections.sort(temp, new SortByTitle()); 
			
		}
		
		if ( field == "Director")
		{
			Collections.sort(temp, new SortByDirector()); 
		}
			
													}
		
}
	
	

