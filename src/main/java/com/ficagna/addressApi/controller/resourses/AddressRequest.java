package com.ficagna.addressApi.controller.resourses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ficagna.addressApi.model.entity.Address;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
public class AddressRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @JsonProperty("address")
    private Integer cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public AddressRequest() {
    }

    public Address converterParaEntity() {

        return new Address();
    }
}



