package com.appback.backapp.service;

import com.appback.backapp.model.Producto;
import com.appback.backapp.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoService {
    @Autowired
    private ProductoRepositorio repositorio;


    //metodo para crear
    public Producto guardar (Producto producto){
        return repositorio.save(producto);
    }

    //listar
    public List<Producto> productoList(){
        return repositorio.findAll();
    }

    //listarUnoSolo
    public Optional<Producto> listarOptional(Long id_producto){
        return repositorio.findById(id_producto);
    }

    //metodo para editar
    public Producto editar(Producto producto, Long id_producto){
        Producto producto1 = repositorio.findById(id_producto).orElse(null);
        if(producto1 !=null){
            producto1.setNombreproducto(producto.getNombreproducto());
            producto1.setDetalleproducto(producto.getDetalleproducto());
            producto1.setPrecioproducto(producto.getPrecioproducto());
            return repositorio.save(producto1);
        }else {
            return null;
        }
    }
}
