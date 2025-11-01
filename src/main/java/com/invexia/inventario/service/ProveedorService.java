package com.invexia.inventario.service;

import com.invexia.inventario.entity.ProveedorEntity;
import java.util.List;

public interface ProveedorService {
    List<ProveedorEntity> listar();
    ProveedorEntity obtenerPorId(Long id);
    ProveedorEntity crear(ProveedorEntity proveedor);
    ProveedorEntity actualizar(Long id, ProveedorEntity proveedor);
    void eliminar(Long id);
}
