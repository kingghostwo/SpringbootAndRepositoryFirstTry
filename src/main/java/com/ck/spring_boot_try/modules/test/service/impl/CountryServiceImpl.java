package com.ck.spring_boot_try.modules.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ck.spring_boot_try.modules.test.entity.Country;
import com.ck.spring_boot_try.modules.test.service.CountryService;
import com.ck.spring_boot_try.modules.test.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country>
    implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<Country> getCountryByCountryId(int countryId) {
        return countryMapper.getCountryByCountryId(countryId);
    }

    @Override
    public Country getCountryByCountryName(String CountryName) {
        return countryMapper.getCountryByCountryName(CountryName);
    }

}




