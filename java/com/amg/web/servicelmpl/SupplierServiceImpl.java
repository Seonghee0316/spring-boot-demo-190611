package com.amg.web.servicelmpl;

import java.util.List;

import com.amg.web.domain.SupplierDTO;
import com.amg.web.service.SupplierService;

import org.springframework.stereotype.Service;

/**
 * SupplierServiceImpl
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Override
    public void addSupplier(SupplierDTO supplier) {

    }

    @Override
    public List<SupplierDTO> findSuppliers() {
        return null;
    }

    @Override
    public List<SupplierDTO> findSuppliersByOption(SupplierDTO option) {
        return null;
    }

    @Override
    public SupplierDTO findSuppliersBySupplierId(String supplierId) {
        return null;
    }

    @Override
    public void updateSupplier(SupplierDTO supplier) {

    }

    @Override
    public void deleteSupplier(SupplierDTO supplier) {

    }

    
}