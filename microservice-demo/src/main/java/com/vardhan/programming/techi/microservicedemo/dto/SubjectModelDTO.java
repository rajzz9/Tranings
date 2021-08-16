package com.vardhan.programming.techi.microservicedemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SubjectModelDTO {
    private String name;
    private String section;
    private String teacher;
}