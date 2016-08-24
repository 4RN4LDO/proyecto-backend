package com.proyecto_bases2.models;

public class Client {

  private String id;
  private String name;
  private String firstLastName;
  private String secondLastName;
  private String phone;
  private String email;
  private String status;

  public Client(String id, String name, String firstLastName, String secondLastName, String phone, String email, String status) {
    this.id = id;
    this.name = name;
    this.firstLastName = firstLastName;
    this.secondLastName = secondLastName;
    this.phone = phone;
    this.email = email;
    this.status = status;
  }

  public Client() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstLastName() {
    return firstLastName;
  }

  public void setFirstLastName(String firstLastName) {
    this.firstLastName = firstLastName;
  }

  public String getSecondLastName() {
    return secondLastName;
  }

  public void setSecondLastName(String secondLastName) {
    this.secondLastName = secondLastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
