package com.ck.spring_boot_try.modules.test.controller;

import com.ck.spring_boot_try.modules.test.entity.City;
import com.ck.spring_boot_try.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * @param countryId ch:522
     *                  /api/cities/522
     * @return
     */
    @RequestMapping("/cities/{countryId}")
    public List<City> getCitiesByCountryById(@PathVariable int countryId){
        return cityService.getCitiesByCountryId(countryId);
    }

}
