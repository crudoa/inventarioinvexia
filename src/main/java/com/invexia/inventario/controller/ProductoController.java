package com.invexia.inventario.controller;

import com.invexia.inventario.entity.ProductoEntity;
import com.invexia.inventario.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<ProductoEntity> listar() {
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public ProductoEntity obtener(@PathVariable Long id) {
        return productoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @PostMapping
    public ProductoEntity crear(@RequestBody ProductoEntity producto) {
        return productoService.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public ProductoEntity actualizar(@PathVariable Long id, @RequestBody ProductoEntity producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "Producto eliminado correctamente";
    }
}
