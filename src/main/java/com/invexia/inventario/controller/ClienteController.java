package com.invexia.inventario.controller;

import com.invexia.inventario.entity.ClienteEntity;
import com.invexia.inventario.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public List<ClienteEntity> listar() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public ClienteEntity guardar(@RequestBody ClienteEntity cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @GetMapping("/{id}")
    public ClienteEntity obtener(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}
