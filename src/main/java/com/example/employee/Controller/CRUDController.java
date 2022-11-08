package com.example.employee.Controller;

import java.util.List;
import java.util.Optional;

public interface CRUDController<E, I, D> {
    /**
     * E - параметр принимающй тип сущности,
     * I - параметр принимающий тип Id в сущности
     */
    List<E> getAllEntity();

    /**
     * Iterable<EmployeeEntity> getAllEntity(),
     * Метод отвечающий за получение всех сущностей
     * с базы данных
     */
    E getFindById(I id);

    /**
     * Optional<E> getFindById(I id),
     * Метод отвечающий за получение сущности по Id,
     * возвращает объект типа Optional<E>, где E - тип сущности,
     * в качестве парметра I принимает тип Id.
     */
    void postEntity(D d);

    /**
     *  void postEntity(E entity),
     *  Метод отвечающий за добавление новой сущности в базу данных,
     *  в качестве параметра E принимается тип сущности.
     */
    void putEntity(I id, D d);

    /**
     * void putEntity(I id, E entity),
     * Метод отвечающий за изменение уже существующей сущности в базе данных,
     * в качестве параметра I принимается тип Id сущности,
     * в качестве параметра E принимается тип сущности которую мы хотим изменить.
     */
    void deleteEntity(I id);

    /**
     * void deleteEntity(I id),
     * Метод отвечающий за удаление сущности из базы данных,
     * в качестве параметра I принимает типа Id сущности которую необходимо удалить.
     */

}
