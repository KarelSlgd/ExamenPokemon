package mx.edu.utez.pokemon.controller.pokemon;

import mx.edu.utez.pokemon.controller.pokemon.dto.PokemonDto;
import mx.edu.utez.pokemon.models.pokemon.Pokemon;
import mx.edu.utez.pokemon.services.pokemon.PokemonService;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {
////    http://localhost:8080/api/pokemon/
    @Autowired
    private PokemonService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Pokemon>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> getOne(
            @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<Response<Pokemon>> insert(@RequestBody PokemonDto pokemon) {//castea de datos a un obj categoria
        return new ResponseEntity<>(
                this.service.insert(pokemon.getPokemon()), HttpStatus.CREATED
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<Pokemon>> update(@RequestBody PokemonDto pokemon) {
        return new ResponseEntity<>(
                this.service.update(pokemon.getPokemon()), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(
                this.service.delete(id), HttpStatus.OK
        );
    }





































}
/*
@RestController
@RequestMapping("/api-market/category")
@CrossOrigin(origins = {"*"})
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Category>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Category>> getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<Response<Category>> insert(@RequestBody CategoryDto category) {//castea de datos a un obj categoria
        return new ResponseEntity<>(
                this.service.insert(category.getCategory()), HttpStatus.CREATED
        );
    }

    http://localhost:8080/api-market/category/
    {
    "name":"Limpieza",
    "status": true
    }


    @PutMapping("/")
    public ResponseEntity<Response<Category>> update(@RequestBody CategoryDto category) {
        return new ResponseEntity<>(
                this.service.update(category.getCategory()), HttpStatus.OK
        );
    }

        {
    "id": 1,
    "name": "Belleza",
    "status": true
    }

 */
/*

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Category>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(
                this.service.delete(id), HttpStatus.OK
        );
    }

    http://localhost:8080/api-market/category/1

 */