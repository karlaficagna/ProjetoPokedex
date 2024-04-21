package com.ficagna.addressApi.service.rest.implemantation;

import com.ficagna.addressApi.model.entity.Address;
import com.ficagna.addressApi.model.entity.AddressDto;
import com.ficagna.addressApi.service.rest.ExternalCepRestService;

public class BrasilApiRestServiceImpl implements ExternalCepRestService {

    @Override
    public AddressDto searchByCep(Integer cep) {
        return Address.builder()
                .logradouro("Brasil api")
                .cep(cep)
                .build();
    }

}
