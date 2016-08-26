package com.proyecto_bases2.models;

import com.google.gson.JsonObject;

public class Genre {

  private String id;
  private String name;

  public JsonObject toJson(){
    JsonObject genre = new JsonObject();
    genre.addProperty("id", getId());
    genre.addProperty("name", getName());

    return genre;
  }

  public Genre(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Genre(){}

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
