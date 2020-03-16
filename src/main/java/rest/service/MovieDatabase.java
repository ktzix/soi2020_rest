package rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class MovieDatabase implements IMovieDatabase {

    static List<Movie> movies = new ArrayList<>();

    static {

    	Movie movie = new Movie();
    	movie.setId(Movie.createID());
    	movie.setActor(Arrays.asList("bruce lii","jennifer aniston"));

    	movies.add(movie);

		movie = new Movie();
		movie.setId(Movie.createID());
    	movies.add(movie);
	}

    @Override
    public List<Movie> getMovies() {

        return movies;
    }

    @Override
    public Movie getMovie(int id) {
        return movies.stream().filter(movie -> movie.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addMovie(Movie movie) {
		movie.setId(Movie.createID());
        movies.add(movie);
    }

    @Override
    public void updateMovie(Integer id, Movie movie) {

        Movie movieToUpdate = getMovie(id);

        if (movieToUpdate != null) {
            movieToUpdate.setActor(movie.getActor());
            movieToUpdate.setDirector(movie.getDirector());
            movieToUpdate.setTitle(movie.getTitle());
            movieToUpdate.setYear(movie.getYear());
        } else {
            addMovie(movie);
        }
    }

    @Override
    public void deleteMovie(int id) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == id)
                movies.remove(i);

        }

    }

    @Override
    public List<Movie> sortMovies(int year, String field) {

        List<Movie> result = new ArrayList<>(movies);

        if ("Title".equals(field)) {
            result.sort(new SortByTitle());

        } else if ("Director".equals(field)) {
            result.sort(new SortByDirector());
        }

        return result;
    }

}
	
	

