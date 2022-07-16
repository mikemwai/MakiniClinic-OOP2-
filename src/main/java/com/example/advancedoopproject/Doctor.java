/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.advancedoopproject;

import java.sql.Date;
import java.sql.Time;

public class Doctor {
    public Date appointment;
   public  int patient_id;
    public String phoneNo;
    public int doctor_id;
    public int appointmentID;
    public Time time;

    public String patientName;

    public Doctor(Date appointment, int patient_id, String phoneNo, int doctor_id, int appointmentID, Time time, String patientName) {
        this.appointment = appointment;
        this.patient_id = patient_id;
        this.phoneNo = phoneNo;
        this.doctor_id = doctor_id;
        this.appointmentID = appointmentID;
        this.time = time;
        this.patientName = patientName;
    }



}