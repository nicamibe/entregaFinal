package io.slimmens.entregafinal.services.impl;

import io.slimmens.entregafinal.domain.entities.Empresa;
import io.slimmens.entregafinal.domain.repositories.EmpresasRepository;
import io.slimmens.entregafinal.utils.ValidationUtils;
import java.util.Objects;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresasServiceImpl implements io.slimmens.entregafinal.services.EmpresasService {

	private static final int DEFAULT_PAGE_NUMBER = 0;
	private static final int DEFAULT_PAGE_SIZE = 10;

	private final EmpresasRepository repository;

	public EmpresasServiceImpl(EmpresasRepository repository) {
		this.repository = Objects.requireNonNull(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empresa> get(Integer id) {
		ValidationUtils.isNotNull(id, "El id no puede ser vacio.");

		return repository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Empresa> list(Integer pageNumber, Integer pageSize) {
		int effectivePageNumber = Optional.ofNullable(pageNumber).orElse(DEFAULT_PAGE_NUMBER);
		int effectivePageSize = Optional.ofNullable(pageSize).orElse(DEFAULT_PAGE_SIZE);

		return repository.findAll(PageRequest.of(effectivePageNumber, effectivePageSize));
	}

	@Override
	@Transactional
	public Empresa create(String nombre, String rubro) {
		ValidationUtils.isNotBlank(nombre, "El nombre no puede ser vacio.");
		ValidationUtils.isNotBlank(rubro, "El rubro no puede ser vacio.");

		return repository.save(new Empresa(nombre, rubro));
	}

	@Override
	@Transactional
	public Optional<Empresa> update(Integer id, String nombre, String rubro) {
		ValidationUtils.isNotNull(id, "El id no puede ser vacio.");
		ValidationUtils.isNotBlank(nombre, "El nombre no puede ser vacio.");
		ValidationUtils.isNotBlank(rubro, "El rubro no puede ser vacio.");

		return get(id)
				.map(empresa -> {
					empresa.setNombre(nombre);
					empresa.setRubro(rubro);
					return empresa;
				})
				.map(repository::save);
	}

	@Override
	@Transactional
	public Optional<Empresa> delete(Integer id) {
		ValidationUtils.isNotNull(id, "El id no puede ser vacio.");

		return get(id)
				.map(empresa -> {
					repository.delete(empresa);
					return empresa;
				});
	}
}
