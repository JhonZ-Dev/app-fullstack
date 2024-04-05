package com.appback.backapp.service;

import com.appback.backapp.model.Producto;
import com.appback.backapp.model.RespuestaPersonalizada;
import com.appback.backapp.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProductoService {
    @Autowired
    private ProductoRepositorio repositorio;


    //metodo para crear
    public Producto guardar(Producto producto) {
        // Validar que el nombre del producto no esté vacío
        if (producto.getNombreproducto() == null || producto.getNombreproducto().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }

        // Validar que el precio del producto sea positivo
        if (producto.getPrecioproducto() == null || producto.getPrecioproducto() <= 0) {
            throw new IllegalArgumentException("El precio del producto debe ser positivo.");
        }

        // Validar que el detalle del producto no esté vacío si se proporciona
        if (producto.getDetalleproducto() != null && producto.getDetalleproducto().isEmpty()) {
            throw new IllegalArgumentException("El detalle del producto no puede estar vacío.");
        }

        // Calcular el precio total con el IVA incluido (IVA del 12%)
        double precioProductoConIVA = producto.getPrecioproducto() * (1 + producto.getIvaproducto());

        // Asignar el precio total calculado al producto
        producto.setPreciototal(precioProductoConIVA);

        // Guardar el producto actualizado en el repositorio
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

                // Si el IVA se ha cambiado, recalcula el precio total
                if (!Objects.equals(producto1.getIvaproducto(), producto.getIvaproducto())) {
                    producto1.setIvaproducto(producto.getIvaproducto());
                    double precioProductoConIVA = producto.getPrecioproducto() * (1 + producto.getIvaproducto());
                    producto1.setPreciototal(precioProductoConIVA);
                }

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
