package com.proyecto_bases2.models;

public class Instrumet {

  private String id;
  private String name;

  public Instrumet(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Instrumet(){}

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

}
