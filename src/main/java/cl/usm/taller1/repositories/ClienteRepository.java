package cl.usm.taller1.repositories;

import cl.usm.taller1.entities.Cliente;
import cl.usm.taller1.services.ClienteService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ClienteRepository extends MongoRepository<Cliente, String> {
    @Query("{estado: ?0}")
    List<Cliente> filter(String estado);
}
