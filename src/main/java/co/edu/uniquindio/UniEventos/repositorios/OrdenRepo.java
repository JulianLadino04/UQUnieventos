package co.edu.uniquindio.UniEventos.repositorios;

import co.edu.uniquindio.UniEventos.modelo.documentos.Orden;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdenRepo extends MongoRepository<Orden, String> {

    // Buscar una orden por su ID
    @Query("{ ordenId : ?0 }") // Cambiado de 'id' a 'ordenId'
    Optional<Orden> buscarOrdenPorId(String ordenId);

    // Buscar una orden por su ID
    @Query("{ _id : ?0 }") // Cambiado de 'id' a 'ordenId'
    Optional<Orden> buscarOrdenPorObjectId(ObjectId ordenId);

    @Query("{ _id : ?0 }") // Cambiado de 'id' a 'ordenId'
    Optional<Orden> buscarOrdenPorObjectId(String ordenId);

    // Buscar todas las órdenes asociadas a un cliente específico
    @Query("{ idCliente : ?0 }")
    List<Orden> findByIdCliente(ObjectId idCliente);

    @Query("{ idCliente : ?0 }")
    List<Orden> findByIdCliente(String idCliente);
}

