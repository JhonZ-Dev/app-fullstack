package com.appback.backapp.controller;

import com.appback.backapp.model.Producto;
import com.appback.backapp.model.RespuestaPersonalizada;
import com.appback.backapp.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*")
public class ProductoControlador {

    @Autowired
    private ProductoService productoService;

    //guardar
    @PostMapping("/guardar")
    public Producto insertar(@RequestBody Producto producto){
        return productoService.guardar(producto);
    }

    @PutMapping("/editar/{id_producto}")
    public Producto edit(@RequestBody Producto producto, @PathVariable Long id_producto){
        return productoService.editar(producto,id_producto);
    }
    @GetMapping("listar")
    public List<Producto> listarproductos(){
        return productoService.productoList();
    }
    @DeleteMapping("/eliminar/{id_producto}")
    public RespuestaPersonalizada delete(@PathVariable Long id_producto){
        return productoService.eliminar(id_producto);
    }
}
