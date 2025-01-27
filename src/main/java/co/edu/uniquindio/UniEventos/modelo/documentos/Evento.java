package co.edu.uniquindio.UniEventos.modelo.documentos;

import co.edu.uniquindio.UniEventos.modelo.enums.EstadoEvento;
import co.edu.uniquindio.UniEventos.modelo.vo.Localidad;
import co.edu.uniquindio.UniEventos.modelo.enums.TipoEvento;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("eventos")
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private String nombre, direccion, ciudad, descripcion;
    private TipoEvento tipo;
    private EstadoEvento estado;
    private String imagenPortada;
    private LocalDateTime fecha;
    private List<Localidad> localidades;
    private String imagenLocalidades;


    public Localidad obtenerLocalidad(String nombreLocalidad) {
        if (localidades != null) {
            for (Localidad localidad : localidades) {
                if (localidad.getNombreLocalidad().equalsIgnoreCase(nombreLocalidad)) {
                    return localidad;
                }
            }
        }
        return null;
    }
}
