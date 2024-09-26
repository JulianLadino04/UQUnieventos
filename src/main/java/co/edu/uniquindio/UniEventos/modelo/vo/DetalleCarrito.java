package co.edu.uniquindio.UniEventos.modelo.vo;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class DetalleCarrito {
    private int cantidad;
    private String nombreLocalidad;
    private ObjectId idEvento;
}