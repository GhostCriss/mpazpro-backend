package cl.duoc.mpazpro_backend.controller;

import cl.duoc.mpazpro_backend.model.Actividad;
import cl.duoc.mpazpro_backend.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
@CrossOrigin(origins = "*")
public class ActividadController {

    @Autowired
    private ActividadRepository repository;

    // 1. LISTAR TODAS (Más recientes primero)
    @GetMapping
    public List<Actividad> obtenerTodas() {
        return repository.findAllByOrderByIdDesc();
    }

    // 2. CREAR NUEVA ACTIVIDAD (POST)
    @PostMapping
    public Actividad crearActividad(@RequestBody Actividad actividad) {
        return repository.save(actividad);
    }

    // 3. ACTUALIZAR ACTIVIDAD (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Actividad> actualizarActividad(@PathVariable Long id, @RequestBody Actividad datosNuevos) {
        return repository.findById(id)
                .map(actividad -> {
                    actividad.setEstudianteNombre(datosNuevos.getEstudianteNombre());
                    actividad.setAsignatura(datosNuevos.getAsignatura());
                    actividad.setPuntaje(datosNuevos.getPuntaje());
                    actividad.setCompletada(datosNuevos.isCompletada());
                    return ResponseEntity.ok(repository.save(actividad));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. ELIMINAR ACTIVIDAD (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarActividad(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}