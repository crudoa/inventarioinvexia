package com.invexia.inventario.service;

import com.invexia.inventario.entity.ProductoEntity;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<ProductoEntity> listarProductos();
    Optional<ProductoEntity> obtenerPorId(Long id);
    ProductoEntity crearProducto(ProductoEntity producto);
    ProductoEntity actualizarProducto(Long id, ProductoEntity producto);
    void eliminarProducto(Long id);
}
