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

	
	@Test
	public void criarCinemaExistTest(){  //CT002
		Cinema cinema = new Cinema();
		cinema.setNome("Cine Teste");
		cinema.setCidade("Cidade Teste");

		controller.criarCinema(cinema);

		Cinema cinema2 = new Cinema();
		cinema2.setNome("Cine Teste");
		cinema2.setCidade("Cidade Teste");

		assertEquals(controller.criarCinema(cinema2), "Cinema ja cadastrado");
	}

	@Test
	public void criarCinemaCidadeTest(){ //CT003
		Cinema cinema = new Cinema();
		cinema.setNome("Cine");
		cinema.setCidade("Quixada");

		controller.criarCinema(cinema);

		Cinema cinema2 = new Cinema();
		cinema2.setNome("Cine");
		cinema2.setCidade("Sobral");

		assertEquals(controller.criarCinema(cinema2), "Cinema cadastrado com sucesso");
	}

	@Test
	public void criarCinemaNomeTest(){ //CT004
		Cinema cinema = new Cinema();
		cinema.setNome("Cine");
		cinema.setCidade("Aracati");

		controller.criarCinema(cinema);

		Cinema cinema2 = new Cinema();
		cinema2.setNome("Cine3D");
		cinema2.setCidade("Aracati");

		assertEquals(controller.criarCinema(cinema2), "Cinema cadastrado com sucesso");
	}

//	@Test
//	public void listarCinemasTest(){ //CT005
//		assertTrue(controller.listarCinema().size() > 0);
//	}
	
	@Test
	public void editarCinemaNomeExistTest() {//CT006
		Cinema cinema = new Cinema();
		cinema.setCidade("Juazeiro do Norte");
		cinema.setNome("CineJuá");
		
		controller.criarCinema(cinema);
		
		Cinema newCinema = new Cinema();
		newCinema.setCidade("Crato");
		newCinema.setNome("UCI");
		
		controller.criarCinema(newCinema);
		
		for(Cinema cine : controller.listarCinema()){
			if((cine.getNome().equals(newCinema.getNome()) &&(cine.getCidade().equals(newCinema.getCidade())))){
				newCinema = cine;
			}
		}
		
		newCinema.setNome("CineJuá");
		newCinema.setCidade("Juazeiro do Norte");
		assertEquals(controller.editarCinema(newCinema), "Cinema ja cadastrado");
	}

	@Test
	public void editarCinemaTest() {//CT007
		Cinema cinema = new Cinema();
		cinema.setCidade("Cruz Das Almas");
		cinema.setNome("Cineplex");
		
		controller.criarCinema(cinema);
		
		cinema.setNome("CineCruz");
		cinema.setCidade("Banabuiú");
		assertEquals(controller.editarCinema(cinema), "Cinema cadastrado com sucesso");
	}
	
	@Test
	public void editarCinemaCidadeTest() { //CT008
		Cinema cinema = new Cinema();
		cinema.setCidade("Iguatu");
		cinema.setNome("Cineplex");
		
		controller.criarCinema(cinema);
		
		Cinema newCinema = new Cinema();
		newCinema.setCidade("Quixada");
		newCinema.setNome("CineQuixada");
		
		controller.criarCinema(newCinema);
		
		for(Cinema cine : controller.listarCinema()){
			if((cine.getNome().equals(newCinema.getNome()) &&(cine.getCidade().equals(newCinema.getCidade())))){
				newCinema = cine;
			}
		}
		
		newCinema.setNome("Cine3D");
		newCinema.setCidade("Iguatu");
		assertEquals(controller.editarCinema(newCinema), "Cinema cadastrado com sucesso");
	}
	
	
	@Test
	public void editarCinemaNomeTest() { //CT009
		Cinema cinema = new Cinema();
		cinema.setCidade("Fortaleza");
		cinema.setNome("Cineplex");
		
		controller.criarCinema(cinema);
		
		
		Cinema newCinema = new Cinema();
		newCinema.setCidade("Quixada");
		newCinema.setNome("CineQuixada");
		
		controller.criarCinema(newCinema);
		
		for(Cinema cine : controller.listarCinema()){
			if((cine.getNome().equals(newCinema.getNome()) &&(cine.getCidade().equals(newCinema.getCidade())))){
				newCinema = cine;
			}
		}
		
		newCinema.setNome("Cineplex");
		newCinema.setCidade("Quixada");
		assertEquals(controller.editarCinema(newCinema), "Cinema cadastrado com sucesso");
	}

	@Test
	public void deletarCinemaTest(){ //CT010
		Cinema cinema = new Cinema();
		cinema.setCidade("Salvador");
		cinema.setNome("CineQuixada");
		
		controller.criarCinema(cinema);
		
		for(Cinema cine : controller.listarCinema()){
			if((cine.getNome().equals(cinema.getNome()) &&(cine.getCidade().equals(cinema.getCidade())))){
				cinema = cine;
			}
		}
		
		assertEquals(controller.deletarCinema(cinema.getId()), "Cinema deletado com sucesso");
	}


}
