package cl.usm.taller1.services;

import ch.qos.logback.core.net.server.Client;
import cl.usm.taller1.entities.Cliente;
import cl.usm.taller1.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements  ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> filter(String estado) {
        return null;
    }
}
