package com.example.advancedoopproject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class OutPatientRecords {

    public ObjectProperty<String> Patient_No =  new SimpleObjectProperty<>();
    public ObjectProperty<String> Patient_id =  new SimpleObjectProperty<>();
    public ObjectProperty<String> FName =  new SimpleObjectProperty<>();
    public ObjectProperty<String> LName =  new SimpleObjectProperty<>();
    public ObjectProperty<String> Sex =  new SimpleObjectProperty<>();
    public ObjectProperty<String> Illness = new SimpleObjectProperty<>();
    public ObjectProperty<String> Doctor_id = new SimpleObjectProperty<>();
    public ObjectProperty<String> Discharged = new SimpleObjectProperty<>();

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

    public String getIllness() {
        return Illness.get();
    }
    public void setIllness(ObjectProperty<String> illness) {
        this.Illness = illness;
    }

    public String getDoctor_id() {
        return Doctor_id.get();
    }
    public void setDoctor_id(ObjectProperty<String> doctor_id) {
        this.Doctor_id = doctor_id;
    }

    public String getDischarged() {
        return Discharged.get();
    }
    public void setDischarged(ObjectProperty<String> discharged) {
        this.Discharged = discharged;
    }
}
