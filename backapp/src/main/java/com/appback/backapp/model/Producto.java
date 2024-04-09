package com.appback.backapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.File;


@Entity
@Table(name = "tb_productos")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    private String nombreproducto;
    private Double precioproducto;
    private String detalleproducto;
    private Double ivaproducto;
    private Double preciototal;
    private File imagenproducto;


}
