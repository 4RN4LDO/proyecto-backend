package com.proyecto_bases2.models;

public class Evento {

  private String date;
  private String time;
  private String place;

  public Evento(String date, String time, String place) {
    this.date = date;
    this.time = time;
    this.place = place;
  }

  public Evento(){}

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

}
