package com.stevany;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class User {

  @NotBlank(message = "Phone number is mandatory")
  @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message="Phone number format must be international phone number with +")
  private String msisdn;

  @NotBlank(message = "Sim type is mandatory")
  @Pattern(regexp = "^PREPAID|POSTPAID$", message="Sim type must be PREPAID or POSTPAID")
  private String simType;

  @NotBlank(message="Name is mandatory")
  private String name;

  @NotNull(message = "Date of birth is mandatory")
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Past
  private Date dob;


  @NotBlank(message = "gender is mandatory")
  @Pattern(regexp = "^M|F$", message="gender must be M or F")
  private String gender;

  @NotBlank(message = "address is mandatory")
  @Size(min = 20, message="address must be > 20 character")
  private String address;

  @NotBlank(message = "id number is mandatory")
  @Pattern(regexp = "^[a-zA-Z0-9]+$", message="id number must be alphanumeric")
  private String idNumber;

  @Override
  public String toString() {
    return "User{" +
      "msisdn='" + msisdn + '\'' +
      ", simType='" + simType + '\'' +
      ", name='" + name + '\'' +
      ", dob=" + dob +
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

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
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

