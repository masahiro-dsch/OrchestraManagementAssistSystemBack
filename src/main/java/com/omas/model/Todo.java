package com.omas.model;

import org.springframework.data.annotation.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    private Long id;

    private String description;

    private String details;

    private boolean done;

    // public Todo() {
    // }

    // public Todo(String description, String details, boolean done) {
    //     this.description = description;
    //     this.details = details;
    //     this.done = done;
    // }


    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getDescription() {
    //     return description;
    // }

    // public void setDescription(String description) {
    //     this.description = description;
    // }

    // public String getDetails() {
    //     return details;
    // }

    // public void setDetails(String details) {
    //     this.details = details;
    // }

    // public boolean isDone() {
    //     return done;
    // }

    // public void setDone(boolean done) {
    //     this.done = done;
    // }
}