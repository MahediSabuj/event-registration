package com.ms29.event.registration.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter @Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String eventName;

    private String eventDescription;

    private String eventLocation;

    private LocalDateTime eventStartDatetime;

    private LocalDateTime eventEndDatetime;

    private LocalDateTime registrationStartDatetime;

    private LocalDateTime registrationEndDatetime;
}
