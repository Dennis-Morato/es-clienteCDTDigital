package com.mibanco.clientecdtdigital.es.service.contract;

import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;

public interface IClienteCDTDigital {
    ClienteCDTDigitalType crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType);
    ClienteCDTDigitalType editarClienteCDTDigital(Integer idClienteCDT , ClienteCDTDigitalType clienteCDTDigitalType);
    void eliminarClienteCDTDigital(Integer idClienteCDT);
    ClienteCDTDigitalType buscarClienteCDTDigitalID(Integer idClienteCDT);
}
