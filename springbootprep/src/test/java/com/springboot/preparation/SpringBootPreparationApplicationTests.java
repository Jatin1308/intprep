package com.springboot.preparation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootPreparationApplicationTests {


String a;
	@Before
	public void init(){
		a = "one";
	}

	@Test
	public void t1(){
		a ="two";
		Assert.assertEquals("two",a);
	}

	@Test
	public void t2(){
		Assert.assertEquals("two",a);
	}




}
