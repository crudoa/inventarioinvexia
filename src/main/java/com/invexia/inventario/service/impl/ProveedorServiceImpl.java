package com.invexia.inventario.service.impl;

import com.invexia.inventario.entity.ProveedorEntity;
import com.invexia.inventario.repository.ProveedorRepository;
import com.invexia.inventario.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorEntity> listar() {
        return proveedorRepository.findAll();
    }

    @Override
    public ProveedorEntity obtenerPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public ProveedorEntity crear(ProveedorEntity proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public ProveedorEntity actualizar(Long id, ProveedorEntity proveedor) {
        return proveedorRepository.findById(id)
                .map(p -> {
                    p.setNombre(proveedor.getNombre());
                    p.setContacto(proveedor.getContacto());
                    p.setTelefono(proveedor.getTelefono());
                    p.setCorreo(proveedor.getCorreo());
                    return proveedorRepository.save(p);
                })
                .orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }
}
