package com.jarvis.focus.dto;

import java.util.Date;

/**
 * Created by Jarvis on 2016/5/21.
 */
public class MemberDTO {
    private Long id;
    private String name;
    private String weixinId;
    private String phoneNumber;
    private Integer gender;//1:男 2:女
    private String birth;
    private Integer age;
    private Double weight;
    private Double height;
    private Double targetWeight;
    private String avatarUrl;
    private Integer status;

    private CommonAddressDTO address;

    private String medicalHistory;
    private String dietExperience;
    private String dietPillExperience;
    private String sugaredDrinkRate;
    private String dineTogether;
    private String loseWeightTarget;
    private String oilyFood;

    private String productCode;
    private Long memberId;//For save member_apply_info

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(Double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getDietExperience() {
        return dietExperience;
    }

    public void setDietExperience(String dietExperience) {
        this.dietExperience = dietExperience;
    }

    public String getDietPillExperience() {
        return dietPillExperience;
    }

    public void setDietPillExperience(String dietPillExperience) {
        this.dietPillExperience = dietPillExperience;
    }

    public String getSugaredDrinkRate() {
        return sugaredDrinkRate;
    }

    public void setSugaredDrinkRate(String sugaredDrinkRate) {
        this.sugaredDrinkRate = sugaredDrinkRate;
    }

    public String getDineTogether() {
        return dineTogether;
    }

    public void setDineTogether(String dineTogether) {
        this.dineTogether = dineTogether;
    }

    public String getLoseWeightTarget() {
        return loseWeightTarget;
    }

    public void setLoseWeightTarget(String loseWeightTarget) {
        this.loseWeightTarget = loseWeightTarget;
    }

    public String getOilyFood() {
        return oilyFood;
    }

    public void setOilyFood(String oilyFood) {
        this.oilyFood = oilyFood;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public CommonAddressDTO getAddress() {
        return address;
    }

    public void setAddress(CommonAddressDTO address) {
        this.address = address;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
