package com.invexia.inventario.service;

import com.invexia.inventario.entity.ProductoEntity;
import java.util.List;

public interface ProductoService {
    ProductoEntity add(ProductoEntity producto);
    ProductoEntity update(Long id, ProductoEntity producto);
    void delete(Long id);
    List<ProductoEntity> listAll();
    ProductoEntity findById(Long id);
}
