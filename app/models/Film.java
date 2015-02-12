package models;

import com.avaje.ebean.ExpressionList;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aliya
 * Date: 10/28/12
 * Time: 7:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Film extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String label;

//    @Constraints.Required
    public String year;

//    @Constraints.Required
    public String country;
//
//    @Constraints.Required
    public String director;
//
//    @Constraints.Required
    public String genre;
//
    public String rating;

    public String picture;

    @Column(columnDefinition="TEXT")
    public String description;

    public static Finder<Long, Film> find = new Finder(Long.class, Film.class);

    public static List<Film> all() {
        return find.all();
    }
    public static void create(Film film){
        film.save();
    }

    public static void edit(Long id){
        find.ref(id).update();
    }

    public static void delete(Long id){
        find.ref(id).delete();
    }

    public static List<Film> filter(String country, String year, String director, String genre){

        ExpressionList<Film> expressionList = find.where();

        if(!"".equals(country)) {
            expressionList.ilike("country", country);
        }

        if(!"".equals(year)) {
            expressionList.ilike("year", year);
        }

        if(!"".equals(director)) {
            expressionList.ilike("director", director);
        }

        if(!"".equals(genre)) {
            expressionList.ilike("genre", genre);
        }

        return expressionList.findList();
    }
}
