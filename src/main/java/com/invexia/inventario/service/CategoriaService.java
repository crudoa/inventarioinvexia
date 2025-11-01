package com.invexia.inventario.service;

import com.invexia.inventario.entity.CategoriaEntity;
import java.util.List;

public interface CategoriaService {
    List<CategoriaEntity> listarCategorias();
    CategoriaEntity guardarCategoria(CategoriaEntity categoria);
    CategoriaEntity obtenerCategoriaPorId(Long id);
    void eliminarCategoria(Long id);
}
