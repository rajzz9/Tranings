package com.vardhan.programming.techi.microservicedemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AppModelDTO {
    private StudentModelDTO student;
    private SubjectModelDTO subject;
}