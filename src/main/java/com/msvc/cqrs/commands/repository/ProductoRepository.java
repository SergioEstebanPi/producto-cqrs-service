package com.msvc.cqrs.commands.repository;

import com.msvc.cqrs.commands.data.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, String> {
}
