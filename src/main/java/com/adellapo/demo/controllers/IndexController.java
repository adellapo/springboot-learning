package com.adellapo.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adellapo.demo.models.Usuario;
import com.adellapo.demo.models.service.MiServicio;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Autowired
	private MiServicio servicio;

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;

	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;

	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	@GetMapping(value = { "/index" })
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		model.addAttribute("titulo", textoIndex + " Index!");
		return "index";
	}

	@GetMapping(value = { "/" })
	public String empty(ModelMap mm) {
		mm.put("titulo", textoIndex + "!");
		return "index";
	}

	@GetMapping(value = { "/home" })
	public ModelAndView home(ModelAndView mv) {
		mv.addObject("titulo", textoIndex + " Home!");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("Andres");
		usuario.setApellido("Della Porta");
		usuario.setEmail("andresdp28@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping(value = "/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		return "listar";
	}

	@ModelAttribute(value = "usuarios")
	public List<?> obtenerUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Enea", "Della Porta", "eneadp@email.com"),
				new Usuario("Andres", "Della Porta", "andresdp@email.com"),
				new Usuario("Hernan", "Della Porta", "hernandp@email.com"));
		return usuarios;
	}

}
