package com.vardhan.programming.techi.microservicedemo.model.mapper;

import com.vardhan.programming.techi.microservicedemo.dto.AppModelDTO;
import com.vardhan.programming.techi.microservicedemo.model.AppModel;
import com.vardhan.programming.techi.microservicedemo.model.StudentModel;
import com.vardhan.programming.techi.microservicedemo.model.SubjectModel;

public class AppModelMapper {

    public AppModel mapToModel(AppModelDTO dto) {
        return new AppModel()
                .setStudent(
                        new StudentModel()
                                .setLname(dto.getStudent().getLname())
                                .setFname(dto.getStudent().getFname())
                                .setDob(dto.getStudent().getDob())
                )
                .setSubject(
                        new SubjectModel()
                                .setName(dto.getSubject().getName())
                                .setSection(dto.getSubject().getSection())
                                .setTeacher(dto.getSubject().getTeacher())
                );
    }
}