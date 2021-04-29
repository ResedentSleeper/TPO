package edu.btree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BTreeTest {

    private static BTree bt = new BTree();

    @BeforeEach
    public void setUp() {
        bt.insertValue(75);
        bt.insertValue(5);
        bt.insertValue(36);
        bt.insertValue(20);
        bt.insertValue(7);
        bt.insertValue(13);
        bt.insertValue(90);
        bt.insertValue(74);
        bt.insertValue(60);
        bt.insertValue(55);
        bt.insertValue(2);
        bt.insertValue(1);
        bt.insertValue(6);
        bt.insertValue(4);
    }


    @Test
    public void whenDeleteElements() {
        assertFalse(bt.deleteValue(38));
        assertTrue(bt.deleteValue(13));
        assertTrue(bt.deleteValue(74));
        assertTrue(bt.deleteValue(20));
        assertTrue(bt.deleteValue(5));
        assertTrue(bt.deleteValue(1));
        assertTrue(bt.deleteValue(4));
        assertTrue(bt.deleteValue(2));
        assertTrue(bt.deleteValue(36));
        assertTrue(bt.deleteValue(55));
        assertTrue(bt.deleteValue(60));
        assertTrue(bt.deleteValue(7));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/nodeValues.csv")
    public void whenAddElements(String in_1, String in_2, String in_3, String in_4, String in_5) {
        assertTrue(bt.insertValue(Integer.parseInt(in_1)));
        assertFalse(bt.insertValue(Integer.parseInt(in_2)));
        assertTrue(bt.insertValue(Integer.parseInt(in_3)));
        assertTrue(bt.insertValue(Integer.parseInt(in_4)));
        assertFalse(bt.insertValue(Integer.parseInt(in_5)));
    }

}
