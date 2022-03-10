package com.incuyo.tercero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incuyo.tercero.dao.IClienteDao;
import com.incuyo.tercero.model.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	
	@Autowired
	private IClienteDao clienteDao;
	
	
	@Override
	public List<Cliente> listarClientes() {
		
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public Cliente getClienteById(Integer id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public Cliente guardarModificar(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	public void eliminarById(Integer id) {
		clienteDao.deleteById(id);
		
	}



	
	
}
