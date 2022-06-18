package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.Actor.Actor;
import com.tsi.o.blidi.program.Actor.ActorRepository;
import com.tsi.o.blidi.program.Category.Category;
import com.tsi.o.blidi.program.Category.CategoryRepository;
import com.tsi.o.blidi.program.Film.Film;
import com.tsi.o.blidi.program.Film.FilmRepository;
import com.tsi.o.blidi.program.FilmActor.FilmActorRepository;
import com.tsi.o.blidi.program.FilmCategory.FilmCategoryRepository;
import com.tsi.o.blidi.program.Language.Language;
import com.tsi.o.blidi.program.Language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@CrossOrigin(origins = "*")// needed for receiving request via api
@RestController // handles GET POST DELETE PUT requests
@RequestMapping("/home") //base url
public class MyFirstMicroServiceApplication {

	@Autowired
	private ActorRepository actorRepository;
	private String saved = "saved";
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private FilmActorRepository filmActorRepository;
	@Autowired
	private FilmCategoryRepository filmCategoryRepository;
	@Autowired
	private LanguageRepository languageRepository;


	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroServiceApplication.class, args);
	}

	public MyFirstMicroServiceApplication(
			ActorRepository actorRepository,
			CategoryRepository categoryRepository,
			FilmRepository filmRepository,
			FilmActorRepository filmActorRepository,
			FilmCategoryRepository filmCategoryRepository,
			LanguageRepository languageRepository) {

		this.actorRepository = actorRepository;
		this.categoryRepository = categoryRepository;
		this.filmRepository = filmRepository;
		this.filmActorRepository = filmActorRepository;
		this.filmCategoryRepository = filmCategoryRepository;
		this.languageRepository = languageRepository;
	}
/* Actor CRUD functions:
get map = read
post map = create
delete map = delete
put map = update
 */

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor> getALLActors() {
		return actorRepository.findAll();

	}

	@PostMapping("/add_Actor")
	public @ResponseBody String addActor(@RequestParam String first_name, String last_name) {
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return "saved";
	}

	@DeleteMapping("/delete_Actors")
	public @ResponseBody String deleteActorById(@RequestParam int actor_id) {
		actorRepository.deleteById(actor_id);
		return "Deleted Successfully";
	}

	@PutMapping("/update_Actor")
	public @ResponseBody String updateActor(@RequestParam int actor_id, String first_name, String last_name) {
		Actor updateActor = actorRepository.findById(actor_id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with id: " + actor_id));
		updateActor.setFirst_name(first_name);
		updateActor.setLast_name(last_name);
		actorRepository.save(updateActor);
		return "Updated Successfully";

	}

	//category CRUD FUNCTTIONS

	@GetMapping("Categories")
	public @ResponseBody
	Iterable<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	// FILM CRUD FUNCTIONS

	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	/*@PostMapping("/add_Film")
	public @ResponseBody String FilmActor(@RequestParam String first_name, String last_name) {
		Film addFilm = new Film(first_name, last_name);
		filmRepository.save(addFilm);
		return "saved";
	}
*/
	@DeleteMapping("/delete_Films")
	public @ResponseBody String deleteFilmById(@RequestParam int film_id) {
		filmRepository.deleteById(film_id);
		return "Deleted Successfully";
	}

	// lANGUAGE CRUD FUNCTION
	@GetMapping("/allLanguages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}

}