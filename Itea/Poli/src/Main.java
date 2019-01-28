import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Basa basa= new Basa();

        basa.getFilms().add(new Film("A Return to Salem’s Lot", Set.of("Evelyn Keyes", "Tara Donna Reid")));
        basa.getFilms().add(new Film("Union Pacific",Set.of("Evelyn ")));
        basa.getFilms().add(new Film("Union Pacific",Set.of("Evelyn Keyes")));

        basa.getActors().add(new Actor("Tara Donna Reid",Set.of("A Return to Salem’s Lot", "Just Visiting"),56));
        basa.getActors().add(new Actor("petro", Set.of(),23));
        basa.getActors().add(new Actor("Evelyn Keyes", Set.of("A Return to Salem’s Lot"),11));





/*
        basa.getActors().forEach(actor -> System.out.println(actor));
        basa.getFilms().forEach(film -> System.out.println(film));*/

        for (Film film:  basa.getFilms()){
            System.out.println(film.toString());
        }


        for (Actor actor: basa.getActors()){
            System.out.println("Actor name: "+ actor.getName()+ "Actor year: " +actor.getYear());
        }

        ArrayList<Actor> myActorList = new ArrayList<Actor>();

        Actor firstHouse = new Actor("Tara Donna Reid",Set.of("A Return to Salem’s Lot", "Just Visiting"),56);
        Actor secondHouse = new Actor("petro", Set.of(),23);
        Actor thirdHouse = new Actor("Evelyn Keyes", Set.of("A Return to Salem’s Lot"),11);

        myActorList.add(firstHouse);
        myActorList.add(secondHouse);
        myActorList.add(thirdHouse);


        ActorYear actorYear = new ActorYear();
        myActorList.sort(actorYear);

        System.out.println("Sorted: ");
        for (Actor h: myActorList) {
            System.out.println("Actor name: "+ h.getName()+ "Actor year: " +h.getYear());
        }







    }
}
