package io.slimmens.entregafinal.services.impl;

import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.domain.entities.Producto;
import io.slimmens.entregafinal.domain.repositories.ClientesRepository;
import io.slimmens.entregafinal.domain.repositories.ProductosRepository;
import io.slimmens.entregafinal.utils.ValidationUtils;
import java.util.Objects;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
public class ProductosServiceImpl implements io.slimmens.entregafinal.services.ProductosService {
	@Autowired
	ProductosRepository productosRepository;
	private static final int DEFAULT_PAGE_NUMBER = 0;
	private static final int DEFAULT_PAGE_SIZE = 10;

	private final ProductosRepository repository;

	public ProductosServiceImpl(ProductosRepository repository) {
		this.repository = Objects.requireNonNull(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> get(Integer id) {
		ValidationUtils.isNotNull(id, "El id no puede ser vacio.");
		
		return repository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> list(Integer pageNumber, Integer pageSize) {
		int effectivePageNumber = Optional.ofNullable(pageNumber).orElse(DEFAULT_PAGE_NUMBER);
		int effectivePageSize = Optional.ofNullable(pageSize).orElse(DEFAULT_PAGE_SIZE);
		
		return repository.findAll(PageRequest.of(effectivePageNumber, effectivePageSize));
	}

	@Override
	@Transactional
	public Producto create(String nombre, String descripcion, Double precio, Integer cantidadDisponible) {
		Producto producto = new Producto(
				ValidationUtils.isNotBlank(nombre, "El nombre no puede ser vacio."),
				ValidationUtils.isNotBlank(descripcion, "El descripcion no puede ser vacio."),
				ValidationUtils.isPositive(precio, "El precio debe ser un valor positivo."),
				ValidationUtils.isPositive(cantidadDisponible, "La cantidad disponible debe ser un valor positivo.")
		);
		
		return repository.save(producto);
	}

	@Override
	@Transactional
	public Optional<Producto> update(Integer id, String nombre, String descripcion,
									 Double precio, Integer cantidadDisponible) {
		ValidationUtils.isNotNull(id, "El id no puede ser vacio.");

		return get(id)
				.map(producto -> {
					producto.setNombre(ValidationUtils.isNotBlank(nombre, "El nombre no puede ser vacio."));
					producto.setDescripcion(ValidationUtils.isNotBlank(descripcion, "El descripcion no puede ser vacio."));
					producto.setPrecio(ValidationUtils.isPositive(precio, "El precio debe ser un valor positivo."));
					producto.setCantidadDisponible(ValidationUtils.isPositive(cantidadDisponible, "La cantidad disponible debe ser un valor positivo."));
					
					return producto;
				})
				.map(repository::save);
	}

	@Override
	@Transactional
	public Optional<Producto> delete(Integer id) {
		ValidationUtils.isNotNull(id, "El id no puede ser vacio.");

		return get(id)
				.map(producto -> {
					repository.delete(producto);
					return producto;
				});
	}

	@Override
	@Transactional
	public Optional<Producto> updateDisponibilidad(Integer id, Integer variacion) {
		ValidationUtils.isNotNull(id, "El id no puede ser vacio.");
		ValidationUtils.isNotNull(variacion, "La variaci??n no puede ser vacia.");

		return get(id)
				.map(producto -> {
					int cantidadDisponible = ValidationUtils.isPositive(
							producto.getCantidadDisponible() + variacion,
							"La variaci??n no puede dar por resultado una cantidad negativa."
					);

					producto.setCantidadDisponible(cantidadDisponible);
					return producto;
				})
				.map(repository::save);
	}
}
