package com.msvc.cqrs.query.projection;

import com.msvc.cqrs.command.data.Producto;
import com.msvc.cqrs.command.model.ProductoRestModel;
import com.msvc.cqrs.command.repository.ProductoRepository;
import com.msvc.cqrs.query.queries.GetProductoQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductoProjection {

    @Autowired
    private ProductoRepository productoRepository;

    @QueryHandler
    public List<ProductoRestModel> handle(GetProductoQuery getProductoQuery){
        List<Producto> productos = productoRepository.findAll();
        List<ProductoRestModel> productoRestModels = productos.stream()
                .map(producto -> ProductoRestModel.builder()
                        .nombre(producto.getNombre())
                        .cantidad(producto.getCantidad())
                        .precio(producto.getPrecio())
                        .build()
                ).collect(Collectors.toList());
        return productoRestModels;
    }
}
