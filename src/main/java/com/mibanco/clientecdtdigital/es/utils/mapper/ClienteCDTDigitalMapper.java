package com.mibanco.clientecdtdigital.es.utils.mapper;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClienteCDTDigitalMapper {
    public ClienteCDTDigital clienteCDTDigitalTypeToEntity(ClienteCDTDigitalType clienteCDTDigitalType){
        return new ModelMapper().map(clienteCDTDigitalType, ClienteCDTDigital.class);
    }
    public ClienteCDTDigitalType clienteCDTDigitalEntityToType(ClienteCDTDigital clienteCDTDigital){
        return new ModelMapper().map(clienteCDTDigital, ClienteCDTDigitalType.class);
    }

    public List<ClienteCDTDigitalType> clientesCDTDigitalsTypeListEntityToType(List<ClienteCDTDigital> clienteCDTDigitalList){
        List<ClienteCDTDigitalType> clienteCDTDigitalType = new ArrayList<>();

        for (ClienteCDTDigital clienteCDTDigital : clienteCDTDigitalList) {
            ClienteCDTDigitalType clienteCDTDigitalResponse = new ModelMapper().map(clienteCDTDigital, ClienteCDTDigitalType.class);
            clienteCDTDigitalType.add(clienteCDTDigitalResponse);
        }
        return clienteCDTDigitalType;
    }
}
