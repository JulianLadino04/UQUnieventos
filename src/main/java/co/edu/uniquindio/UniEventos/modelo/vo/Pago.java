package co.edu.uniquindio.UniEventos.modelo.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Pago {

    private String moneda;
    private String tipoPago;
    private String detalleEstado;
    private String codigoAutorizacion;
    private LocalDateTime fecha;
    private String id;
    private float valorTransaccion;
    private String estado;
}
