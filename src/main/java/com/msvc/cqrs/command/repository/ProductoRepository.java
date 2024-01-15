package com.msvc.cqrs.command.repository;

import com.msvc.cqrs.command.data.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, String> {
}
