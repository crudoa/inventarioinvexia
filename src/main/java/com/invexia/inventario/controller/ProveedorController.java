package com.invexia.inventario.controller;

import com.invexia.inventario.entity.ProveedorEntity;
import com.invexia.inventario.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping
    public List<ProveedorEntity> listar() {
        return proveedorService.listar();
    }

    @GetMapping("/{id}")
    public ProveedorEntity obtenerPorId(@PathVariable Long id) {
        return proveedorService.obtenerPorId(id);
    }

    @PostMapping
    public ProveedorEntity crear(@RequestBody ProveedorEntity proveedor) {
        return proveedorService.crear(proveedor);
    }

    @PutMapping("/{id}")
    public ProveedorEntity actualizar(@PathVariable Long id, @RequestBody ProveedorEntity proveedor) {
        return proveedorService.actualizar(id, proveedor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proveedorService.eliminar(id);
    }
}
