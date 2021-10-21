package com.github.maquina1995.football;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.christian.football.Main;

@SpringBootTest(classes = Main.class)
class RigorousTest {

	@Test
	void rigorousTest() {
		Assertions.assertTrue(true);
	}

}
