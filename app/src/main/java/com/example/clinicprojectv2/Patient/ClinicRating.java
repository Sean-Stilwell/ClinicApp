package com.example.clinicprojectv2.Patient;

import com.example.clinicprojectv2.Clinic.Clinic;

public class ClinicRating {

    private String id;
    private Clinic clinic;
    private Patient patient;
    private int rating;
    private String comment;

    public ClinicRating() {}

    /**
     * This method constructs an instance of an employee account.
     * @param id the rating's unique ID
     * @param clinic the clinic being rated
     * @param patient the patient rating the clinic
     * @param rating the patient's rating of the clinic (1 to 5)
     * @param comment the optional comment associated with the patient's rating
     */
    public ClinicRating(String id, Clinic clinic, Patient patient, int rating, String comment) {
        this.id = id;
        this.clinic = clinic;
        this.patient = patient;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and setters

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Clinic getClinic() {
        return this.clinic;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }
}
