package com.invexia.inventario.service.impl;

import com.invexia.inventario.entity.ProductoEntity;
import com.invexia.inventario.repository.ProductoRepository;
import com.invexia.inventario.service.ProductoService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoEntity add(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductoEntity update(Long id, ProductoEntity producto) {
        ProductoEntity p = productoRepository.findById(id).orElseThrow();
        p.setNombre(producto.getNombre());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
        p.setStock(producto.getStock());
        return productoRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoEntity> listAll() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntity findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
}
