package cl.duoc.mpazpro_backend.repository;

import cl.duoc.mpazpro_backend.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    List<Actividad> findAllByOrderByIdDesc();
}