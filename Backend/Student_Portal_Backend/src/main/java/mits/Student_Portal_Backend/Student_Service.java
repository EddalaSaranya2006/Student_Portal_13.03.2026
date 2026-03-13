package mits.Student_Portal_Backend;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Student_Service {

	
	private final Student_Repo sr;
	
	
	public Student_Service(Student_Repo repo)
	{
		this.sr=repo;
	}
	
	//insertion 
	//register
	public Student1 register(Student1 stu)
	{
		return sr.save(stu);
	}
	//login
	public Student1 login(String email, String password)
	{
		Student1 user=sr.findByEmail(email);
		return (user!=null && user.getPassword().equals(password))?user: null;
	}
	
	//retrieve
	public List<Student1>allusers(){
		return sr.findAll();
	}
	
	//update
	public Student1 updateStudent1(Long id, Student1 s)
	{
		Student1 existing=sr.findById(id).orElse(null);
		if(existing !=null) {
			existing.setName(s.getName());
			existing.setEmail(s.getEmail());
			existing.setPassword(s.getPassword());
			
			return sr.save(existing);
		}
		return null;
	}
	
	//delete
	
		public void deleteStudent1(Long id) {
			sr.deleteById(id);
		}
}

