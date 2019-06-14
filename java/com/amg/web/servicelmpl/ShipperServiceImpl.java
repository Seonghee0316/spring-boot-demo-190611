package com.amg.web.servicelmpl;

import java.util.List;

import com.amg.web.domain.ShipperDTO;
import com.amg.web.service.ShipperService;

import org.springframework.stereotype.Service;

/**
 * ShipperServiceImpl
 */
@Service
public class ShipperServiceImpl implements ShipperService {

    @Override
    public void addShipper(ShipperDTO customer) {

    }

    @Override
    public List<ShipperDTO> findShipper() {
        return null;
    }

    @Override
    public List<ShipperDTO> findShipperByOption(ShipperDTO option) {
        return null;
    }

    @Override
    public ShipperDTO findShipperByShipperId(String shipperId) {
        return null;
    }

    @Override
    public void updateShipperr(ShipperDTO shipper) {

    }

    @Override
    public void deleteShipper(ShipperDTO shipper) {

    }

    
}