package com.ledmonds.nordicsteamer.api;

import com.ledmonds.nordicsteamer.model.HotpoolModel;
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

@Api(tags = "Hotpool Api Controller")
@RequestMapping("api/v1/hotpool")
@RestController
public class HotpoolController {
    @Autowired
    private DAOConnector daoConnector;

    @PostMapping(path = "/add")
    public ResponseEntity<?> addHotpool(@RequestBody @Valid HotpoolModel hotpoolModel, @ApiIgnore Errors errors) {
        try{
            if (errors.hasErrors()) {
                return new ResponseEntity<>(errors.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }

            daoConnector.addHotPool(hotpoolModel);
        }
        catch (Exception e) {
            return new ResponseEntity<>(Arrays.asList( new FieldError("HotpoolModel", "unknown", e.getMessage()) ), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<HotpoolModel> getAllHotpools() {
        return daoConnector.getAllHotpools();
    }

    @GetMapping (path = "{id}")
    public HotpoolModel getHotpoolById(@PathVariable("id") Long id) {
        return daoConnector.getHotpoolById(id);
    }

    @GetMapping (path = "/countryRegion/{id}")
    public List<HotpoolModel> getHotpoolByCountryRegionId(@PathVariable("id") Long id) {
        return daoConnector.getAllHotpoolsByCountryRegionId(id);
    }
}
