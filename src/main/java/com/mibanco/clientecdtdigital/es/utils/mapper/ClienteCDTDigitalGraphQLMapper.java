package com.mibanco.clientecdtdigital.es.utils.mapper;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigitalGraphQL;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClienteCDTDigitalGraphQLMapper {
    public ClienteCDTDigitalGraphQL clienteCDTDigitalTypeToEntity(ClienteCDTDigitalGraphQL clienteCDTDigitalType){
        return new ModelMapper().map(clienteCDTDigitalType, ClienteCDTDigitalGraphQL.class);
    }
}
