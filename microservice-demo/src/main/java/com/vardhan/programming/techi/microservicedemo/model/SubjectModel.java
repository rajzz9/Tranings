package com.vardhan.programming.techi.microservicedemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SubjectModel {
    private String name;
    private String section;
    private String teacher;
}