package mx.edu.utez.pokemon.controller.entrenador;

import mx.edu.utez.pokemon.controller.entrenador.dto.EntrenadorDto;
import mx.edu.utez.pokemon.controller.pokemon.dto.PokemonDto;
import mx.edu.utez.pokemon.models.entrenador.Entrenador;
import mx.edu.utez.pokemon.models.pokemon.Pokemon;
import mx.edu.utez.pokemon.services.entrenador.EntrenadorService;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenador")
@CrossOrigin(origins = {"*"})
public class EntrenadorController {

//    http://localhost:8080/api/entrenador/

    @Autowired
    private EntrenadorService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Entrenador>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Entrenador>> getOne(
            @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<Response<Entrenador>> insert(@RequestBody EntrenadorDto entrenador) {//castea de datos a un obj categoria
        return new ResponseEntity<>(
                this.service.insert(entrenador.getEntrenador()), HttpStatus.CREATED
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<Entrenador>> update(@RequestBody EntrenadorDto entrenador) {
        return new ResponseEntity<>(
                this.service.update(entrenador.getEntrenador()), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Entrenador>> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(
                this.service.delete(id), HttpStatus.OK
        );
    }
}

