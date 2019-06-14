package com.amg.web.mapper;

import java.util.List;

import com.amg.web.domain.ShipperDTO;

import org.springframework.stereotype.Repository;

/**
 * ShipperMapper
 */

@Repository
public interface ShipperMapper {
    public void insertShipper(ShipperDTO customer);
    public List<ShipperDTO> selectShipper();
    public List<ShipperDTO> selectShipperByOption(ShipperDTO option);
    public ShipperDTO selectShipperByShipperId(String shipperId);
    public void updateShipper(ShipperDTO shipper);
    public void deleteShipper(ShipperDTO shipper);
    
}