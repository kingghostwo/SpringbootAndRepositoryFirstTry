package com.ck.spring_boot_try.modules.test.mapper;

import com.ck.spring_boot_try.modules.test.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ck.spring_boot_try.utils.SearchVo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

/**
 * @Entity com.ck.spring_boot_try.modules.test.entity.City
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {

    @Select("select * from m_city where country_id = #{countryId}")
    List<City> getCitiesByCountryId(int countryId);

    @Select("<script>" +
            "select * from m_city "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + "and (city_name like '%${keyWord}%' or "
            + " local_city_name like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + "order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + "order by city_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<City> getAllCitiesBySearchVo(SearchVo searchVo);

    @Insert("insert into m_city (city_name,local_city_name,country_id,date_created)"
            + "values (#{cityName},#{localCityName},#{countryId},#{dateCreated})")
    @Options(useGeneratedKeys = true, keyColumn = "city_id", keyProperty = "cityId")
    void insertCity(City city);

    @Update("update m_city set local_city_name = #{localCityName} where city_id = #{cityId} ")
    void updateCityByCityId(City city);

    @Delete("delete from m_city where city_id = #{cityId}")
    void deleteCityById(int cityId);
}




