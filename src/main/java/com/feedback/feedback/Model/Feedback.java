package com.feedback.feedback.Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name="feedback")
public class Feedback {

    @Id
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="street_address")
    private String streetAddress;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="zip")
    private int zip;

    @Column(name="telephone")
    private String telephone;

    @Column(name="email")
    private String email;

    @Column(name="date_of_survey")
    private Date dateOfSurvey;

    @Column(name="likes", columnDefinition="json")
    @Convert(converter = DataConverter.class)
    private String[] likes;

    @Column(name="interests")
    private String interest;

    @Column(name="recommendation")
    private String recommendation;

    @Column(name="comments")
    private String comments;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(Date dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public String[] getLikes() {
        return likes;
    }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return id == feedback.id && zip == feedback.zip && Objects.equals(firstName, feedback.firstName) && Objects.equals(lastName, feedback.lastName) && Objects.equals(streetAddress, feedback.streetAddress) && Objects.equals(city, feedback.city) && Objects.equals(state, feedback.state) && Objects.equals(telephone, feedback.telephone) && Objects.equals(email, feedback.email) && Objects.equals(dateOfSurvey, feedback.dateOfSurvey) && Arrays.equals(likes, feedback.likes) && Objects.equals(interest, feedback.interest) && Objects.equals(recommendation, feedback.recommendation) && Objects.equals(comments, feedback.comments);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, firstName, lastName, streetAddress, city, state, zip, telephone, email, dateOfSurvey, interest, recommendation, comments);
        result = 31 * result + Arrays.hashCode(likes);
        return result;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", dateOfSurvey=" + dateOfSurvey +
                ", likes=" + Arrays.toString(likes) +
                ", interest='" + interest + '\'' +
                ", recommendation='" + recommendation + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
