package com.msvc.cqrs.repository;

import com.msvc.cqrs.data.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, String> {
}
