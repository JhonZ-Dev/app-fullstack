package com.appback.backapp.service;

import com.appback.backapp.model.Producto;
import com.appback.backapp.model.RespuestaPersonalizada;
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
    public Producto editar(Producto producto, Long id_producto) {
        try {
            Optional<Producto> productoOptional = repositorio.findById(id_producto);
            if (productoOptional.isPresent()) {
                Producto producto1 = productoOptional.get();
                producto1.setNombreproducto(producto.getNombreproducto());
                producto1.setDetalleproducto(producto.getDetalleproducto());
                producto1.setPrecioproducto(producto.getPrecioproducto());
                return repositorio.save(producto1);
            } else {
                throw new Exception("El producto no se encontró en el repositorio.");

            }
        } catch (Exception e) {
            // Manejar la excepción de acuerdo a tus necesidades.
            e.printStackTrace();
            return null;

        }
    }


   /* public void eliminar(Long id_producto){
        repositorio.deleteById(id_producto);
    }*/
    public RespuestaPersonalizada eliminar(Long id_producto) {
        try {
            repositorio.deleteById(id_producto);
            return new RespuestaPersonalizada(true, "Producto eliminado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaPersonalizada(false, "Se produjo un error al intentar eliminar el producto.");
        }
    }
}
