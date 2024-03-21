package com.appback.backapp.controller;

import com.appback.backapp.model.Producto;
import com.appback.backapp.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {

    @Autowired
    private ProductoService productoService;

    //guardar
    @PostMapping("/guardar")
    public Producto insertar(Producto producto){
        return productoService.guardar(producto);
    }

    @PutMapping("/editar")
    public Producto edit(Producto producto, Long id_producto){
        return productoService.editar(producto,id_producto);
    }
    @GetMapping("listar")
    public List<Producto> listarproductos(){
        return productoService.productoList();
    }
    @DeleteMapping("/eliminar")
    public void
}
