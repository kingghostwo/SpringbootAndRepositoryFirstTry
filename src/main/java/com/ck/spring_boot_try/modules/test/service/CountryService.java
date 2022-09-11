package com.ck.spring_boot_try.modules.test.service;

import com.ck.spring_boot_try.modules.test.entity.City;
import com.ck.spring_boot_try.modules.test.entity.Country;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public interface CountryService extends IService<Country> {

    List<Country> getCountryByCountryId (int countryId);

    Country getCountryByCountryName(String CountryName);
}
