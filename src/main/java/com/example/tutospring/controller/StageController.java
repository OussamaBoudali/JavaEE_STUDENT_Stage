package com.example.tutospring.controller;

import com.example.tutospring.model.Stage;
import com.example.tutospring.model.Student;
import com.example.tutospring.service.StageService;
import com.example.tutospring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getAllStages(Model model) {
        List<Stage> stages = stageService.getAllStages();
        model.addAttribute("stages", stages);
        return "stages_list";
    }

    @GetMapping("/add")
    public String showAddStageForm(Model model) {
        model.addAttribute("stage", new Stage());
        model.addAttribute("students", studentService.getAllStudents());
        return "add_stage";
    }

    @PostMapping("/add")
    public String addStage(@ModelAttribute("stage") Stage stage, @RequestParam("student") Long studentId) {
        Student student = new Student();
        student.setId(studentId);
        stage.setStudent(student);
        stageService.saveStage(stage);
        return "redirect:/stages";
    }

    @GetMapping("/edit/{id}")
    public String showEditStageForm(@PathVariable Long id, Model model) {
        Stage stage = stageService.getStageById(id);
        model.addAttribute("stage", stage);
        model.addAttribute("students", studentService.getAllStudents());
        return "edit_stage";
    }

    @PostMapping("/edit/{id}")
    public String editStage(@PathVariable Long id, @ModelAttribute("stage") Stage stage, @RequestParam("student") Long studentId) {
        Student student = new Student();
        student.setId(studentId);
        stage.setStudent(student);
        stageService.updateStage(id, stage);
        return "redirect:/stages";
    }

    @GetMapping("/delete/{id}")
    public String deleteStage(@PathVariable Long id) {
        stageService.deleteStage(id);
        return "redirect:/stages";
    }
}
