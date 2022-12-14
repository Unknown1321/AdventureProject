package com.example.adventure.activity.model;

import com.example.adventure.booking.model.Booking;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ACTIVITY")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "HOURLY_RATE")
    private Double hourPrice;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MIN_AGE")
    @Min(value = 12,message = "Age cannot be less than 12")
    private Integer minAge;

    @Column(name = "DESC")
    private String description;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

    public Activity(double hourPrice, String name, int minAge, String description) {
        this.hourPrice = hourPrice;
        this.name = name;
        this.minAge = minAge;
        this.description = description;
    }

    public Activity updateWith(Activity activity){
        this.hourPrice = activity.hourPrice;
        this.name = activity.name;
        this.minAge = activity.minAge;
        this.description = activity.description;
        return this;
    }

}