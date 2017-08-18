package com.minorius.travel.realm;

import io.realm.RealmObject;

/**
 * Created by minorius on 17.08.2017.
 */

public class TrainSmilaCherkasyRealm extends RealmObject{
    private String number;
    private String direction;

    private String timeFrom;
    private String timeTo;

    private String time;

    public TrainSmilaCherkasyRealm(String number, String direction, String timeFrom, String timeTo, String time) {
        this.number = number;
        this.direction = direction;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.time = time;
    }

    public TrainSmilaCherkasyRealm() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Train{" +
                "number='" + number + '\'' +
                ", direction='" + direction + '\'' +
                ", timeFrom='" + timeFrom + '\'' +
                ", timeTo='" + timeTo + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
