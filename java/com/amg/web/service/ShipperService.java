package com.amg.web.service;

import java.util.List;

import com.amg.web.domain.ShipperDTO;

import org.springframework.stereotype.Component;

/**
 * ShipperService
 */
@Component
public interface ShipperService {
    public void addShipper(ShipperDTO customer);
    public List<ShipperDTO> findShipper();
    public List<ShipperDTO> findShipperByOption(ShipperDTO option);
    public ShipperDTO findShipperByShipperId(String shipperId);
    public void updateShipper(ShipperDTO shipper);
    public void deleteShipper(ShipperDTO shipper);
    
}