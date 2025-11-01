package com.invexia.inventario.service.impl;

import com.invexia.inventario.entity.ProductoEntity;
import com.invexia.inventario.repository.ProductoRepository;
import com.invexia.inventario.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<ProductoEntity> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public ProductoEntity crearProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductoEntity actualizarProducto(Long id, ProductoEntity producto) {
        return productoRepository.findById(id).map(p -> {
            p.setNombre(producto.getNombre());
            p.setDescripcion(producto.getDescripcion());
            p.setPrecio(producto.getPrecio());
            p.setStock(producto.getStock());
            p.setActivo(producto.getActivo());
            p.setCategoria(producto.getCategoria());
            return productoRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
