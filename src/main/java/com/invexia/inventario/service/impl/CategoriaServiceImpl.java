package com.invexia.inventario.service.impl;

import com.invexia.inventario.entity.CategoriaEntity;
import com.invexia.inventario.repository.CategoriaRepository;
import com.invexia.inventario.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public CategoriaEntity guardarCategoria(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public CategoriaEntity obtenerCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
