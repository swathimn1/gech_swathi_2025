package studentcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import studentcrud.dto.StudentDTO;
import studentcrud.model.Student;
import studentcrud.repository.StudentRepository;
import studentcrud.service.StudentService;

@Controller
public class StudentController {
	private final StudentService studentService;
	private final StudentRepository studentRepository;

	public StudentController(StudentService studentService, StudentRepository studentRepository) {
		super();
		this.studentService = studentService;
		this.studentRepository = studentRepository;
	}

	@GetMapping({ "/", "" })
	public String getAllStudents(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "students/students";

	}

	@GetMapping("/add-student")
	public String addStudent(Model model) {
		StudentDTO studentDTO = new StudentDTO();
		model.addAttribute("studentDTO", studentDTO);
		return "students/add_students";
	}

	@PostMapping("/add-student")
	public String SaveStudent(@ModelAttribute StudentDTO studentDTO) {
		studentService.saveStudent(studentDTO);
		return "redirect:/";
	}

	@GetMapping("/edit-student")
	public String editStudent(@RequestParam Long id, Model model) {
		StudentDTO studentDTO = studentService.editStudent(id);
		Student student = studentRepository.findById(id).get();
		model.addAttribute("student", student);
		model.addAttribute("studentDTO", studentDTO);
		return "students/edit_students";
	}

	@PostMapping("/edit-student")
	public String updateStudent(@ModelAttribute StudentDTO studentDTO, @RequestParam Long id,
			RedirectAttributes attributes) {
		Optional<Student> student = studentRepository.findByEmail(studentDTO.getEmail());
		studentService.updateStudent(studentDTO, id);
		attributes.addFlashAttribute("success", "student edited successfully");
		return "redirect:/";

	}

	@GetMapping("/delete-student")
	public String deleStudent(@RequestParam Long id, RedirectAttributes attributes) {
		studentService.deleteStudent(id);
		attributes.addFlashAttribute("success", "student deleted successfully");
		return "redirect:/";

	}
}
