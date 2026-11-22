package cl.duoc.mpazpro_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "actividades")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estudianteNombre;
    private String asignatura;
    private int puntaje;
    private boolean completada;
    private String fechaHora;

    public Actividad() {
    }

    @PrePersist
    public void asignarFechaHora() {
        if (this.fechaHora == null || this.fechaHora.isEmpty()) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            this.fechaHora = LocalDateTime.now().format(formato);
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEstudianteNombre() { return estudianteNombre; }
    public void setEstudianteNombre(String estudianteNombre) { this.estudianteNombre = estudianteNombre; }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    public int getPuntaje() { return puntaje; }
    public void setPuntaje(int puntaje) { this.puntaje = puntaje; }

    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }

    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }
}