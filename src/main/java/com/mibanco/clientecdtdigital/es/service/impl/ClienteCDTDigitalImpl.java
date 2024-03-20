package com.mibanco.clientecdtdigital.es.service.impl;

import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.service.contract.IClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import com.mibanco.clientecdtdigital.es.utils.mapper.ClienteCDTDigitalMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            LOG.error(Constant.ERROR_SERVICIO + e.getMessage() + "crear cliente CDT digital impl");
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
       }
        LOG.info("Finaliza proceso de creacion de cliente CDT digital impl");
        return clienteCDTDigitalType;
    }
}
