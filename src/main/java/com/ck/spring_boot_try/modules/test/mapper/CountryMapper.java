package com.ck.spring_boot_try.modules.test.mapper;

import com.ck.spring_boot_try.modules.test.entity.Country;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  @Entity com.ck.spring_boot_try.modules.test.entity.Country
 */
@Mapper
public interface CountryMapper extends BaseMapper<Country> {



    @Select("select * from m_country where country_id = #{countryId}")
    @Results(id = "countryResults", value= {
            @Result(column = " country_id", property = "countryId"),
            @Result(column = " country_id", property = "cities",
                    javaType = List.class,
                    many = @Many(select = "com.ck.spring_boot_try.modules.test.mapper.CityMapper.getCitiesByCountryId"))
    })
    List<Country> getCountryByCountryId(int countryId);

    @Select("select * from m_country where country_name = #{countryName}")
    @ResultMap(value = "countryResults")
    Country getCountryByCountryName(String countryName);
}





