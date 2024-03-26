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
public class ClienteCDTDigitalGraphQLController {
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalGraphQLController.class);
    @Inject
    ClienteCDTDigitalGraphQLImpl clienteCDTDigitalGraphQLImpl;

    @Query("allCliente")
    public List<ClienteCDTDigitalGraphQL> obtenerTodosLosClienteCDTDigitalGraphQl() {
        LOG.info("Inicia el proceso de obtener cliente CDT digital GraphQl controller");
        List<ClienteCDTDigitalGraphQL> allClient = null;
        try {
            allClient = clienteCDTDigitalGraphQLImpl.obtenerTodosLosClienteCDTDigitalImpl();
        } catch (ApplicationException e) {
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "obtener cliente CDT digital GraphQl controller");
        }
        LOG.info("Finaliza el proceso de obtener cliente CDT digital GraphQl controller");
        return allClient;
    }

    @Mutation("crearClienteCDTDigital")
    public ClienteCDTDigitalGraphQL crearClienteCDTDigitalGraphQl(@Name("crear") ClienteCDTDigitalGraphQL clienteCDTDigitalType) {
        LOG.info("Inicia el proceso de crear cliente CDT digital GraphQl controller");
        ClienteCDTDigitalGraphQL clienteCDTDigitalGraphQL = null;
        try {
            clienteCDTDigitalGraphQL = clienteCDTDigitalGraphQLImpl.crearClienteCDTDigitalImpl(clienteCDTDigitalType);
        } catch (ApplicationException e) {
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "crear cliente CDT digital GraphQl controller");
        }
        LOG.info("Finaliza el proceso de crear cliente CDT digital GraphQl controller");
        return clienteCDTDigitalGraphQL;
    }

    @Mutation("eliminarCliente")
    public void eliminarClienteCDTDigitalGraphQl(@Name("id") Integer id) {
        LOG.info("Inicia el proceso de eliminar cliente CDT digital GraphQl controller");
        try {
            clienteCDTDigitalGraphQLImpl.eliminarClienteCDTDigitalImpl(id.longValue());
        } catch (ApplicationException e) {
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "eliminar cliente CDT digital GraphQl controller");
        }
        LOG.info("Finaliza el proceso de eliminar cliente CDT digital GraphQl controller");
    }

    @Mutation("editarCliente")
    public void editarClienteCDTDigitalGraphQl(@Name("id") Integer id , ClienteCDTDigitalGraphQL clienteCDTDigitalGraphQL) {
        LOG.info("Inicia el proceso de editar cliente CDT digital GraphQl controller");
        try {
            clienteCDTDigitalGraphQLImpl.editarClienteCDTDigitalImpl(id.longValue() , clienteCDTDigitalGraphQL);
        } catch (ApplicationException e) {
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "editar cliente CDT digital GraphQl controller");
        }
        LOG.info("Finaliza el proceso de editar cliente CDT digital GraphQl controller");
    }
}
