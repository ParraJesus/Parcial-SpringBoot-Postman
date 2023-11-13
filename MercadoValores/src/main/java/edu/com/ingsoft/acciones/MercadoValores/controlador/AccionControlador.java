package edu.com.ingsoft.acciones.MercadoValores.controlador;


import edu.com.ingsoft.acciones.MercadoValores.servicio.IAccionServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import edu.com.ingsoft.acciones.MercadoValores.modelo.Accion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class AccionControlador {

    @Autowired
    private IAccionServicio servicio;

    @PostMapping({"/accion/guardar"})
    public ResponseEntity<Accion> guardar(@Valid @RequestBody Accion a){
        return  new ResponseEntity<>(servicio.guardarAccion(a), HttpStatus.CREATED);
    }

    @GetMapping({"accion/obtener"})
    public ResponseEntity<List<Accion>> obtenerAcciones (){
        return new ResponseEntity<>(servicio.obtenerAcciones(),HttpStatus.FOUND);
    }

    @GetMapping({"accion/obtenerPrecios"})
    public ResponseEntity<HashMap<String,Double>> obtenerPrecios(){
        return new ResponseEntity<>(servicio.obtenerPreciosAcciones(),HttpStatus.FOUND);
    }

    @GetMapping({"accion/obtenerPrecio/{id}"})
    public ResponseEntity<String> obtenerPrecio(@Valid @PathVariable(name = "id") Long id){
        return new ResponseEntity<>(servicio.obtenerValorActualAccion(id),HttpStatus.OK);
    }

    @GetMapping({"accion/obtener/{id}"})
    public ResponseEntity<Accion> obtenerAccion(@Valid @PathVariable(name = "id") Long id){
        return new ResponseEntity<>(servicio.obtenerAccionPorId(id),HttpStatus.FOUND);
    }


    @PutMapping({"accion/actualizar/{id}"})
    public ResponseEntity<Accion> actualizar(@Valid @RequestBody Accion upA ,
                                             @Valid @PathVariable(name = "id") Long id ){
        return ResponseEntity.ok(servicio.actualizarAccion(id,upA));
    }

    @PutMapping({"accion/actualizarPrecio/{id}"})
    public ResponseEntity<Accion> actualizarPrecio(@Valid @RequestParam double precio ,
                                                   @Valid @PathVariable(name = "id") Long id ){
        return ResponseEntity.ok(servicio.cambiarPrecioAccion(id, precio));
    }
    @DeleteMapping({"accion/borrar/{id}"})
    public ResponseEntity<String> borrar(@Valid @PathVariable(name = "id") Long id){
        servicio.removerAccion(id);
        return new ResponseEntity<>("ACCION " + id + " ELIMINADA" ,HttpStatus.OK);
    }


}
