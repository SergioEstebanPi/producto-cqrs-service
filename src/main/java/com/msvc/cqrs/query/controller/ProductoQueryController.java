package com.msvc.cqrs.query.controller;

import com.msvc.cqrs.command.model.ProductoRestModel;
import com.msvc.cqrs.query.queries.GetProductoQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductoRestModel> listarProductos(){
        GetProductoQuery getProductoQuery = new GetProductoQuery();
        List<ProductoRestModel> productoRestModels =
                queryGateway.query(getProductoQuery,
                        ResponseTypes.multipleInstancesOf(ProductoRestModel.class))
                        .join(); // llama al projection
        return productoRestModels;
    }
}
