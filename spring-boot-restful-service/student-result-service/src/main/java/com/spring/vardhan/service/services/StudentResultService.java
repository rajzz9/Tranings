package com.spring.vardhan.service.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.vardhan.service.model.Marks;

@Service
public class StudentResultService {

	private static final Map<Integer, Marks> marksMap = new HashMap<Integer, Marks>();
    static {
        marksMap.put(1, new Marks(100, 88, 83));
        marksMap.put(2, new Marks(55, 34, 78, 75, 65, 87));
        marksMap.put(3, new Marks(89, 45, 74, 45, 75, 48));
        marksMap.put(4, new Marks(64, 65, 89));
        marksMap.put(5, new Marks(29, 47, 53));
        marksMap.put(6, new Marks(81, 56, 78, 35, 45, 42));
        marksMap.put(7, new Marks(72, 91, 86));
        marksMap.put(8, new Marks(87, 73, 91));
        marksMap.put(9, new Marks(95, 92, 96, 45, 12, 41));
        marksMap.put(10, new Marks(86, 84, 98));
    }
    
    public List<Marks> getAllStudentResults(){
    	return new ArrayList<Marks>(marksMap.values());
    }
    
    public Marks getStudentResult(int id) {
    	return marksMap.get(id);
    }
    
    public void addStudentResult(Marks marks) {
    	marksMap.put(marksMap.size()+1, marks);
    }
    
    public void updateStudentResult(Marks marks, int id) {
    	marksMap.put(id, marks);
    }
    
    public void deleteStudentResult(int id) {
    	marksMap.remove(id);
    }
}
