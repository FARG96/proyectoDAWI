package com.multillantasvc.multillantasvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multillantasvc.multillantasvc.model.CategoriaFiltro;
import com.multillantasvc.multillantasvc.repository.ICategoriaFiltroRepository;

@Service
public class CategoriaFiltroServiceImpl implements ICategoriaFiltroService {

    @Autowired
    ICategoriaFiltroRepository iCategoriaFiltroRepository;

    @Override
    public void guardarCategoriaFiltro(CategoriaFiltro categoriaFiltro) {
        iCategoriaFiltroRepository.save(categoriaFiltro);
    }

    @Override
    public List<CategoriaFiltro> getAll() {
        return iCategoriaFiltroRepository.findAll();
    }

    @Override
    public CategoriaFiltro buscarCategoriaFiltroPorID(int id) {
        return iCategoriaFiltroRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCategoriaFiltro(int id) {
        iCategoriaFiltroRepository.deleteById(id);
    }

}
