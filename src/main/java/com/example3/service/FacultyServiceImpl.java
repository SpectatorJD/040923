package com.example3.service;

import com.example3.exception.FacultyNotFoundException;
import com.example3.model.Faculty;
import com.example3.model.Student;
import com.example3.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    private String name;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException("Faculty not found"));

    }

    @Override
    public Faculty editFaculty(long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Faculty findByName() {
        return facultyRepository.findByName(name);
    }
    public Collection<Faculty> findAllByColor (String color){
        return facultyRepository.findAllByColor(color);
    }
    /* public Collection<Faculty> findAllByNameContains (String part){
         return facultyRepository.findAllByNameContains(part);
     }*/
    public Collection<Faculty>getAllFaculty(){
        return facultyRepository.findAll();
    }
    /*@Override
        public Collection<Faculty> getFilterByColor (String color){
            return getAllFaculty().stream().filter( f-> f.getColor().equals(color)).toList();
        }*/
    @Override
    public Collection<Faculty> getFilterByColor (String color){
        return facultyRepository.findAllByColor(color);
    }
    public Faculty getFilterByName (String name){
        return facultyRepository.findByName(name);
    }

    @Override
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException("Faculty not found"));
    }


    @Override
    public Faculty editFaculty(Long id, Faculty faculty){
        Faculty existing = (Faculty) getFacultyById(id);
        existing.setColor(faculty.getColor());
        existing.setName(faculty.getName());
        facultyRepository.save(faculty);
        return existing;
    }

    public Collection<Student> findStudent(String name) {
        return facultyRepository.findByName(name).getStudents();
    }
}