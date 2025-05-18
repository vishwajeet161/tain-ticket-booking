package org.ticketBooking.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Train {
    private String trainId;
    private String trainNo;
    private List<List<Integer>> seats;
    @JsonProperty("station_times")
    private Map<String, String> stationTime;
    private List<String> stations;

    public Train(String trainId, String trainNo, List<List<Integer>> seats, Map<String, String> stationTime, List<String> stations){
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.seats = seats;
        this.stations = stations;
        this.stationTime = stationTime;
    }
    public Train(){

    }

    //getters

    public String getTrainId() {
        return this.trainId;
    }

    public String getTrainNo() {
        return this.trainNo;
    }

    public List<List<Integer>> getSeats() {
        return this.seats;
    }

    public List<String> getStations() {
        return this.stations;
    }
    public Map<String, String> getStationTimes() {
        return this.stationTime;
    }

    //setters


    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public void setStationTime(Map<String, String> stationTime) {
        this.stationTime = stationTime;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public String getTrainInfo(){
        return String.format("Train ID: %s TrainNo: %s", this.trainId, this.trainNo);
    }

}
