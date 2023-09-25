package cl.usm.taller1.repositories;

import cl.usm.taller1.entities.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ClienteRepository extends MongoRepository<Cliente, String> {


}
