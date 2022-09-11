package com.ck.spring_boot_try.modules.test.mapper;

import com.ck.spring_boot_try.modules.test.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.ck.spring_boot_try.modules.test.entity.City
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {

    List<City> getCitiesByCountryId(int countryId);

}




