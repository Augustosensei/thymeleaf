package com.incuyo.tercero.dao;

import org.springframework.data.repository.CrudRepository;

import com.incuyo.tercero.model.Producto;

public interface IProductoDao extends CrudRepository<Producto, Integer> {

}
