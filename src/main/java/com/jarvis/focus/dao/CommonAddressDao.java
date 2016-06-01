package com.jarvis.focus.dao;

import com.jarvis.focus.dto.CommonAddressDTO;
import com.jarvis.focus.entity.CommonAddress;

import java.util.List;

public interface CommonAddressDao {

    public void saveCommonAddress(CommonAddress commonAddress);

    public void saveCommonAddressList(List<CommonAddress> commonAddressList);

    public Integer updateCommonAddress(CommonAddress commonAddress);

	public List<CommonAddressDTO> getCommonAddressList(CommonAddressDTO commonAddress);
}
