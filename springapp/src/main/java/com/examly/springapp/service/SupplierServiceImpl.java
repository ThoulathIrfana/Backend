package com.examly.springapp.service;

import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.SupplierRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepo supplierRepository;

    public SupplierServiceImpl(SupplierRepo supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier); // MUST return saved supplier
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        Supplier existing = supplierRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setSupplierName(supplier.getSupplierName());
            existing.setContactNumber(supplier.getContactNumber());
            existing.setEmail(supplier.getEmail());
            existing.setAddress(supplier.getAddress());
            return supplierRepository.save(existing);
        }

        return null;
    }
}
