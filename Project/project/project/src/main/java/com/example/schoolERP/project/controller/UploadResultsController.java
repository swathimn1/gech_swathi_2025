package com.example.schoolERP.project.controller;

import com.example.schoolERP.project.dto.UploadResultsDTO;
import com.example.schoolERP.project.service.UploadResultsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/faculty/uploadresults")
public class UploadResultsController {

    @Autowired
    private UploadResultsService uploadResultsService;

    // View all results
    @GetMapping
    public String viewAllResults(Model model) {
        List<UploadResultsDTO> results = uploadResultsService.getAllResults();
        model.addAttribute("results", results);
        return "faculty/uploadresults/view_results";
    }

    // Show form to add result
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("uploadResult", new UploadResultsDTO());
        return "faculty/uploadresults/add_result";
    }

    // Handle add result form submission
    @PostMapping("/add")
    public String saveResult(@Valid @ModelAttribute("uploadResult") UploadResultsDTO uploadResultDTO,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "faculty/uploadresults/add_result";
        }
        uploadResultsService.saveResult(uploadResultDTO);
        return "redirect:/faculty/uploadresults";
    }

    // Show form to edit result
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        UploadResultsDTO dto = uploadResultsService.getResultById(id);
        model.addAttribute("uploadResult", dto);
        return "faculty/uploadresults/edit_result";
    }

    // Handle update result form submission
    @PostMapping("/edit/{id}")
    public String updateResult(@PathVariable("id") Long id,
                               @Valid @ModelAttribute("uploadResult") UploadResultsDTO updatedDTO,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "faculty/uploadresults/edit_result";
        }
        updatedDTO.setId(id); // Ensure ID is set for update
        uploadResultsService.saveResult(updatedDTO);
        return "redirect:/faculty/uploadresults";
    }

    // Delete result
    @GetMapping("/delete/{id}")
    public String deleteResult(@PathVariable("id") Long id) {
        uploadResultsService.deleteResult(id);
        return "redirect:/faculty/uploadresults";
    }
}
