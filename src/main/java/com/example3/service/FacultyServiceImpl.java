package com.example3.service;

import com.example3.exception.FacultyNotFoundException;
import com.example3.model.Faculty;
import com.example3.model.Student;
import com.example3.repository.FacultyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private String name;
    Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty addFaculty(Faculty faculty) {
        logger.info("Was invoked method for to create faculty");
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty findFaculty(long id) {
        logger.error("Was invoked method for to find faculty by id" + id);
        return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException("Faculty not found"));

    }

    @Override
    public Faculty editFaculty(long id, Faculty faculty) {
        logger.info("Was invoked method for to edit faculty");
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(long id) {
        logger.info("Was invoked method for to delete faculty by id");
        facultyRepository.deleteById(id);
    }

    public Faculty findByName() {
        return facultyRepository.findByName(name);
    }
    public Collection<Faculty> findAllByColor (String color){
        logger.info("Was invoked method for to find all faculties by color");
        return facultyRepository.findAllByColor(color);
    }

    public Collection<Faculty>getAllFaculty(){
        logger.info("Was invoked method for to get all faculties");
        return facultyRepository.findAll();
    }

    @Override
    public Collection<Faculty> getFilterByColor (String color){
        logger.info("Was invoked method search for filtered faculties by color");
        return facultyRepository.findAllByColor(color);
    }
    public Faculty getFilterByName (String name){
        return facultyRepository.findByName(name);
    }

    @Override
    public Faculty getFacultyById(Long id) {
        logger.error("Was invoked method for get faculties by id"+id);
        return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException("Faculty not found"));
    }


    @Override
    public Faculty editFaculty(Long id, Faculty faculty){
        logger.info("Was invoked method for to edit faculty");
        Faculty existing = (Faculty) getFacultyById(id);
        existing.setColor(faculty.getColor());
        existing.setName(faculty.getName());
        facultyRepository.save(faculty);
        return existing;
    }

    public Collection<Student> findStudent(String name) {
        logger.info("Was invoked method for to find all student by faculty");
        return facultyRepository.findByName(name).getStudents();
    }
}