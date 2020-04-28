package com.spring.vardhan.service.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vardhan.service.model.Marks;
import com.spring.vardhan.service.services.StudentResultService;

@RestController
@RequestMapping("/results")
public class StudentResultServiceRest {
	
	@Autowired
	StudentResultService studentResultService;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public List<Marks> getAllStudentResult(){
		List<Marks> marksList = studentResultService.getAllStudentResults();
		System.out.println("getAllStudentResult: " + marksList);
		return marksList;
	}
	
	@GetMapping(value="/{id}")
	public Marks getStudentResults(@PathVariable("id") int id) {
		return studentResultService.getStudentResult(id);
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void addStudentResult(@RequestBody Marks marks) {
		studentResultService.addStudentResult(marks);
	}
	
	@PutMapping(value="/{id}")
	public void updatedStudentResult(@PathVariable("id")int id, @RequestBody Marks marks) {
		studentResultService.updateStudentResult(marks, id);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteStudentResult(@PathVariable("id")int id) {
		studentResultService.deleteStudentResult(id);
	}
	
	@GetMapping("/query")
	public List<Marks> getResultOfEnglish(@RequestParam("english") int value){
		return null;
	}
	
	@GetMapping("/queryMap")
	public List<Marks> getResultOfAll(@RequestParam Map<String, String> values){
		return null;
	}
	
	@GetMapping(value="/matrix/{id}")
	public List<Marks> getResultsUsingMatrixValues(@PathVariable("{id}")int id, @MatrixVariable("french") String french,
			@RequestHeader(name="X-match", defaultValue="test123") String headerVal ){
		System.out.println("Header value: "+  headerVal);
		return null;
	}
	
	@GetMapping("/matrix/{id}")
	public List<Marks> getResultsUsingMatrix(@PathVariable("{id}")int id, @MatrixVariable Map<String, String> values, @RequestHeader Map<String, String> headerValues){
		return null;
	}
	
}
