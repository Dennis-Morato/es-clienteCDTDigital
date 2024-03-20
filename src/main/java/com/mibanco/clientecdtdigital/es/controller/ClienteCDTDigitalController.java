package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.constant.Constant;
import com.mibanco.clientecdtdigital.es.gen.contract.V1UsuarioApi;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.service.impl.ClienteCDTDigitalImpl;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClienteCDTDigitalController implements V1UsuarioApi {
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalController.class);
    @Inject
    ClienteCDTDigitalImpl clienteCDTDigitalImpl;
    @Override
    public Response crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia proceso de crear cliente CDT digital controller");
        ClienteCDTDigitalType clienteCDTDigitalTypeResponce = null;
        try {
            clienteCDTDigitalTypeResponce = clienteCDTDigitalImpl.crearClienteCdtDigital(clienteCDTDigitalType);
        }catch (ApplicationException e){
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "crear cliente CDT digital controller");
            return Response.status(Response.Status.BAD_REQUEST).entity(clienteCDTDigitalType).build();
        }
        LOG.info("Finaliza proceso de crear cliente CDT digital controller");
        return Response.status(Response.Status.CREATED).entity(clienteCDTDigitalTypeResponce).build();
    }
}
