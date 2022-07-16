package com.example.advancedoopproject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PatientRecords {

    public ObjectProperty<String> Patient_No =  new SimpleObjectProperty<>();
    public ObjectProperty<String> Patient_id =  new SimpleObjectProperty<>();
    public ObjectProperty<String> FName =  new SimpleObjectProperty<>();
    public ObjectProperty<String> LName =  new SimpleObjectProperty<>();
    public ObjectProperty<String> Sex =  new SimpleObjectProperty<>();
    public ObjectProperty<String> PhoneNo = new SimpleObjectProperty<>();
    //public ObjectProperty<String> password = new SimpleObjectProperty<>();

    public String getPatient_No() {
        return Patient_No.get();
    }
    public void setPatient_No(ObjectProperty<String> Patient_No) {
        this.Patient_No = Patient_No;
    }

    public String getPatient_id() {
        return Patient_id.get();
    }
    public void setPatient_id(ObjectProperty<String> Patient_id) {
        this.Patient_id = Patient_id;
    }

    public String getFName() {
        return FName.get();
    }
    public void setFName(ObjectProperty<String> FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName.get();
    }
    public void setLName(ObjectProperty<String> LName) {
        this.LName = LName;
    }

    public String getSex() {
        return Sex.get();
    }
    public void setSex(ObjectProperty<String> Sex) {
        this.Sex = Sex;
    }

    public String getPhoneNo() {
        return PhoneNo.get();
    }
    public void setPhoneNo(ObjectProperty<String> PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    /*public String getPassword() {
        return password.get();
    }
    public void setPassword(ObjectProperty<String> password) {
        this.password = password;
    }*/
}
