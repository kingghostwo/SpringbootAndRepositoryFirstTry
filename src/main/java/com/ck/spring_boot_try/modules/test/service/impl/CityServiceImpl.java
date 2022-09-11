package com.ck.spring_boot_try.modules.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ck.spring_boot_try.modules.test.entity.City;
import com.ck.spring_boot_try.modules.test.service.CityService;
import com.ck.spring_boot_try.modules.test.mapper.CityMapper;
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
}




