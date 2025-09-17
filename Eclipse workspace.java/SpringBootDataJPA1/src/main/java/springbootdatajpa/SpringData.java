package springbootdatajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringData {

	private final SpringBootDataJpa1Application springBootDataJpa1Application;
	@Autowired
	StudentRepository repository;

	SpringData(SpringBootDataJpa1Application springBootDataJpa1Application) {
		this.springBootDataJpa1Application = springBootDataJpa1Application;
	}

	// save methods
//	public void addStudent() {
//		Student st = new Student("swathi", 21, "swathi1@gmail.com");
//		repository.save(st);
//		
//	}
	public List<Student> saveAllStudents() {
		List<Student> students = List.of(new Student("varshi", 23, "varshi@gmail.com"),
				new Student("praju", 19, "praju@gmail.com"));
		return repository.saveAll(students);
	}

//	public void getStudent() {
//		Student st = repository.findById(1).get();
//		System.out.println(st);
//
//	}

	// findBy methods
	public List<Student> findAll() {
		Student st = new Student("swathi", 21, "swathi@gmail.com");
		Student st1 = new Student("varshi", 22, "varshi@gmail.com");
		repository.save(st);
		repository.save(st1);
		return repository.findAll();

	}

	public Optional<Student> findById() {
		return repository.findById(1);
	}

	public void findByEmail() {
		Student st = repository.findByEmail("swathi@gmail.com");
		System.out.println(st);
	}
	
	//existsById()
	public Boolean existsById() {
		return repository.existsById(1);
	}
	
	public long count() {
		return repository.count();
	}

	// delete methods
	public String deleteById() {
		repository.deleteById(1);
		return "student deleted successfully";
	}

	public String deleteAll() {
		repository.deleteAll();
		return "All Students deleted";
	}

	public void deleAllStudents() {
		repository.deleteAllById(List.of(1, 2));
	}
	
	public String deleteAllByIds() {
	    repository.deleteAllById(List.of(1L, 2L));
	    return "Deleted multiple students";
	}
	
	

}
