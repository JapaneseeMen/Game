import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GameZoneTest {
    Player valera = new Player(1, "Valera", 225);
    Player vitalya = new Player(2, "Vitalya", 225);
    Player vlad = new Player(3, "Vlad", 238);
    Player maksim = new Player(4, "Maksim", 199);
    Player dima = new Player(5, "Dima", 245);
    HashMap<String, Player> listPlayers = new HashMap<>();
    GameArea gameArea = new GameArea(listPlayers);

    @BeforeEach
    public void setUp() {
        listPlayers.put("Valera", valera);
        listPlayers.put("Vitalya", vitalya);
        listPlayers.put("Vlad", vlad);
        listPlayers.put("Maksim", maksim);
    }

    @Test
    public void CheckWithNullPlayersTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.round(null, null);
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckTheSamePlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.round("Vitalya", "Vitalya");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckWithNullSecondPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.round("Vitalya", null);
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckWithNullFirstPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.round(null, "Vitalya");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckWithoutPlayersTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.round("", "");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckWithoutSecondPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.round("Vitalya", "");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckWithoutFirstPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.round("", "Vitalya");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckNotRegisteredFirstPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.round("Dima", "Vlad");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void CheckNotRegisteredSecondPlayerTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.round("Maksim", "Dima");
        });
        Assertions.assertNotNull(exception.getMessage().contains("Не зарегистрирован игрок"));
    }

    @Test
    public void roundSecondPlayerStrongerTest() {
        Assertions.assertEquals(2, gameArea.round("Vitalya", "Vlad"));
    }

    @Test
    public void roundFirstPlayerStrongerTest() {
        Assertions.assertEquals(1, gameArea.round("Vitalya", "Maksim"));
    }

    @Test
    public void registerStrengthAreEqualTest() {
        Assertions.assertEquals(0, gameArea.round("Vitalya", "Valera"));
    }

    @Test
    public void registerValidTest() {
        Assertions.assertEquals(true, gameArea.register(valera));
    }


    @Test
    public void registerNotValidTest() {
        Assertions.assertEquals(false, gameArea.register(dima));
    }

    @Test
    public void findByNameValidTest() {
        Assertions.assertEquals(vitalya, gameArea.findByName("Vitalya"));
    }

    @Test
    public void findByNameNotValidTest() {
        Assertions.assertEquals(null, gameArea.findByName("Dima"));
    }

    @Test
    public void findByNameExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.findByName("");
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void findByNameNullExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            gameArea.findByName(null);
        });
        Assertions.assertNotNull(exception.getMessage());
    }
}