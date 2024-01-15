package com.msvc.cqrs.command.controller;

import com.msvc.cqrs.command.commands.CreateProductoCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.msvc.cqrs.command.model.ProductoRestModel;

import java.util.UUID;

@RestController
@RequestMapping("/productos")
public class ProductoCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String guardarProducto(@RequestBody ProductoRestModel productoRestModel){
        CreateProductoCommand createProductoCommand =
                CreateProductoCommand.builder()
                        .productoId(UUID.randomUUID().toString())
                        .nombre(productoRestModel.getNombre())
                        .precio(productoRestModel.getPrecio())
                        .cantidad(productoRestModel.getCantidad())
                        .build();
        return commandGateway.sendAndWait(createProductoCommand); // se envia al aggregate
    }
}
