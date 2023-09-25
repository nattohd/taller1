package cl.usm.taller1.services;

import cl.usm.taller1.entities.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente create(Cliente cLiente);
    List<Cliente> getAll();
    List<Cliente> filter(String estado);

}
