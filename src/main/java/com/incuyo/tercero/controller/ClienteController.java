package com.incuyo.tercero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.incuyo.tercero.model.Cliente;
import com.incuyo.tercero.service.IClienteService;


@Controller
@RequestMapping("/clientes")
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	
	@GetMapping("/navbar")
	public String principal(Model modelo) {
		return "navbar";
	}
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("titulo", "Listar Clientes");
		modelo.addAttribute("cliente", clienteService.listarClientes());
		return "listar";
	}
	
	
	@GetMapping("/form")
	public String guardarCliente(Model modelo) {
		
		Cliente cliente = new Cliente();
		
		modelo.addAttribute("cliente", cliente);
		return "form";
	}
	
	
	@GetMapping("/form/{id}")
	public String editarCliente(@PathVariable Integer id, Model m) {
		
		Cliente cliente = null;
		
		if (id > 0 ) {
			cliente = clienteService.getClienteById(id);
		}else {
			
			//me pide que cargue un cliente por lo menos
			return "redirect:/clientes/listar";
		}
		
		m.addAttribute("cliente", cliente);
		
		return "form";
	}

	
	
	
	@PostMapping("/form")
	public String persistir(Cliente cliente, SessionStatus estado) {
		clienteService.guardarModificar(cliente);
		estado.isComplete();
		
		return "redirect:/clientes/listar";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Integer id, Model m) {
		
		if (id > 0) {
			clienteService.eliminarById(id);
		}
		
		return "redirect:/clientes/listar";
		
	}

	
}
