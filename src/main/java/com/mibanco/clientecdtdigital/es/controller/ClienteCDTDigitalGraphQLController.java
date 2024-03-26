package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.constant.Constant;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigitalGraphQL;
import com.mibanco.clientecdtdigital.es.gen.contract.V1UsuarioApi;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.service.impl.ClienteCDTDigitalGraphQLImpl;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@GraphQLApi
public class ClienteCDTDigitalGraphQLController{
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalGraphQLController.class);
    @Inject
    ClienteCDTDigitalGraphQLImpl clienteCDTDigitalGraphQLImpl;

    @Query("allCliente")
    public List<ClienteCDTDigitalGraphQL> obtenerTodosLosClienteCDTDigitalGraphQl(){
        LOG.info("Inicia el proceso de obtenerTodosLosClienteCDTDigitalGraphQl Controller");
        List<ClienteCDTDigitalGraphQL> allClient = null;
        try{
            allClient = clienteCDTDigitalGraphQLImpl.obtenerTodosLosClienteCDTDigitalImpl();
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de obtenerTodosLosClienteCDTDigitalGraphQl Controller: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de obtenerTodosLosClienteCDTDigitalGraphQl Controller");
        return allClient;
    }
    @Mutation("crearClienteCDTDigital")
    public ClienteCDTDigitalGraphQL crearClienteCDTDigitalGraphQl(@Name("crear") ClienteCDTDigitalGraphQL clienteCDTDigitalType){
        LOG.info("Inicia el proceso de crearClienteCDTDigitalGraphQl Impl");
        ClienteCDTDigitalGraphQL clienteCDTDigitalGraphQL = null;
        try{
            clienteCDTDigitalGraphQL = clienteCDTDigitalGraphQLImpl.crearClienteCDTDigitalImpl(clienteCDTDigitalType);
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de crearClienteCDTDigitalGraphQl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de crearClienteCDTDigitalGraphQl Impl");
        return clienteCDTDigitalGraphQL;
    }

    @Mutation("eliminarCliente")
    public void  eliminarClienteCDTDigitalGraphQl(@Name("id") Integer id){
        LOG.info("Inicia el proceso de crearClienteCDTDigitalGraphQl Impl");
        try{
            clienteCDTDigitalGraphQLImpl.eliminarClienteCDTDigitalImpl(id.longValue());
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de crearClienteCDTDigitalGraphQl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de crearClienteCDTDigitalGraphQl Impl");
    }
}
