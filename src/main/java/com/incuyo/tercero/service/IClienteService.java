package com.incuyo.tercero.service;

import java.util.List;
import com.incuyo.tercero.model.Cliente;

public interface IClienteService {

	
	public List<Cliente> listarClientes();
	public Cliente getClienteById(Integer id);
	public Cliente guardarModificar(Cliente cliente);
	public void eliminarById(Integer id);
	
}
