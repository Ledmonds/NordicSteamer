package com.ledmonds.nordicsteamer.service;

import com.ledmonds.nordicsteamer.entity.CountryRegion;
import com.ledmonds.nordicsteamer.entity.Hotpool;
import com.ledmonds.nordicsteamer.model.CountryRegionModel;
import com.ledmonds.nordicsteamer.model.HotpoolModel;
import com.ledmonds.nordicsteamer.repository.CountryRegionRepository;
import com.ledmonds.nordicsteamer.repository.HotpoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySQLDAOConnectorService implements DAOConnector {
    @Autowired
    private HotpoolRepository hotpoolRepository;

    @Autowired
    private CountryRegionRepository countryRegionRepository;

    @Override
    public void addHotPool(HotpoolModel hotpoolModel) throws Exception {
        CountryRegion countryRegion = countryRegionRepository.findById(hotpoolModel.getCountryRegionIdRegion())
                .orElseThrow(() -> new Exception("Could not find Country Region"));

        hotpoolRepository.save(new Hotpool(
                hotpoolModel.getName(),
                hotpoolModel.getNativeName(),
                hotpoolModel.getDescription(),
                hotpoolModel.getTemperature(),
                hotpoolModel.getGpsX(),
                hotpoolModel.getGpsY(),
                countryRegion)
        );
    }

    @Override
    public List<HotpoolModel> getAllHotpools() {
        return hotpoolRepository.findAllHotPools();
    }

    @Override
    public HotpoolModel getHotpoolById(Long id) {
        return hotpoolRepository.findHotpoolById(id);
    }

    @Override
    public List<HotpoolModel> getAllHotpoolsByCountryRegionId(Long id) {
        return hotpoolRepository.findAllHotpoolsByCountryRegionId(id);
    }

    @Override
    public void addCountryRegion(CountryRegionModel countryRegionModel) {
        countryRegionRepository.save(new CountryRegion(
                countryRegionModel.getName(),
                countryRegionModel.getNativeName(),
                countryRegionModel.getDescription())
        );
    }

    @Override
    public List<CountryRegionModel> getAllCountryRegions() {
        return countryRegionRepository.findAllCountryRegions();
    }

    @Override
    public CountryRegionModel getCountryRegionById(Long id) {
        return countryRegionRepository.findCountryRegionById(id);
    }
}
