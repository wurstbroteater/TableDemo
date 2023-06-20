package de.ufo.tracktable;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Data model for an Unidentified Flying Object (UFO). A UFO is any perceived aerial phenomenon that cannot be
 * immediately identified or explained.
 */
public class UFO {
    private final SimpleStringProperty uuid;
    private final SimpleStringProperty tempName;
    private final SimpleBooleanProperty isInRange;
    private final SimpleDoubleProperty latitude;
    private final SimpleDoubleProperty longitude;
    private final SimpleDoubleProperty altitude;
    private final SimpleStringProperty detector;
    private final SimpleStringProperty lastUpdate;
    private final SimpleLongProperty usdValue;

    public UFO(String uuid, String tempName, boolean isInRange, double latitude, double longitude, double altitude,
               String detector, String lastUpdate, long usdValue) {
        this.uuid = new SimpleStringProperty(uuid);
        this.tempName = new SimpleStringProperty(tempName);
        this.isInRange = new SimpleBooleanProperty(isInRange);
        this.latitude = new SimpleDoubleProperty(latitude);
        this.longitude = new SimpleDoubleProperty(longitude);
        this.altitude = new SimpleDoubleProperty(altitude);
        this.detector = new SimpleStringProperty(detector);
        this.lastUpdate = new SimpleStringProperty(lastUpdate);
        this.usdValue = new SimpleLongProperty(usdValue);
    }

    public String getUuid() {
        return uuid.get();
    }

    public void setUuid(String val) {
        uuid.set(val);
    }

    public String getTempName() {
        return tempName.get();
    }

    public void setTempName(String val) {
        tempName.set(val);
    }

    public boolean isIsInRange() {
        return isInRange.get();
    }


    public void setIsInRange(boolean isInRange) {
        this.isInRange.set(isInRange);
    }

    public double getLatitude() {
        return latitude.get();
    }

    public void setLatitude(double latitude) {
        this.latitude.set(latitude);
    }

    public double getLongitude() {
        return longitude.get();
    }


    public void setLongitude(double longitude) {
        this.longitude.set(longitude);
    }

    public double getAltitude() {
        return altitude.get();
    }


    public void setAltitude(double altitude) {
        this.altitude.set(altitude);
    }

    public String getDetector() {
        return detector.get();
    }

    public void setDetector(String detector) {
        this.detector.set(detector);
    }

    public String getLastUpdate() {
        return lastUpdate.get();
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate.set(lastUpdate);
    }

    public long getUsdValue() {
        return usdValue.get();
    }

    public void setUsdValue(long usdValue) {
        this.usdValue.set(usdValue);
    }
}
