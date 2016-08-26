package com.proyecto_bases2.models;

public class ClientEvent {

  private String date;
  private String time;
  private String place;
  private String stat;

  public ClientEvent(String date, String time, String place, String stat) {
    this.date = date;
    this.time = time;
    this.place = place;
    this.stat = stat;
  }

  public ClientEvent(){}

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

  public String getStat() {
    return stat;
  }

  public void setStat(String stat) {
    this.stat = stat;
  }
}
