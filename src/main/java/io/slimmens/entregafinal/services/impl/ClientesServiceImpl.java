package io.slimmens.entregafinal.services.impl;

import io.slimmens.entregafinal.domain.entities.Cliente;
import io.slimmens.entregafinal.domain.repositories.ClientesRepository;
import io.slimmens.entregafinal.services.ClientesService;
import io.slimmens.entregafinal.utils.ValidationUtils;
import java.util.Objects;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientesServiceImpl implements ClientesService {

	private static final int DEFAULT_PAGE_NUMBER = 0;
	private static final int DEFAULT_PAGE_SIZE = 10;

	private final ClientesRepository repository;

	public ClientesServiceImpl(ClientesRepository repository) {

		this.repository = Objects.requireNonNull(repository);
	}

	@Transactional(readOnly = true)
	public Optional<Cliente> get(Integer id) {
		ValidationUtils.isNotNull(id, "El id no puede ser vacio.");

		return repository.findById(id);
	}

	@Transactional(readOnly = true)
	public Page<Cliente> list(Integer pageNumber, Integer pageSize) {
		int effectivePageNumber = Optional.ofNullable(pageNumber).orElse(DEFAULT_PAGE_NUMBER);
		int effectivePageSize = Optional.ofNullable(pageSize).orElse(DEFAULT_PAGE_SIZE);

		return repository.findAll(PageRequest.of(effectivePageNumber, effectivePageSize));
	}

	@Transactional
	public Cliente create(String nombre, String apellido, String direccion, Integer dni) {
		Cliente cliente = new Cliente(
				ValidationUtils.isNotBlank(nombre, "El nombre no puede ser vacio."),
				ValidationUtils.isNotBlank(apellido, "El rubro no puede ser vacio."),
				ValidationUtils.isPositive(dni, "El DNI debe ser un valor positivo."),
				ValidationUtils.isNotBlank(direccion, "La direccion no puede ser vacia.")
		);

		return repository.save(cliente);
	}

	@Transactional
	public Optional<Cliente> update(Integer id, String nombre, String apellido, String direccion, Integer dni) {
		ValidationUtils.isNotNull(id, "El id no puede ser vacio.");

		return get(id)
				.map(cliente -> {
					cliente.setNombre(ValidationUtils.isNotBlank(nombre, "El nombre no puede ser vacio."));
					cliente.setApellido(ValidationUtils.isNotBlank(apellido, "El rubro no puede ser vacio."));
					cliente.setDireccion(ValidationUtils.isNotBlank(direccion, "La direccion no puede ser vacia."));
					cliente.setDni(ValidationUtils.isPositive(dni, "El DNI debe ser un valor positivo."));

					return cliente;
				})
				.map(repository::save);
	}

	@Transactional
	public Optional<Cliente> delete(Integer id) {
		ValidationUtils.isNotNull(id, "El id no puede ser vacio.");

		return get(id)
				.map(cliente -> {
					repository.delete(cliente);
					return cliente;
				});
	}
}
