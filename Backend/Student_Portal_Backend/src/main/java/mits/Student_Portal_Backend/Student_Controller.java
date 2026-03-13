package mits.Student_Portal_Backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin(origins="http://localhost:5173/")
public class Student_Controller {

	private final Student_Service ss;
	public Student_Controller(Student_Service ser)
	{
		this.ss=ser;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody Student1 user)
	{
		ss.register(user);
		return "User registered successfully";
			
	}
	@PostMapping("/login")
	public String login(@RequestBody Student1 user)
	{
		return ss.login(user.getEmail(), user.getPassword())!=null ? "Login Successful" : "Invalid Credentials";
	}
	
	//retrieve
	@GetMapping("/users")
	public List<Student1>getallusers(){
		return ss.allusers();
	}
	
	//update
	@PutMapping("/update/{id}")
	public Student1 updatestu(@PathVariable Long id,@RequestBody Student1 st) {
		return ss.updateStudent1(id,st);
		
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public String deletestud(@PathVariable Long id) {
		ss.deleteStudent1(id);
		return "Deleted Successfully";
	}
}
