import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    void assetThatBugsAreBeingCloned() throws CloneNotSupportedException {
        Bug cricket = new Bug("Há um bug no sistema!");
        cricket.setId(1);

        Bug scorpion = cricket.clone();
        scorpion.setId(2);
        scorpion.setMessage("Uma ameaça foi detectada!");

        Bug spider = scorpion.clone();
        spider.setId(3);

        ArrayList<String> bugs = new ArrayList<>();
        bugs.add("[");
        bugs.add(cricket.toString().concat(","));
        bugs.add(scorpion.toString().concat(","));
        bugs.add(spider.toString());
        bugs.add("]");

        for(String bug : bugs) {
            System.out.println(bug);
        }

        assertEquals("{\n  \"Bug\": {\n    \"id\": 3,    \n    \"message\": \"Atenção! Uma ameaça foi detectada!\"\n  }\n}", spider.toString());
        assertEquals("{\n  \"Bug\": {\n    \"id\": 1,    \n    \"message\": \"Atenção! Há um bug no sistema!\"\n  }\n}", cricket.toString());
        assertEquals("{\n  \"Bug\": {\n    \"id\": 2,    \n    \"message\": \"Atenção! Uma ameaça foi detectada!\"\n  }\n}", scorpion.toString());
    }

    @Test
    void testIfARandomBugIsBeingThrown() {
        Exception exception = assertThrows(Exception.class, () -> Runner.askUserForInput(333));
        assertTrue(exception.getMessage().contains("Atenção!"));
    }

}