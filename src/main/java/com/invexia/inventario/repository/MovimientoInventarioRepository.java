package com.invexia.inventario.repository;

import com.invexia.inventario.entity.MovimientoInventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventarioEntity, Long> {
}
