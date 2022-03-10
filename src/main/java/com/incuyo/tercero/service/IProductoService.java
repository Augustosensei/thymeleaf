package com.incuyo.tercero.service;

import java.util.List;

import com.incuyo.tercero.model.Producto;


public interface IProductoService {

	public List<Producto> listarProdutos();
	public Producto getProductoById(Integer id);
	public Producto guardarModificar(Producto producto);
	public void eliminarById(Integer id);
	
	
}
