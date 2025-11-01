package com.invexia.inventario.service;

import com.invexia.inventario.entity.ClienteEntity;
import java.util.List;

public interface ClienteService {
    List<ClienteEntity> listarClientes();
    ClienteEntity guardarCliente(ClienteEntity cliente);
    ClienteEntity obtenerClientePorId(Long id);
    void eliminarCliente(Long id);
}
