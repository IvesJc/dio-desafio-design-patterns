package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> findAll();
    Cliente findById(Long id);
    void create(Cliente cliente);
    void update(Long id, Cliente cliente);
    void delete(Long id);


}
