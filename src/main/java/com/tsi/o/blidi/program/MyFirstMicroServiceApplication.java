package com.tsi.o.blidi.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@CrossOrigin(origins = "*")// needed for receiving request via api
@RestController // handles GET POST DELETE PUT requests
@RequestMapping("/home") //base url
public class MyFirstMicroServiceApplication {

	@Autowired
	private ActorRepository actorRepository;
	private String saved = "saved";

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroServiceApplication.class, args);
	}

	public MyFirstMicroServiceApplication(ActorRepository actorRepository){

		this.actorRepository = actorRepository;
	}

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getALLActors(){
		return actorRepository.findAll();

	}
	@PostMapping("/add_Actor")
	public @ResponseBody String addActor(@RequestParam String first_name, String last_name){
		Actor addActor = new Actor(first_name,last_name);
		actorRepository.save(addActor);
		return saved;
	}

	@DeleteMapping("/actors")
	public @ResponseBody String deleteActorById(@RequestParam int actor_id){
		actorRepository.deleteById(actor_id);
		return "Deleted Successfully";
	}

	@PutMapping("/update_Actor")
	public @ResponseBody String updateActor(@RequestParam int actor_id,String first_name,String last_name){
		Actor updateActor = actorRepository.findById(actor_id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with id: " + actor_id));
		updateActor.setFirst_name(first_name);
		updateActor.setLast_name(last_name);
		actorRepository.save(updateActor);
		return "Updated Successfully";

	}



}
