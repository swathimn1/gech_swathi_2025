//package springbootdatajpa;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class StudentConfiguration {
//	private final StudentRepository studentRepository;
//
//	public StudentConfiguration(StudentRepository studentRepository) {
//		super();
//		this.studentRepository = studentRepository;
//	}
//
//	@Bean("student1")
//	public Student student1() {
//		Student std1 = new Student("swathi", 21, "swathi@gmail.com");
//		return studentRepository.save(std1);
//	}
//
////	
////	@Bean("student2")
////	public Student student2() {
////		Student std2 = new Student("varshi", 23, "varshi@gmail.com");
////		return studentRepository.save(std2);
////	}
//
////	@Bean
////	CommandLineRunner initDatabase() {
////
////		return args -> {
////			Student std1 = new Student("swathi", 21, "swathi@gmail.com");
////			Student std2 = new Student("varshi", 23, "varshi@gmail.com");
////			studentRepository.save(std1);
////			studentRepository.save(std2);
////
////		};
////	}
//
//	// saveAll
//	@Bean
//	public List<Student> saveAll() {
//		List<Student> students = List.of(new Student("varshi", 23, "varshi@gmail.com"),
//				new Student("praju", 19, "praju@gmail.com")
//
//		);
//
//		return studentRepository.saveAll(students);
//	}
//
//	// findAll
//	@Bean
//	public List<Student> findAll() {
//		return studentRepository.findAll();
//	}
//
//	// findById
//	@Bean
//	public Optional<Student> findById() {
//		return studentRepository.findById(1);
//
//	}
//
//	// findAllById
//	@Bean
//	public List<Student> findByIds() {
//		return studentRepository.findAllById(List.of(1, 2));
//	}
//
//	// count
//	public long countStudents() {
//		return studentRepository.count();
//	}
//
//	// existsById
//	public boolean existsbyId() {
//		return studentRepository.existsById(1);
//	}
//
//	// deleteById
//	public String deleteById() {
//		studentRepository.deleteById(1);
//		return "Student deleted with Id 1";
//	}
////	
//
//}
