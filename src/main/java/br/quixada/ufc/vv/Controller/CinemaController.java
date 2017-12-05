package br.quixada.ufc.vv.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.quixada.ufc.vv.bean.Cinema;
import br.quixada.ufc.vv.service.CinemaService;

@RestController
@Transactional
@RequestMapping("cinema")
@CrossOrigin(origins = "*")
@Controller
public class CinemaController {
	@Autowired
	private CinemaService cinemaService;

	@RequestMapping(value = "/criar", method = RequestMethod.POST)
	public String criarCinema(@RequestBody Cinema cinema){	
		return cinemaService.criarCinema(cinema);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Cinema> listarCinema(){
		return cinemaService.listarCinema();
	}

	@RequestMapping(value = "/FindCinemaById/{id}", method = RequestMethod.GET)
	public Cinema findCinemaById(@PathVariable Integer id){
		return cinemaService.findCinemaById(id);
	}

	@RequestMapping(value = "/editar", method = RequestMethod.PUT)
	public String editarCinema(@RequestBody Cinema cinema){
		return cinemaService.editarCinema(cinema);
	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public String deletarCinema(@PathVariable Integer id){
		cinemaService.deletarCinema(id);
		return "Cinema deletado com sucesso";
	}






}
