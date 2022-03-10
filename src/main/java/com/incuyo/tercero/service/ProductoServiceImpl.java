package com.incuyo.tercero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incuyo.tercero.dao.IProductoDao;
import com.incuyo.tercero.model.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao dao;
	
	@Override
	public List<Producto> listarProdutos() {
		return (List<Producto>) dao.findAll();
	}

	@Override
	public Producto getProductoById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Producto guardarModificar(Producto producto) {
		return dao.save(producto);
	}

	@Override
	public void eliminarById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
