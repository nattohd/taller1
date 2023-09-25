package cl.usm.taller1.controllers;

import cl.usm.taller1.entities.Cliente;
import cl.usm.taller1.repositories.ClienteRepository;
import cl.usm.taller1.services.ClienteService;
import cl.usm.taller1.utils.ClienteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @PostMapping("/ingresarCliente")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        if(!ClienteUtil.esRutValido(cliente.getRut())||!!ClienteUtil.isValidEstado(cliente.getEstado())) {
            return ResponseEntity.badRequest().build();
        }
        try{
            return ResponseEntity.ok().body(this.clienteService.create(cliente));
        }catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/mostrarClientes")
    public ResponseEntity<List<Cliente>> getAll(){
        try{
            return ResponseEntity.ok(this.clienteService.getAll());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/mostrarClientes/{estado}")
    public ResponseEntity<List<Cliente>> filter(@PathVariable String estado) {
        if (!ClienteUtil.isValidEstado(estado)) {
            return ResponseEntity.badRequest().build();
        }

        try {
            return ResponseEntity.ok(this.clienteService.filter(estado));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }




}
