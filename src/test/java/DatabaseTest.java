import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database db = new Database();
    Superhero ironMan = new Superhero("Iron Man", "Tony Stark", "Has big brain", 2005, true, 800);
    //Udføres én gang før hver test
    @BeforeEach
    void setUp() {
        db.addSuperhero("Iron Man", "Tony Stark", "Has big brain", 2005, true, 800);
    }

    @Test
    void getSuperheroList() {
        ArrayList<Superhero> expectedList = new ArrayList<Superhero>(List.of(new Superhero ("Iron Man", "Tony Stark", "Has big brain", 2005, true, 800)));
        ArrayList<Superhero> actualList = db.getSuperheroList();

        assertEquals(expectedList, actualList);
        //assertSame(expectedList, actualList);
    }

    @Test
    void addSuperhero() {
        //startSize er 1 fordi vi har added iron til at starte med.
        int startSize = 1;
        db.addSuperhero("Captain America", "Steve Rogers", "Superhuman Strength", 1941, true, 999);

        //expectedSize bliver 2 efter vi har added captain america.
        int expectedSize = 2;
        int actualSize = db.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void searchSuperhero() {
        //Vi kigger efter size fordi når vi søger på en superhelt, tilføjes denne til en arraylist.
        //og vi ved at vi har netop 1 i denne arraylist fordi vi kun har en iron man i listen.
        //Derfor når vi søger skal listen have en størrelse på 1.
        int expectedSize = 1;

        ArrayList<Superhero> searchResult = db.searchSuperhero("Iron Man");
        int actualSize = searchResult.size();

        assertEquals(expectedSize, actualSize);
    }

}