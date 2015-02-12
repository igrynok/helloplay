package controllers;

import models.Film;
import models.FilterFilm;
import play.*;
import play.data.*;
import play.mvc.*;

import scalax.io.support.FileUtils;
import views.html.*;

import java.io.*;
import java.nio.channels.FileChannel;

public class Application extends Controller {

    static Form<Film> filmForm = form(Film.class);
    static Form<FilterFilm> filterFilmForm = form(FilterFilm.class);

    public static Result index() {
        return redirect(routes.Application.films());
    }

    public static Result films() {
        return ok(
                views.html.index.render(Film.all(), filmForm, filterFilmForm)
        );
    }

    public static Result newFilm() throws IOException{
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");
        File file = picture.getFile();

        File destination = new File(play.Play.application().path().toString() + "/public/images/" + picture.getFilename());

        FileChannel source = null;
        FileChannel dest = null;
        try {
            source = new FileInputStream(file).getChannel();
            dest = new FileOutputStream(destination).getChannel();
            dest.transferFrom(source, 0, source.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  finally {
            if(source != null)
                source.close();
            if(dest !=null)
                dest.close();
        }

        Form<Film> filledForm = filmForm.bindFromRequest();
        filledForm.get().picture = "assets/images/" + picture.getFilename();
        System.out.println(filledForm.get().picture);
        if(filledForm.hasErrors()) {
            return badRequest(
                    views.html.index.render(Film.all(), filledForm, filterFilmForm)
            );
        } else {
            Film.create(filledForm.get());
            return redirect(routes.Application.films());
        }

    }

    public static Result editFilm(Long id) {
        Film.edit(id);
        return redirect(routes.Application.films());
    }

    public static Result deleteFilm(Long id) {
        Film.delete(id);
        return redirect(routes.Application.films());
    }

    public static Result filterFilms() {
        Form<FilterFilm> filled = filterFilmForm.bindFromRequest();
        String sel_country = filled.get().country;
        String sel_year = filled.get().year;
        String sel_director = filled.get().director;
        String sel_genre = filled.get().genre;
        return ok(
                views.html.index.render(Film.filter(sel_country, sel_year, sel_director, sel_genre), filmForm, filled)
        );
    }

}