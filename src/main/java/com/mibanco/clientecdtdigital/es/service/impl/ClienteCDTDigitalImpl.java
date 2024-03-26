package com.mibanco.clientecdtdigital.es.service.impl;

import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.service.contract.IClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import com.mibanco.clientecdtdigital.es.utils.mapper.ClienteCDTDigitalMapper;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.mibanco.clientecdtdigital.es.constant.Constant.ERROR_SERVICIO;

@ApplicationScoped
public class ClienteCDTDigitalImpl implements IClienteCDTDigital {
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalImpl.class);
    @Inject
    ClienteCDTDigitalMapper clienteCDTDigitalMapper;
    @Inject
    ClienteCDTDigitalDao clienteCDTDigitalDao;

    @Transactional
    public ClienteCDTDigitalType crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia proceso de crear cliente CDT digital impl");
       try{
           ClienteCDTDigital clienteCDTDigital = clienteCDTDigitalMapper.clienteCDTDigitalTypeToEntity(clienteCDTDigitalType);
           clienteCDTDigitalDao.persist(clienteCDTDigital);
       }catch (ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage() + "crear cliente CDT digital impl");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "crear cliente CDT digital impl");
       }
        LOG.info("Finaliza proceso de creacion de cliente CDT digital impl");
        return clienteCDTDigitalType;
    }

    @Transactional
    public ClienteCDTDigitalType editarClienteCDTDigital(Integer idClienteCDT,ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia proceso de editar cliente CDT digital impl");
        ClienteCDTDigitalType clienteCDTDigitalTypeResponse;
        try{
            ClienteCDTDigital clienteCDTDigital = clienteCDTDigitalDao.findById(idClienteCDT.longValue());
            clienteCDTDigitalTypeResponse = clienteCDTDigitalMapper.clienteCDTDigitalEntityToType(clienteCDTDigital);

            ClienteCDTDigital clienteCDTDigitalCambio = clienteCDTDigitalMapper.clienteCDTDigitalTypeToEntity(clienteCDTDigitalType);
            clienteCDTDigital.setFechaNacimientoDia(clienteCDTDigitalCambio.getFechaNacimientoDia());
            clienteCDTDigital.setFechaNacimientoMes(clienteCDTDigitalCambio.getFechaNacimientoMes());
            clienteCDTDigital.setFechaNacimientoAno(clienteCDTDigitalCambio.getFechaNacimientoAno());
            clienteCDTDigital.setTelefonoPrincipal(clienteCDTDigitalCambio.getTelefonoPrincipal());
            clienteCDTDigital.setOcupacion(clienteCDTDigitalCambio.getOcupacion());

        }catch (ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage() + "editar cliente CDT digital impl");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "editar cliente CDT digital impl");
        }
        LOG.info("Finaliza proceso de editar cliente CDT digital impl");
        return clienteCDTDigitalType;
    }

    @Transactional
    public void eliminarClienteCDTDigital(Integer idClienteCDT) {
        LOG.info("Se inicia proceso de eliminar usuario CDT digital impl");
        try {
            clienteCDTDigitalDao.deleteById(idClienteCDT.longValue());
        }catch (ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage() + "eliminar cliente CDT digital impl");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() +  "eliminar cliente CDT digital impl");
        }
        LOG.info("Finaliza proceso de eliminar usuario impl");
    }

    public ClienteCDTDigitalType buscarClienteCDTDigitalID(Integer idClienteCDT) {
        LOG.info("Inicia el metodo buscar cliente CDT digital Impl por ID");
        ClienteCDTDigitalType clienteCDTDigitalType;
        try {
            clienteCDTDigitalType = clienteCDTDigitalMapper.
                    clienteCDTDigitalEntityToType(clienteCDTDigitalDao.
                    findById(idClienteCDT.longValue()));
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage() + "buscar cliente CDT por id impl");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "buscar cliente CDT por id impl");
        }
        LOG.info("Finaliza el metodo buscarClienteCDTDigital Impl");
        return clienteCDTDigitalType;
    }


    public List<ClienteCDTDigitalType> listarTodosLosClientesCDTDigital() {
        LOG.info("inicia proceso de listar todos los usuarios impl");
        List<ClienteCDTDigital> clienteCDTDigitals = null;
        try{
            PanacheQuery listQuery = clienteCDTDigitalDao.findAll();
            clienteCDTDigitals = listQuery.list();
        }catch(ApplicationException e){
            LOG.error(ERROR_SERVICIO + e.getMessage() + "listar todos los clientes CDT digitals impl");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "listar todos los clientes CDT digitalas impl");
        }
        LOG.info("Se finaliza proceso de listar todos los clientes CDT Digitals Impl");
        return clienteCDTDigitalMapper.clientesCDTDigitalsTypeListEntityToType(clienteCDTDigitals);
    }


}
