package com.jarvis.focus.entity;

import com.jarvis.focus.dto.AreaDTO;

import java.sql.Timestamp;
import java.util.List;

@SuppressWarnings("serial")
public class CommonAddress implements java.io.Serializable {
    private Long id;
    private String tableName;
    private Long tableKeyId;
    private Long provinceId;
    private String provinceName;
    private Long cityId;
    private String cityName;
    private Long districtId;
    private String districtName;
    private String address;
    private Integer status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private List<AreaDTO> cityList;
    private String longitude;
	private String latitude;

    private String extContent;
	
    public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public List<AreaDTO> getCityList() {
		return cityList;
	}

	public void setCityList(List<AreaDTO> cityList) {
		this.cityList = cityList;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getTableKeyId() {
        return tableKeyId;
    }

    public void setTableKeyId(Long tableKeyId) {
        this.tableKeyId = tableKeyId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getExtContent() {
        return extContent;
    }

    public void setExtContent(String extContent) {
        this.extContent = extContent;
    }
}
