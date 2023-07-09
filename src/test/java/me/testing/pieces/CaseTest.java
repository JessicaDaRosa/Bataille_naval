package me.testing.pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaseTest {
    @Test
    public void getPosition(){
        int [] expectation = {3,4};
        Case c = new Case(3,4);
        int[] position =c.getPosition();
        Assertions.assertEquals(expectation[0], position[0]);
        Assertions.assertEquals(expectation[1], position[1]);
    }
    

}
