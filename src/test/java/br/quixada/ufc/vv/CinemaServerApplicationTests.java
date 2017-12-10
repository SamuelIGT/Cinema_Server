package br.quixada.ufc.vv;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.quixada.ufc.vv.Controller.CinemaController;
import br.quixada.ufc.vv.bean.Cinema;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaServerApplicationTests {

	@Autowired
	CinemaController controller;
	
	@Before
	public void setup() {
		for(Cinema cinema : controller.listarCinema()) {
			controller.deletarCinema(cinema.getId());
		}
	}
	
	@After
	public void setup2() {
		for(Cinema cinema : controller.listarCinema()) {
			controller.deletarCinema(cinema.getId());
		}
	}

	@Test
	public void criarCinemaTest() {    //CT001
		Cinema cinema = new Cinema();
		cinema.setNome("Cinema");
		cinema.setCidade("Cidade");

		assertEquals(controller.criarCinema(cinema), "Cinema cadastrado com sucesso");
	}

}
