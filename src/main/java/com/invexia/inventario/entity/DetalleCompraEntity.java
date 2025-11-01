package com.invexia.inventario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_compras")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private CompraEntity compra;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoEntity producto;

    private Integer cantidad;
    private Double subtotal;
}
