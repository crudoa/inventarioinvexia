package com.invexia.inventario.controller;

import com.invexia.inventario.entity.CategoriaEntity;
import com.invexia.inventario.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaEntity> listar() {
        return categoriaService.listarCategorias();
    }

    @PostMapping
    public CategoriaEntity guardar(@RequestBody CategoriaEntity categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    @GetMapping("/{id}")
    public CategoriaEntity obtener(@PathVariable Long id) {
        return categoriaService.obtenerCategoriaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
    }
}
