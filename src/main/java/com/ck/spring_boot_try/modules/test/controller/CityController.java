package com.ck.spring_boot_try.modules.test.controller;

import com.ck.spring_boot_try.modules.test.entity.City;
import com.ck.spring_boot_try.modules.test.service.CityService;
import com.ck.spring_boot_try.modules.common.vo.Result;
import com.ck.spring_boot_try.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<City> getCitiesByCountryId(@PathVariable int countryId){
        return cityService.getCitiesByCountryId(countryId);
    }

    /**
     * /api/cities?currentPage=1&pageSize=5&countryId=522
     * @param currentPage
     * @param pageSize
     * @param countryId
     * @return
     */
    @RequestMapping("/cities")
    PageInfo<City> getCitiesByPage(@RequestParam int currentPage, @RequestParam int pageSize, @RequestParam int countryId){
        return cityService.getCitiesByPage(currentPage, pageSize, countryId);
    }

    /**
     * @param searchVo
     * /api/cities
     * @return
     */
    @PostMapping(value = "/cities", consumes = "application/json")
    PageInfo<City> getAllCitiesBySearchVo(@RequestBody SearchVo searchVo){
        return cityService.getAllCitiesBySearchVo(searchVo);
    }

    /**
     * @param city
     * /api/cities/insert ---post
     * @return
     */
    @PostMapping(value = "/cities/insert", consumes = "application/json")
    Result<City> insertCity(@RequestBody City city){
        return cityService.insertCity(city);
    }

    /**
     * @param city
     * /api/cities/update ----put
     * @return
     */
    @PutMapping(value = "/cities/update", consumes = "application/x-www-form-urlencoded")
    Result<City> updateCityByCityId(@ModelAttribute City city){
        return cityService.updateCityByCityId(city);
    }

    /**
     * @param cityId
     * /api/cities/delete/{cityId}
     * @return
     */
    @DeleteMapping("/cities/delete/{cityId}")
    Result<City> deleteCityById(@PathVariable int cityId){
        return cityService.deleteCityById(cityId);
    }
}
