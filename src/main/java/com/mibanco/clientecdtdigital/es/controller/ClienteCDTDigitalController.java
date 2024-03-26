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

import java.util.List;

public class ClienteCDTDigitalController implements V1UsuarioApi {
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalController.class);
    @Inject
    ClienteCDTDigitalImpl clienteCDTDigitalImpl;

    @Override
    public Response crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia proceso de crear cliente CDT digital controller");
        ClienteCDTDigitalType clienteCDTDigitalTypeResponse = null;
        try {
            clienteCDTDigitalTypeResponse = clienteCDTDigitalImpl.crearClienteCDTDigital(clienteCDTDigitalType);
        }catch (ApplicationException e){
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "crear cliente CDT digital controller");
            return Response.status(Response.Status.BAD_REQUEST).entity(clienteCDTDigitalType).build();
        }
        LOG.info("Finaliza proceso de crear cliente CDT digital controller");
        return Response.status(Response.Status.CREATED).entity(clienteCDTDigitalTypeResponse).build();
    }

    @Override
    public Response editarClienteCDTDigital(Integer idClienteCDT, ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia proceso de editar cliente CDT digital controller");
        ClienteCDTDigitalType clienteCDTDigitalTypeResponse = null;
        try {
            clienteCDTDigitalTypeResponse = clienteCDTDigitalImpl.editarClienteCDTDigital(idClienteCDT , clienteCDTDigitalType);
        }catch (ApplicationException e){
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "editar cliente CDT digital controller");
            return Response.status(Response.Status.BAD_REQUEST).entity(clienteCDTDigitalType).build();
        }
        LOG.info("Finaliza proceso de editar  cliente CDT digital controller");
        return Response.status(Response.Status.OK).entity(clienteCDTDigitalTypeResponse).build();
    }

    @Override
    public Response eliminarClienteCDTDigital(Integer idClienteCDT) {
        LOG.info("Inicia proceso de eliminar cliente CDT digital controller");
        try {
          clienteCDTDigitalImpl.eliminarClienteCDTDigital(idClienteCDT);
        }catch (ApplicationException e){
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "eliminar cliente CDT digital controller");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza proceso de eliminar cliente CDT digital controller");
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public Response buscarClienteCDTDigital(Integer idClienteCDT) {
        LOG.info("Inicia el metodo buscar cliente CDT por id Controller");
        ClienteCDTDigitalType clienteCDTDigitalTypeResponse ;
        try{
            clienteCDTDigitalTypeResponse = clienteCDTDigitalImpl.buscarClienteCDTDigitalID(idClienteCDT);
        }catch(ApplicationException e){
            LOG.error(Constant.ERROR_SERVICIO +  e.getMessage() + "buscar cliente CDT digital controller");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza el metodo buscar cliente CDT digital Controller");
        return Response.status(Response.Status.OK).entity(clienteCDTDigitalTypeResponse).build();
    }

    public Response listarTodosLosClientesCDTDigital(){
        LOG.info("Inicia proceso de listar todos los clientes CDT Digitals Controller");
        List<ClienteCDTDigitalType> clienteCDTDigitalTypeList = null;
        try{
            clienteCDTDigitalTypeList = clienteCDTDigitalImpl.listarTodosLosClientesCDTDigital();
        }catch (ApplicationException e){
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "Listar todos los clientes CDT digital Controller");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza el metodo listarTodosLosUsuario Controller");
        return Response.status(Response.Status.OK).entity(clienteCDTDigitalTypeList).build();
    }


}
