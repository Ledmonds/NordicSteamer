package com.ledmonds.nordicsteamer.service;

import com.ledmonds.nordicsteamer.entity.CountryRegion;
import com.ledmonds.nordicsteamer.model.CountryRegionModel;
import com.ledmonds.nordicsteamer.model.HotpoolModel;

import java.util.List;

public interface DAOConnector {
    public void addHotPool(HotpoolModel hotpoolModel) throws Exception;
    public List<HotpoolModel> getAllHotpools();
    public HotpoolModel getHotpoolById(Long id);
    public List<HotpoolModel> getAllHotpoolsByCountryRegionId(Long id);

    public void addCountryRegion(CountryRegionModel countryRegionModel);
    public List<CountryRegionModel> getAllCountryRegions();
    public CountryRegionModel getCountryRegionById(Long id);
}
