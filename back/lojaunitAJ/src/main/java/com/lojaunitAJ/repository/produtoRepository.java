package com.lojaunitAJ.repository;

import org.springframework.data.repository.CrudRepository;

import com.lojaunitAJ.entidade.Produto;

public interface produtoRepository extends CrudRepository <Produto,Integer> {

}
