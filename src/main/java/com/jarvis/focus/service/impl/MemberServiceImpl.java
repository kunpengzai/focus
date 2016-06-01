package com.jarvis.focus.service.impl;

import com.jarvis.focus.dao.AreaDao;
import com.jarvis.focus.dao.CommonAddressDao;
import com.jarvis.focus.dao.MemberDao;
import com.jarvis.focus.dao.ProductDao;
import com.jarvis.focus.dto.MemberDTO;
import com.jarvis.focus.dto.ProductDTO;
import com.jarvis.focus.entity.CommonAddress;
import com.jarvis.focus.service.MemberService;
import com.jarvis.focus.utils.Config;
import com.jarvis.focus.utils.DateUtils;
import com.jarvis.focus.utils.DownloadUtils;
import com.jarvis.focus.utils.ImageUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Jarvis on 2016/5/21.
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource
    private MemberDao memberDao;
    @Resource
    private ProductDao productDao;
    @Resource
    private AreaDao areaDao;
    @Resource
    private CommonAddressDao commonAddressDao;

    public void applyFocus(String code, Model model) {
        if (StringUtils.isBlank(code)) {
            code = "apat";
        }
        ProductDTO dto = productDao.getProduct(code);
        if (dto != null) {
            model.addAttribute("product", dto);
        }
    }

    public void applyFocusData(MemberDTO memberDTO, MultipartFile imageFile) throws Exception {
        if (StringUtils.isBlank(memberDTO.getProductCode())) {
            memberDTO.setProductCode("apat");
        }
        ProductDTO dto = productDao.getProduct(memberDTO.getProductCode());
        if (dto != null) {
            Long memberId = memberDao.saveMember(memberDTO);
            if (memberDTO.getAddress() != null) {
                CommonAddress commonAddress = new CommonAddress();
                commonAddress.setTableName("member");
                commonAddress.setTableKeyId(memberId);
                commonAddress.setProvinceId(memberDTO.getAddress().getProvinceId());
                commonAddress.setProvinceName(memberDTO.getAddress().getProvinceName());
                commonAddress.setCityId(memberDTO.getAddress().getCityId());
                commonAddress.setCityName(memberDTO.getAddress().getCityName());
                commonAddressDao.saveCommonAddress(commonAddress);
            }
            if (imageFile != null && imageFile.getSize() > 0) {
                String newFileName = uploadFile(imageFile, memberId);
                MemberDTO updateDto = new MemberDTO();
                updateDto.setId(memberId);
                updateDto.setAvatarUrl(newFileName);
                memberDao.updateMember(updateDto);
            }
            memberDTO.setMemberId(memberId);
            Long memberApplyInfoId = memberDao.saveMemberApplyInfo(memberDTO);
            productDao.saveProductMember(dto.getId(), memberId, memberApplyInfoId);
            logger.info("Apply Focus success. memberId=" + memberId);
            return;
        }
        logger.error("Apply Focus failed. productCode is not correct. productCode=" + memberDTO.getProductCode());
        return;
    }

    public Map<Integer, Object> getAreaCityFull() {
        List<Map> addressLst = areaDao.getCitiesFullJson();
        Map<Integer, Object> provinces = null;
        if (addressLst != null && !addressLst.isEmpty()) {
            provinces = new LinkedHashMap<Integer, Object>();
            // all province
//            Map<String, Object> selectAllPro = new HashMap<String, Object>();
//            selectAllPro.put("id", 0);
//            selectAllPro.put("text", "全部省份");
//            selectAllPro.put("value", "000000");
//            List<Map> allProCity = new ArrayList<Map>();
//            Map<String, Object> selectAllCity = new HashMap<String, Object>();
//            selectAllCity.put("id", 0);
//            selectAllCity.put("text", "全部城市");
//            selectAllCity.put("value", "000000");
//            allProCity.add(selectAllCity);
//            selectAllPro.put("children", allProCity);
//            provinces.put(0, selectAllPro);
            // each city
            for (Map provinceDate : addressLst) {
                Integer provinceId = (Integer) provinceDate.get("provinceId");
                Map<String, Object> province = (Map<String, Object>) provinces.get(provinceId);
                if (province == null) {
                    province = new HashMap<String, Object>();
                    provinces.put(provinceId, province);
                    province.put("id", provinceId);
                    province.put("text", provinceDate.get("provinceName"));
                    province.put("value", provinceDate.get("provinceCode"));
                }
                List<Map> cities = (List<Map>) province.get("children");
                if (cities == null) {
                    cities = new ArrayList<Map>();
                    province.put("children", cities);
//                    cities.add(selectAllCity);
                }
                Map<String, Object> city = new HashMap<String, Object>();
                city.put("id", provinceDate.get("cityId"));
                city.put("text", provinceDate.get("cityName"));
                city.put("value", provinceDate.get("cityCode"));
                cities.add(city);
            }
        }
        return provinces;
    }

    public Map<String, Object> compressImg() {
        Map<String, Object> m = new HashMap<String, Object>();
        String path = Config.getProperty("SAVE_SHIRT_IMG_PATH");
        File file = new File(path);
        String[] files = file.list();
        for (String fileName : files) {
            ImageUtils.aliResizeImg(path+fileName,
                    Config.getProperty("SAVE_FOCUS_COMPRESS_IMG_PATH")+fileName,
                    Integer.valueOf(Config.getProperty("IMG_WIDTH")),
                    Integer.valueOf(Config.getProperty("IMG_HEIGHT")));
        }
        m.put("flag", 0);
        return m;
    }

    private String uploadFile(MultipartFile imageFile, Long memberId) throws IOException {
        String originalFilename = imageFile.getOriginalFilename();
        String extFileName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String dateStr = DateUtils.dateToyyyyMMddHHmissWithSeparator(
                new Timestamp(new Date().getTime()));
        String newFileName = "member_" + memberId + "_" +
                new Random().nextInt(10000) + "_" + dateStr + extFileName;

        DownloadUtils.getFile(imageFile.getInputStream(), newFileName,
                Config.getProperty("SAVE_FOCUS_IMG_PATH"));
        ImageUtils.aliResizeImg(Config.getProperty("SAVE_FOCUS_IMG_PATH")+newFileName,
                Config.getProperty("SAVE_FOCUS_COMPRESS_IMG_PATH")+newFileName,
                Integer.valueOf(Config.getProperty("IMG_WIDTH")),
                Integer.valueOf(Config.getProperty("IMG_HEIGHT")));
        return newFileName;
    }
}
