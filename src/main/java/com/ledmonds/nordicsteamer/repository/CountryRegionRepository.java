package com.ledmonds.nordicsteamer.repository;

import com.ledmonds.nordicsteamer.entity.CountryRegion;
import com.ledmonds.nordicsteamer.model.CountryRegionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRegionRepository extends JpaRepository<CountryRegion, Long> {
    @Query("select new com.ledmonds.nordicsteamer.model.CountryRegionModel(n.name, n.nativeName, n.description) from CountryRegion n")
    List<CountryRegionModel> findAllCountryRegions();

    @Query("select new com.ledmonds.nordicsteamer.model.CountryRegionModel(n.name, n.nativeName, n.description) from CountryRegion n where n.id = :id")
    CountryRegionModel findCountryRegionById(@Param("id") Long id);
}
