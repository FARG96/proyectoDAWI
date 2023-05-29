package com.multillantasvc.multillantasvc.service;

import java.util.List;

import com.multillantasvc.multillantasvc.model.CategoriaFiltro;

public interface ICategoriaFiltroService {
    public void guardarCategoriaFiltro(CategoriaFiltro categoriaFiltro); // CREATE

    List<CategoriaFiltro> getAll(); // READ

    public CategoriaFiltro buscarCategoriaFiltroPorID(int id); // UPDATE - SEARCH

    public void eliminarCategoriaFiltro(int id); // DELETE
}
