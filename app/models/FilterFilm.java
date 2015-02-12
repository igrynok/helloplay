package models;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aliya
 * Date: 10/28/12
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class FilterFilm {
    public String country;
    public String year;
    public String director;
    public String genre;

    public static List<String> countryOptions() {
        return Arrays.asList("Argentina", "Armenia", "Australia", "Austria", "Belgium", "Brazil", "Canada",
                             "Czech Republic", "Finland", "France", "India", "Germany", "India",
                             "Italy", "Japan", "Russian Federation", "United Kingdom", "United States");
    }

    public static List<String> yearOptions() {
        return  Arrays.asList("1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
                "2000","2001", "2002", "2003", "2004","2005", "2006", "2007", "2008", "2009", "2010",
                "2011", "2012");
    }

    public static List<String> directorOptions() {
        return Arrays.asList("Steven Spielberg", "Clint Eastwood", "Joel Coen", "Steven Soderbergh", "David Fincher",
                             "Peter Jackson", "Ron Howard", "Quentin Tarantino", "James Cameron", "Ang Lee");
    }

    public static List<String> genreOptions()  {
        return Arrays.asList("adventure", "cartoon", "comedy", "drama", "horror", "fantasy", "western");
    }
}
