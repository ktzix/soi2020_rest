package rest.service;

import java.util.Comparator;

public class SortByDirector implements Comparator<Movie>{

	@Override
	public int compare(Movie o1, Movie o2) {
		
		return o1.getDirector().compareTo(o2.getDirector());
		
	}
	
	
	

}
