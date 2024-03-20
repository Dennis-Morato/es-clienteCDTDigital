package com.mibanco.clientecdtdigital.es.gen.contract;

import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


@Path("/v1/es/crearClienteCdtDigital")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-19T22:00:21.489818500-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public interface V1UsuarioApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearClienteCdtDigital(@Valid ClienteCDTDigitalType clienteCDTDigitalType);
}