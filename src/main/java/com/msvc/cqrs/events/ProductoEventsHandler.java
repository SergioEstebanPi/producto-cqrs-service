package com.msvc.cqrs.events;

import com.msvc.cqrs.data.Producto;
import com.msvc.cqrs.repository.ProductoRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoEventsHandler {

    @Autowired
    private ProductoRepository productoRepository;

    @EventHandler
    public void on(ProductoCreatedEvent productoCreatedEvent){
        Producto producto = new Producto();
        BeanUtils.copyProperties(productoCreatedEvent, producto);
        productoRepository.save(producto);
    }
}
