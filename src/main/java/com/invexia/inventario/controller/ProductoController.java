package com.invexia.inventario.controller;

import com.invexia.inventario.entity.ProductoEntity;
import com.invexia.inventario.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity producto) {
        return productoService.add(producto);
    }

    @PutMapping("/{id}")
    public ProductoEntity update(@PathVariable Long id, @RequestBody ProductoEntity producto) {
        return productoService.update(id, producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productoService.delete(id);
    }

    @GetMapping
    public List<ProductoEntity> listAll() {
        return productoService.listAll();
    }

    @GetMapping("/{id}")
    public ProductoEntity findById(@PathVariable Long id) {
        return productoService.findById(id);
    }
}
