package com.example.schoolERP.project.controller;

import com.example.schoolERP.project.model.UploadResults;
import com.example.schoolERP.project.repository.UploadResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/faculty/uploadResults")
public class UploadResultsController {

    private final UploadResultsRepository uploadResultsRepository;

    @Autowired
    public UploadResultsController(UploadResultsRepository uploadResultsRepository) {
        this.uploadResultsRepository = uploadResultsRepository;
    }

    // View all results
    @GetMapping
    public String viewAllResults(Model model) {
        List<UploadResults> results = uploadResultsRepository.findAll();
        model.addAttribute("results", results);
        return "faculty/uploadresults/view_results";
    }

    // Show form to add result
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("uploadResult", new UploadResults());
        return "faculty/uploadresults/add_result";
    }

    // Handle add result form submission
    @PostMapping("/add")
    public String saveResult(@ModelAttribute UploadResults uploadResult) {
        uploadResultsRepository.save(uploadResult);
        return "redirect:/faculty/uploadResults";
    }

    // Show form to edit result
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        UploadResults result = uploadResultsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid result ID: " + id));
        model.addAttribute("uploadResult", result);
        return "faculty/uploadresults/edit_result";
    }

    // Handle update result form submission
    @PostMapping("/edit/{id}")
    public String updateResult(@PathVariable("id") Long id,
                               @ModelAttribute UploadResults updatedResult) {
        UploadResults existing = uploadResultsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid result ID: " + id));

        existing.setName(updatedResult.getName());
        existing.setMarks(updatedResult.getMarks());
        existing.setGrade(updatedResult.getGrade());

        uploadResultsRepository.save(existing);
        return "redirect:/faculty/uploadResults";
    }

    // Delete result
    @GetMapping("/delete/{id}")
    public String deleteResult(@PathVariable("id") Long id) {
        UploadResults result = uploadResultsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid result ID: " + id));
        uploadResultsRepository.delete(result);
        return "redirect:/faculty/uploadResults";
    }
}
