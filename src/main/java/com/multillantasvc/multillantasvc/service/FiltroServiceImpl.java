package com.multillantasvc.multillantasvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multillantasvc.multillantasvc.model.Filtro;
import com.multillantasvc.multillantasvc.repository.IFiltroRepository;

@Service
public class FiltroServiceImpl implements IFiltroService {

    @Autowired
    IFiltroRepository iFiltroRepository;

    @Override
    public void save(Filtro filtro) {
        iFiltroRepository.save(filtro);
    }

    @Override
    public List<Filtro> getAll() {
        return iFiltroRepository.findAll();
    }

    @Override
    public Filtro buscarFiltroPorID(int id) {
        return iFiltroRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarFiltro(int id) {
        iFiltroRepository.deleteById(id);
    }

}
