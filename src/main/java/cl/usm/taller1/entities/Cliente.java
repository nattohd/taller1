package cl.usm.taller1.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("clientes")
@Setter
@Getter
@ToString
public class Cliente {
    @MongoId
    private String id;
    private String nombre;
    private String apellidos;
    private String rut;
    private int numSerie;
    private String estado;
}
