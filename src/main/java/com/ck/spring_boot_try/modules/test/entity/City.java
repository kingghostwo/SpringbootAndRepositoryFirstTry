package com.ck.spring_boot_try.modules.test.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @TableName m_city
 */
@Data
public class City implements Serializable {
    /**
     *
     */
    private Integer cityId;

    /**
     *
     */
    private String cityName;

    /**
     *
     */
    private String localCityName;

    /**
     *
     */
    private Integer countryId;

    /**
     *
     */
    private String district;

    /**
     *
     */
    private Integer population;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateModified;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        City other = (City) that;
        return (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
                && (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
                && (this.getLocalCityName() == null ? other.getLocalCityName() == null : this.getLocalCityName().equals(other.getLocalCityName()))
                && (this.getCountryId() == null ? other.getCountryId() == null : this.getCountryId().equals(other.getCountryId()))
                && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
                && (this.getPopulation() == null ? other.getPopulation() == null : this.getPopulation().equals(other.getPopulation()))
                && (this.getDateModified() == null ? other.getDateModified() == null : this.getDateModified().equals(other.getDateModified()))
                && (this.getDateCreated() == null ? other.getDateCreated() == null : this.getDateCreated().equals(other.getDateCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getLocalCityName() == null) ? 0 : getLocalCityName().hashCode());
        result = prime * result + ((getCountryId() == null) ? 0 : getCountryId().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getPopulation() == null) ? 0 : getPopulation().hashCode());
        result = prime * result + ((getDateModified() == null) ? 0 : getDateModified().hashCode());
        result = prime * result + ((getDateCreated() == null) ? 0 : getDateCreated().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cityId=").append(cityId);
        sb.append(", cityName=").append(cityName);
        sb.append(", localCityName=").append(localCityName);
        sb.append(", countryId=").append(countryId);
        sb.append(", district=").append(district);
        sb.append(", population=").append(population);
        sb.append(", dateModified=").append(dateModified);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
