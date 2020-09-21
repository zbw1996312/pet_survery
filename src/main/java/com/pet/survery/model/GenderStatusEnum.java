package com.pet.survery.model;

public enum GenderStatusEnum {
    /**
     * 性别属性
     */
    GENDER_NONE(0),
    GENDER_FEMALE(1),
    GENDER_MALE(2);

    private int genderCode;

    GenderStatusEnum(int genderCode) {
        this.genderCode = genderCode;
    }
    public int getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(int genderCode) {
        this.genderCode = genderCode;
    }

    @Override
    public String toString() {
        return "GenderStatusEnum{" +
                "genderCode=" + genderCode +
                '}';
    }
}
