package com.ck.spring_boot_try.modules.test.controller;

import com.ck.spring_boot_try.modules.test.entity.Country;
import com.ck.spring_boot_try.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * @param countryId ch:522
     *                  /api/country/522
     * @return
     */
    @RequestMapping("/country/{countryId}")
    public Country getCountryByCountryById(@PathVariable int countryId){
        return countryService.getCountryByCountryId(countryId);
    }

    /**
     * @param countryName
     *      /api/country?China
     * @return
     */
    @RequestMapping("/country")
    public Country getCountryByCountryName(@RequestParam String countryName){
        return countryService.getCountryByCountryName(countryName);
    }
}
