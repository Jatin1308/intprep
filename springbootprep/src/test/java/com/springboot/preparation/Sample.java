package com.springboot.preparation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Sample {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void test1() throws Exception{
        ex.expect(Exception.class);
        ex.expectMessage("");
        throw new NullPointerException();
    }

}
