package com.stevany;

import com.opencsv.bean.CsvBindByPosition;

public class UserDTO {
  @CsvBindByPosition(position = 0)
  private String msisdn;
  @CsvBindByPosition(position = 1)
  private String simType;
  @CsvBindByPosition(position = 2)
  private String name;
  @CsvBindByPosition(position = 3)
  private String dob;
  @CsvBindByPosition(position = 4)
  private String gender;
  @CsvBindByPosition(position = 5)
  private String address;
  @CsvBindByPosition(position = 6)
  private String idNumber;

  @Override
  public String toString() {
    return "UserDTO{" +
      "msisdn='" + msisdn + '\'' +
      ", simType='" + simType + '\'' +
      ", name='" + name + '\'' +
      ", dob='" + dob + '\'' +
      ", gender='" + gender + '\'' +
      ", address='" + address + '\'' +
      ", idNumber='" + idNumber + '\'' +
      '}';
  }

  public String getMsisdn() {
    return msisdn;
  }

  public void setMsisdn(String msisdn) {
    this.msisdn = msisdn;
  }

  public String getSimType() {
    return simType;
  }

  public void setSimType(String simType) {
    this.simType = simType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }
}
