package com.ck.spring_boot_try.modules.test.service;

import com.ck.spring_boot_try.modules.test.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ck.spring_boot_try.modules.test.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public interface CityService extends IService<City> {

    List<City> getCitiesByCountryId (int countryId);

}
