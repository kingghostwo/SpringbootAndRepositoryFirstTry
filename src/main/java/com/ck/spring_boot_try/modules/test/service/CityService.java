package com.ck.spring_boot_try.modules.test.service;

import com.ck.spring_boot_try.modules.test.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ck.spring_boot_try.modules.test.entity.Country;
import com.ck.spring_boot_try.utils.Result;
import com.ck.spring_boot_try.utils.SearchVo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public interface CityService extends IService<City> {

    List<City> getCitiesByCountryId (int countryId);

    PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId);

    PageInfo<City> getAllCitiesBySearchVo(SearchVo searchVo);

    Result<City> insertCity(City city);

    Result<City> updateCityByCityId(City city);

    Result<City> deleteCityById(int city);
}
