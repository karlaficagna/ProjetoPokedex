package com.ficagna.addressApi.controller;

import com.ficagna.addressApi.controller.resourses.AddressRequest;
import com.ficagna.addressApi.controller.resourses.AddressResponse;
import com.ficagna.addressApi.model.entity.AddressDto;
import com.ficagna.addressApi.model.repository.AddressRepository;
import com.ficagna.addressApi.service.AddressIntegrationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("api/v1/enderecos")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressIntegrationService addressIntegrationService;
    private AddressRepository addressRepository;

    public AddressController(com.ficagna.addressApi.service.AddressIntegrationService addressIntegrationService) {
        this.addressIntegrationService = addressIntegrationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(addressIntegrationService.findById(id));
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<AddressDto> findByCep(@PathVariable String cep) {
        return ResponseEntity.ok(addressIntegrationService.findByCep(cep));
    }

    @PostMapping
    public ResponseEntity<AddressResponse> salvar(@RequestBody @Valid AddressRequest addressRequest) {
        AddressResponse addressSalvo = addressIntegrationService.salvar(addressRequest);
        return new ResponseEntity<>(addressSalvo, HttpStatus.CREATED);


    }
}

