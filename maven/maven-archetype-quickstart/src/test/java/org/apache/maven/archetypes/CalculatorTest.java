package org.apache.maven.archetypes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: qjc
 * @Date: 2023/5/10 10:48
 * @Description: TODO
 **/
public class CalculatorTest {

    @Test
    public void testSum(){
        Calculator calculator = new Calculator();

        int sum = calculator.sum(5, 3);

        int expectResult = 8;

        assertEquals(expectResult,sum);
        System.out.println("done");


    }
}
