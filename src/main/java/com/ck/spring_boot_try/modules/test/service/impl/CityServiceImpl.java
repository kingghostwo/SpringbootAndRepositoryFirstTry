package com.ck.spring_boot_try.modules.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ck.spring_boot_try.modules.test.entity.City;
import com.ck.spring_boot_try.modules.test.service.CityService;
import com.ck.spring_boot_try.modules.test.mapper.CityMapper;
import com.ck.spring_boot_try.modules.common.vo.Result;
import com.ck.spring_boot_try.modules.common.vo.SearchVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City>
    implements CityService {

    @Autowired
    CityMapper cityMapper;

    @Override
    public List<City> getCitiesByCountryId(int countryId) {
        return Optional.ofNullable(cityMapper.getCitiesByCountryId(countryId))
                .orElse(Collections.emptyList());
    }

    @Override
    public PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<City>(
                Optional.ofNullable(cityMapper.getCitiesByCountryId(countryId))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public PageInfo<City> getAllCitiesBySearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<City>(
                Optional.ofNullable(cityMapper.getAllCitiesBySearchVo(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public Result<City> insertCity(City city) {
        cityMapper.insertCity(city);
        return new Result<City>(Result.ResultStatus.SUCCESS.status,"insert fine",city);
    }

    @Override
    public Result<City> updateCityByCityId(City city) {
        cityMapper.updateCityByCityId(city);
        return new Result<City>(Result.ResultStatus.SUCCESS.status,"update fine",city);
    }

    @Override
    public Result<City> deleteCityById(int city) {
        cityMapper.deleteCityById(city);
        return new Result<City>(Result.ResultStatus.SUCCESS.status,"delete fine");
    }
}




