package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter@Getter
public class Trailer {

	private List<TrailerInput> inTrailerInput;
	private List<TrailerOutput> inTrailerOutput;
}
