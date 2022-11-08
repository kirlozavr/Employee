package com.example.employee.Mapper;

public interface DTOMapper<E, D> {
    /**
     * E - параметр принимающий тип Entity сущности,
     * D - параметр принимающий типа DTO сущности
     * **/
    D getEntityToDTO(E e);

    /**
     * D getEntityToDTO(E e),
     * Преобразует нашу сущность в DTO
     */
    E getDTOToEntity(D d);

    /**
     * E getDTOTOEntity(D d)
     * Преобразует наш DTO в сущность
     */

}
