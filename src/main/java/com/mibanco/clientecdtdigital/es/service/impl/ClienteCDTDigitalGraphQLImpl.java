package com.mibanco.clientecdtdigital.es.service.impl;

import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalGraphQLDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigitalGraphQL;
import com.mibanco.clientecdtdigital.es.service.contract.IClienteCDTDigitalGraphQL;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import com.mibanco.clientecdtdigital.es.utils.mapper.ClienteCDTDigitalGraphQLMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class ClienteCDTDigitalGraphQLImpl implements IClienteCDTDigitalGraphQL {
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalGraphQLImpl.class);
    @Inject
    ClienteCDTDigitalGraphQLMapper clienteCDTDigitalGraphQLMapper;
    @Inject
    ClienteCDTDigitalGraphQLDao clienteCDTDigitalGraphQLDao;

    public List<ClienteCDTDigitalGraphQL> obtenerTodosLosClienteCDTDigitalImpl(){
        LOG.info("Inicia el proceso de obtenerTodosLosClienteCDTDigitalImpl Impl");
        List<ClienteCDTDigitalGraphQL> allClient = null;
        try{
            allClient = clienteCDTDigitalGraphQLDao.listAll();
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de obtenerTodosLosClienteCDTDigitalImpl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de obtenerTodosLosClienteCDTDigitalImpl Impl");
        return allClient;
    }

    @Transactional
    public ClienteCDTDigitalGraphQL crearClienteCDTDigitalImpl(ClienteCDTDigitalGraphQL clienteCDTDigitalGraphQLType){
        LOG.info("Inicia el proceso de crearClienteCDTDigitalImpl Impl");
        ClienteCDTDigitalGraphQL clienteCDTDigitalGraphQL = null;
        try{
            clienteCDTDigitalGraphQL = clienteCDTDigitalGraphQLMapper.clienteCDTDigitalTypeToEntity(clienteCDTDigitalGraphQLType);
            clienteCDTDigitalGraphQLDao.persist(clienteCDTDigitalGraphQL);
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de crearClienteCDTDigitalImpl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de crearClienteCDTDigitalImpl Impl");
        return clienteCDTDigitalGraphQL;
    }

    @Transactional
    public void eliminarClienteCDTDigitalImpl(Long id){
        LOG.info("Inicia el proceso de crearClienteCDTDigitalImpl Impl");
        try{
            clienteCDTDigitalGraphQLDao.deleteById(id);
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de crearClienteCDTDigitalImpl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de crearClienteCDTDigitalImpl Impl");
    }
}
