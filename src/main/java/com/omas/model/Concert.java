package com.omas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Concert {
    @Id
    private Long id;

    private String title;

    private Date date;

    private String description;

    private String[] organization;
}