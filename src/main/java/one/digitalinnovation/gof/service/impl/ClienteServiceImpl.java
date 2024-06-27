package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.exceptions.ClienteNotFoundException;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.repositories.ClienteRepository;
import one.digitalinnovation.gof.repositories.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new ClienteNotFoundException();
        }
        return cliente.get();
    }

    @Override
    public void create(Cliente cliente) {
        // VERIFICA SE O ENDEREÇO DO CLIENTE JÁ EXISTE (ATRAVES DO CEP)
        saveClienteWithCep(cliente);
    }

    @Override
    public void update(Long id, Cliente cliente) {
        Optional<Cliente> clie = clienteRepository.findById(id);
        if (clie.isEmpty()) {
            throw new ClienteNotFoundException();
        }
        saveClienteWithCep(cliente);
    }


    @Override
    public void delete(Long id) {
        Optional<Cliente> clie = clienteRepository.findById(id);
        if (clie.isEmpty()) {
            throw new ClienteNotFoundException();
        }
        clienteRepository.deleteById(id);

    }

    private void saveClienteWithCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco =
                enderecoRepository.findById(cep).
                        orElseGet(() -> {
                            Endereco novoEndereco = viaCepService.consultCep(cep);
                            enderecoRepository.save(novoEndereco);
                            return novoEndereco;
                        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
