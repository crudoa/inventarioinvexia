package com.invexia.inventario.service.impl;

import com.invexia.inventario.entity.ClienteEntity;
import com.invexia.inventario.repository.ClienteRepository;
import com.invexia.inventario.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity guardarCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteEntity obtenerClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
