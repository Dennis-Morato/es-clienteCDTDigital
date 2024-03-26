package com.mibanco.clientecdtdigital.es.gen.contract;

import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-25T22:59:14.733812600-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public interface V1UsuarioApi {

    @GET
    @Path("/buscarClienteCDTDigital/{id_cliente}")
    @Produces({ "application/json" })
    Response buscarClienteCDTDigital(@PathParam("id_cliente") @Min(1) Integer idCliente);

    @POST
    @Path("/crearClienteCDTDigital")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearClienteCDTDigital(@Valid ClienteCDTDigitalType clienteCDTDigitalType);

    @PUT
    @Path("/editarClienteCDTDigital/{id_cliente}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response editarClienteCDTDigital(@PathParam("id_cliente") @Min(1) Integer idCliente,@Valid ClienteCDTDigitalType clienteCDTDigitalType);

    @DELETE
    @Path("/eliminarClienteCDTDigital/{id_cliente}")
    Response eliminarClienteCDTDigital(@PathParam("id_cliente") @Min(1) Integer idCliente);

    @GET
    @Path("/listarTodosLosClientesCDTDigital")
    @Produces({ "application/json" })
    Response listarTodosLosClientesCDTDigital();
}
