package com.mibanco.clientecdtdigital.es.service.impl;

import com.mibanco.clientecdtdigital.es.constant.Constant;
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
        LOG.info("Inicia el proceso de obtener Cliente CDT Digital graphQL Impl");
        List<ClienteCDTDigitalGraphQL> allClient = null;
        try{
            allClient = clienteCDTDigitalGraphQLDao.listAll();
        }catch(ApplicationException e){
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + " obtener Cliente CDT Digital graphQL Impl");
        }
        LOG.info("Finaliza el proceso de  obtener Cliente CDT Digital graphQL Impl");
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
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + " crear Cliente CDT Digital graphQL Impl");
        }
        LOG.info("Finaliza el proceso de  crear Cliente CDT Digital graphQL Impl");
        return clienteCDTDigitalGraphQL;
    }

    @Transactional
    public void eliminarClienteCDTDigitalImpl(Long id){
        LOG.info("Inicia el proceso de  eliminar Cliente CDT Digital graphQL Impl");
        try{
            clienteCDTDigitalGraphQLDao.deleteById(id);
        }catch(ApplicationException e){
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + " eliminar Cliente CDT Digital graphQL Impl");
        }
        LOG.info("Finaliza el proceso de eliminar Cliente CDT Digital graphQL Impl");
    }

    @Transactional
    public void editarClienteCDTDigitalImpl(Long id ,ClienteCDTDigitalGraphQL clienteCDTDigitalGraphQL ){
        LOG.info("Inicia el proceso de editar Cliente CDT Digital graphQL Impl");
        try{
            ClienteCDTDigitalGraphQL clienteCDTDigitalGraphQL = clienteCDTDigitalDao.findById(id);
            cliente.setFechaNacimientoAno(clienteUpdate.getFechaNacimientoAno());
            cliente.setFechaNacimientoMes(clienteUpdate.getFechaNacimientoMes());
            cliente.setFechaNacimientoDia(clienteUpdate.getFechaNacimientoDia());
        }catch(ApplicationException e){
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "editar Cliente CDT Digital graphQL Impl");
        }
        LOG.info("Finaliza el proceso de editar Cliente CDT Digital graphQL Impl");
    }
}
