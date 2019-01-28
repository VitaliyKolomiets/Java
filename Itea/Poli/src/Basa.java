import java.util.*;

public class Basa {


    private TreeSet<Actor> actors = new TreeSet<Actor>();
    private  TreeSet<Film> films = new TreeSet<Film>();


    public Set<Actor> getActors() {
        return actors;
    }

    public Set<Film> getFilms() {
        return films;
    }


    public List InOneFilm(String actor) {
        ArrayList<String> list = new ArrayList<>();
        for (Film s : getFilms()) {
            if (s.getListActor().contains(actor)) {
                list.addAll(s.getListActor());
                list.remove(actor);
            }
        }
        return list;
    }

    public int max() {
        int max = 0;
        for (Film s : getFilms()) {
            if (s.getListActor().size() > max) {
                max = s.getListActor().size();
            }
        }
        return max;
    }

    public boolean NoFilm() {
        boolean actor = false;
        for (Actor s2 : getActors()) {
            for (Film s : getFilms()) {
                if (s.getListActor().contains(s2.getName())) {
                    break;
                } else {
                    actor = true;
                }
            }
        }
        return actor;
    }
}


