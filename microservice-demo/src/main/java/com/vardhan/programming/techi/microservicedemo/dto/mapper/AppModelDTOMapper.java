package com.vardhan.programming.techi.microservicedemo.dto.mapper;

import com.vardhan.programming.techi.microservicedemo.controller.request.AppRequest;
import com.vardhan.programming.techi.microservicedemo.dto.AppModelDTO;
import com.vardhan.programming.techi.microservicedemo.dto.StudentModelDTO;
import com.vardhan.programming.techi.microservicedemo.dto.SubjectModelDTO;

import java.util.ArrayList;
import java.util.List;


public class AppModelDTOMapper {

    public AppModelDTO mapToDTO(AppRequest request) {
        return new AppModelDTO()
                .setStudent(
                        new StudentModelDTO()
                                .setLname(request.getStudent().getLname())
                                .setFname(request.getStudent().getFname())
                                .setDob(request.getStudent().getDob())
                )
                .setSubject(
                        new SubjectModelDTO()
                                .setName(request.getSubject().getName())
                                .setSection(request.getSubject().getSection())
                                .setTeacher(request.getSubject().getTeacher())
                );
    }

    public AppModelDTO mapToDTO(Object obj) {
        return new AppModelDTO();
    }

    public List<AppModelDTO> mapToDTOs(Object obj) {
        return new ArrayList<>();
    }
}