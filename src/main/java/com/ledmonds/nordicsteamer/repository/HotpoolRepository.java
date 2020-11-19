package com.ledmonds.nordicsteamer.repository;

import com.ledmonds.nordicsteamer.entity.Hotpool;
import com.ledmonds.nordicsteamer.model.HotpoolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotpoolRepository extends JpaRepository<Hotpool, Long> {
    @Query("select new com.ledmonds.nordicsteamer.model.HotpoolModel(n.name, n.nordicName, n.description, n.temperature, n.gpsX, n.gpsY, n.countryRegion.id) from Hotpool n")
    List<HotpoolModel> findAllHotPools();

    @Query("select new com.ledmonds.nordicsteamer.model.HotpoolModel(n.name, n.nordicName, n.description, n.temperature, n.gpsX, n.gpsY, n.countryRegion.id) from Hotpool n where n.id = :id")
    HotpoolModel findHotpoolById(@Param("id") Long id);

    @Query("select new com.ledmonds.nordicsteamer.model.HotpoolModel(n.name, n.nordicName, n.description, n.temperature, n.gpsX, n.gpsY, n.countryRegion.id) from Hotpool n where n.id = :id")
    List<HotpoolModel> findAllHotpoolsByCountryRegionId(@Param("id") Long id);
}
