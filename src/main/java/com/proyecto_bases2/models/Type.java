package com.proyecto_bases2.models;


import com.google.gson.JsonObject;

public class Type {

  private String id;
  private String name;

  public JsonObject toJson(){
    JsonObject type = new JsonObject();
    type.addProperty("id", getId());
    type.addProperty("name", getName());

    return type;
  }

  public Type(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Type() {}

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
