package rs.ac.bg.fon.ai.transfer.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RezultatOpTest {

    @Test
    public void testEnumValues() {
        assertEquals("Uspeh", RezultatOp.Uspeh.name());
        assertEquals("Greska", RezultatOp.Greska.name());
    }
}