package com.ck.spring_boot_try.modules.test.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 *
 * @TableName m_country
 */
@Data
public class Country implements Serializable {

    private List<City> cities;

    /**
     *
     */
    private Integer countryId;

    /**
     *
     */
    private String countryName;

    /**
     *
     */
    private String localCountryName;

    /**
     *
     */
    private String countryCode;

    /**
     *
     */
    private String countryCode2;

    /**
     *
     */
    private Object continent;

    /**
     *
     */
    private String region;

    /**
     *
     */
    private Double surfaceArea;

    /**
     *
     */
    private Integer indepYear;

    /**
     *
     */
    private Integer population;

    /**
     *
     */
    private Double lifeExpectancy;

    /**
     *
     */
    private Double gnp;

    /**
     *
     */
    private String governmentForm;

    /**
     *
     */
    private String headOfState;

    /**
     *
     */
    private Integer capital;

    /**
     *
     */
    private String timeZone;

    /**
     *
     */
    private Integer languageId;

    /**
     *
     */
    private Integer currencyId;

    /**
     *
     */
    private Date dateModified;

    /**
     *
     */
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
        Country other = (Country) that;
        return (this.getCountryId() == null ? other.getCountryId() == null : this.getCountryId().equals(other.getCountryId()))
            && (this.getCountryName() == null ? other.getCountryName() == null : this.getCountryName().equals(other.getCountryName()))
            && (this.getLocalCountryName() == null ? other.getLocalCountryName() == null : this.getLocalCountryName().equals(other.getLocalCountryName()))
            && (this.getCountryCode() == null ? other.getCountryCode() == null : this.getCountryCode().equals(other.getCountryCode()))
            && (this.getCountryCode2() == null ? other.getCountryCode2() == null : this.getCountryCode2().equals(other.getCountryCode2()))
            && (this.getContinent() == null ? other.getContinent() == null : this.getContinent().equals(other.getContinent()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getSurfaceArea() == null ? other.getSurfaceArea() == null : this.getSurfaceArea().equals(other.getSurfaceArea()))
            && (this.getIndepYear() == null ? other.getIndepYear() == null : this.getIndepYear().equals(other.getIndepYear()))
            && (this.getPopulation() == null ? other.getPopulation() == null : this.getPopulation().equals(other.getPopulation()))
            && (this.getLifeExpectancy() == null ? other.getLifeExpectancy() == null : this.getLifeExpectancy().equals(other.getLifeExpectancy()))
            && (this.getGnp() == null ? other.getGnp() == null : this.getGnp().equals(other.getGnp()))
            && (this.getGovernmentForm() == null ? other.getGovernmentForm() == null : this.getGovernmentForm().equals(other.getGovernmentForm()))
            && (this.getHeadOfState() == null ? other.getHeadOfState() == null : this.getHeadOfState().equals(other.getHeadOfState()))
            && (this.getCapital() == null ? other.getCapital() == null : this.getCapital().equals(other.getCapital()))
            && (this.getTimeZone() == null ? other.getTimeZone() == null : this.getTimeZone().equals(other.getTimeZone()))
            && (this.getLanguageId() == null ? other.getLanguageId() == null : this.getLanguageId().equals(other.getLanguageId()))
            && (this.getCurrencyId() == null ? other.getCurrencyId() == null : this.getCurrencyId().equals(other.getCurrencyId()))
            && (this.getDateModified() == null ? other.getDateModified() == null : this.getDateModified().equals(other.getDateModified()))
            && (this.getDateCreated() == null ? other.getDateCreated() == null : this.getDateCreated().equals(other.getDateCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCountryId() == null) ? 0 : getCountryId().hashCode());
        result = prime * result + ((getCountryName() == null) ? 0 : getCountryName().hashCode());
        result = prime * result + ((getLocalCountryName() == null) ? 0 : getLocalCountryName().hashCode());
        result = prime * result + ((getCountryCode() == null) ? 0 : getCountryCode().hashCode());
        result = prime * result + ((getCountryCode2() == null) ? 0 : getCountryCode2().hashCode());
        result = prime * result + ((getContinent() == null) ? 0 : getContinent().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getSurfaceArea() == null) ? 0 : getSurfaceArea().hashCode());
        result = prime * result + ((getIndepYear() == null) ? 0 : getIndepYear().hashCode());
        result = prime * result + ((getPopulation() == null) ? 0 : getPopulation().hashCode());
        result = prime * result + ((getLifeExpectancy() == null) ? 0 : getLifeExpectancy().hashCode());
        result = prime * result + ((getGnp() == null) ? 0 : getGnp().hashCode());
        result = prime * result + ((getGovernmentForm() == null) ? 0 : getGovernmentForm().hashCode());
        result = prime * result + ((getHeadOfState() == null) ? 0 : getHeadOfState().hashCode());
        result = prime * result + ((getCapital() == null) ? 0 : getCapital().hashCode());
        result = prime * result + ((getTimeZone() == null) ? 0 : getTimeZone().hashCode());
        result = prime * result + ((getLanguageId() == null) ? 0 : getLanguageId().hashCode());
        result = prime * result + ((getCurrencyId() == null) ? 0 : getCurrencyId().hashCode());
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
        sb.append(", countryId=").append(countryId);
        sb.append(", countryName=").append(countryName);
        sb.append(", localCountryName=").append(localCountryName);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", countryCode2=").append(countryCode2);
        sb.append(", continent=").append(continent);
        sb.append(", region=").append(region);
        sb.append(", surfaceArea=").append(surfaceArea);
        sb.append(", indepYear=").append(indepYear);
        sb.append(", population=").append(population);
        sb.append(", lifeExpectancy=").append(lifeExpectancy);
        sb.append(", gnp=").append(gnp);
        sb.append(", governmentForm=").append(governmentForm);
        sb.append(", headOfState=").append(headOfState);
        sb.append(", capital=").append(capital);
        sb.append(", timeZone=").append(timeZone);
        sb.append(", languageId=").append(languageId);
        sb.append(", currencyId=").append(currencyId);
        sb.append(", dateModified=").append(dateModified);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
