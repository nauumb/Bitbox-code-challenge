package com.exercise.bitboxer.services.impl;

import com.exercise.bitboxer.dto.ItemDTO;
import com.exercise.bitboxer.dto.SupplierDTO;
import com.exercise.bitboxer.model.Supplier;
import com.exercise.bitboxer.repositories.SupplierRepository;
import com.exercise.bitboxer.services.SupplierService;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SupplierDTO> findAllSuppliers() {

        try {
            List<Supplier> suppliersList =  supplierRepository.findAll();

            if(suppliersList.isEmpty()) {
                throw new ObjectNotFoundException(ItemDTO.class, "No items was found.");
            }

            return suppliersList
                    .stream()
                    .map(supplier -> modelMapper.map(supplier, SupplierDTO.class))
                    .collect(Collectors.toList());

        } catch (HttpServerErrorException | HttpClientErrorException e){
            throw e;
        }
    }
}
