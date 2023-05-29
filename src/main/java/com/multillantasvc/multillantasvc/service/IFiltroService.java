package com.multillantasvc.multillantasvc.service;

import java.util.List;

import com.multillantasvc.multillantasvc.model.Filtro;

public interface IFiltroService {
    void save(Filtro filtro);

    List<Filtro> getAll();

    public Filtro buscarFiltroPorID(int id);

    public void eliminarFiltro(int id);
}
