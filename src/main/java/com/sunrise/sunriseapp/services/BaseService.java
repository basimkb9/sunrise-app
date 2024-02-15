package com.sunrise.sunriseapp.services;

import java.util.List;

public abstract class BaseService<DTO,MODEL>{
    public abstract DTO insert(DTO dto);
    public abstract DTO update(DTO dto, Long id);
    public abstract String delete(Long id);
    public abstract DTO getById(Long id);
    public abstract List<DTO> getAll();
    public abstract DTO toDto(MODEL model);
    public abstract MODEL toModel(DTO dto);
}
