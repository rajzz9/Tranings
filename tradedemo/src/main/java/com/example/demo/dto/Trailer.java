package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter@Getter
@NoArgsConstructor
public class Trailer {

	private List<TrailerInput> inTrailerInput;
	private List<TrailerOutput> inTrailerOutput;
}
