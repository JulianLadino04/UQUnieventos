package co.edu.uniquindio.UniEventos.controller;

import co.edu.uniquindio.UniEventos.dto.CuentaDTOs.*;
import co.edu.uniquindio.UniEventos.dto.TokenDTOs.MensajeDTO;
import co.edu.uniquindio.UniEventos.dto.TokenDTOs.TokenDTO;
import co.edu.uniquindio.UniEventos.servicios.interfaces.CuentaServicio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/cuenta")
@SecurityRequirement(name = "bearerAuth")
public class CuentaController {

    private final CuentaServicio cuentaServicio;

    @PostMapping("/crear-cuenta")
    public ResponseEntity<MensajeDTO<String>> crearCuenta(@Valid @RequestBody CrearCuentaDTO cuenta) throws Exception{
        cuentaServicio.crearCuenta(cuenta);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta creada exitosamente, se envio un codigo de activación de la cuenta a su correo registrado"));
    }

    @PostMapping("/activar-cuenta")
    public ResponseEntity<MensajeDTO<String>> activarCuenta(@Valid @RequestBody ValidarCuentaDTO cuenta) throws Exception{
        cuentaServicio.activarCuenta(cuenta);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta activada exitosamente"));
    }

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> editarCuenta(@Valid @RequestBody EditarCuentaDTO cuenta) throws Exception{
        cuentaServicio.editarCuenta(cuenta);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta editada exitosamente"));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable String id) throws Exception{
        cuentaServicio.eliminarCuenta(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, "Cuenta eliminada exitosamente"));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<MensajeDTO<InformacionCuentaDTO>> obtenerInformacionCuenta(@PathVariable String id) throws Exception{
        InformacionCuentaDTO info = cuentaServicio.obtenerInformacionCuenta(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, info));
    }

    @PostMapping("/enviar-codigo-recuperacion")
    public String enviarCodigoRecuperacionPassword(@RequestParam String correo) throws Exception {
        return cuentaServicio.enviarCodigoRecuperacionPassword(correo);
    }

    @PostMapping("/cambiar-password")
    public String cambiarPassword(@RequestBody CambiarPasswordDTO cambiarPasswordDTO) throws Exception {
        return cuentaServicio.cambiarPassword(cambiarPasswordDTO);
    }

    @PostMapping("/iniciar-sesion")
    public TokenDTO iniciarSesion(@RequestBody LoginDTO loginDTO) throws Exception {
        return cuentaServicio.iniciarSesion(loginDTO);
    }

    @PostMapping("/encriptar-password")
    public String encriptarPassword(@RequestParam String password) throws Exception {
        return cuentaServicio.encriptarPassword(password);
    }

    @GetMapping("/listar-todo")
    public ResponseEntity<MensajeDTO<List<ItemCuentaDTO>>> listarCuentas() throws Exception {
        List<ItemCuentaDTO> lista = cuentaServicio.listarCuentas();
        return ResponseEntity.ok(new MensajeDTO<>(false, lista));
    }

}
