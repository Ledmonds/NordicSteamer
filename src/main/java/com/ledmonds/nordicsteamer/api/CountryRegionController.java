package com.ledmonds.nordicsteamer.api;

import com.ledmonds.nordicsteamer.model.CountryRegionModel;
import com.ledmonds.nordicsteamer.service.DAOConnector;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Api(tags = "Country Region Api Controller")
@RequestMapping("api/v1/countryRegion")
@RestController
public class CountryRegionController {
    @Autowired
    private DAOConnector daoConnector;

    @PostMapping(path = "/add")
    public ResponseEntity<?> addCountryRegion(@RequestBody @Valid CountryRegionModel countryRegionModel, @ApiIgnore Errors errors) {
        try{
            if (errors.hasErrors()) {
                return new ResponseEntity<>(errors.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }

            daoConnector.addCountryRegion(countryRegionModel);
        }
        catch (Exception e) {
            return new ResponseEntity<>(Arrays.asList( new FieldError("CountryRegionModel", "unknown", e.getMessage()) ), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<CountryRegionModel> getAllCountryRegions() {
        return daoConnector.getAllCountryRegions();
    }

    @GetMapping (path = "{id}")
    public CountryRegionModel getCountryRegionById(@PathVariable("id") Long id) {
        return daoConnector.getCountryRegionById(id);
    }
}
