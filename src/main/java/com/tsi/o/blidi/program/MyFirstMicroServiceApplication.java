package com.tsi.o.blidi.program;

import com.tsi.o.blidi.program.Actor.Actor;
import com.tsi.o.blidi.program.Actor.ActorRepository;
import com.tsi.o.blidi.program.Category.Category;
import com.tsi.o.blidi.program.Category.CategoryRepository;
import com.tsi.o.blidi.program.Film.Film;
import com.tsi.o.blidi.program.Film.FilmRepository;
import com.tsi.o.blidi.program.FilmActor.FilmActor;
import com.tsi.o.blidi.program.FilmActor.FilmActorRepository;
import com.tsi.o.blidi.program.FilmCategory.FilmCategory;
import com.tsi.o.blidi.program.FilmCategory.FilmCategoryRepository;
import com.tsi.o.blidi.program.Language.Language;
import com.tsi.o.blidi.program.Language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@CrossOrigin(origins = "*")// needed for receiving request via api
@RestController // handles GET POST DELETE PUT requests
@RequestMapping("/home") //base url
public class MyFirstMicroServiceApplication {

	@Autowired
	private ActorRepository actorRepository;
	private String saved = "saved";
	private String actors = "Actor";
	private String nope = "Does not exist";
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FilmRepository filmRepository;
	private String films = "Film";
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

	@GetMapping("/actors")
	public @ResponseBody
	Iterable<Actor> getALLActors() {
		return actorRepository.findAll();

	}

	// get actors by actor id
	@GetMapping("/AllActor/{Actor_id}")
	public @ResponseBody Optional<Actor> getActorById (@PathVariable int actor_id) {
		if (actorRepository.existsById(actor_id)) {
			return actorRepository.findById(actor_id);

		} else throw new ResourceNotFoundException(actors + actor_id + nope);
	}

	@PostMapping("/add_Actor/{first_name}{last_name}")
	public @ResponseBody String addActor(@PathVariable String first_name,String last_name) {
		Actor addActor = new Actor();
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

	//category CRUD FUNCTIONS

	@GetMapping("/Categories")
	public @ResponseBody
	Iterable<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@GetMapping("/Get_Film_by_Category")
	public @ResponseBody
	Iterable<Film> getFilmByCategory(@RequestParam String name){

		Category filmCatName = categoryRepository.findByName(name);
		int filmCatId = filmCatName.getCategoryId();
		List filmsFrom = filmCategoryRepository.findByCategoryId(filmCatId);
		List<FilmCategory> filmCatName_id = filmCategoryRepository.findByCategoryId(filmCatId);
		List<Integer> filmList = new ArrayList<Integer>();
		filmCatName_id.forEach(Film -> filmList.add(Film.getFilmId()));
		Iterable<Film> filmsListFound = filmRepository.findAllById(filmList);
		return filmsListFound;

	}


	// FILM CRUD FUNCTIONS

	@GetMapping("/film")
	public @ResponseBody
	Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	// returns film by id
	@GetMapping("/film/{film_id}")
	public @ResponseBody Optional<Film> getFilmById (@PathVariable int film_id){

		if (filmRepository.existsById(film_id)){
			return filmRepository.findById(film_id);
		} else throw new ResourceNotFoundException(films + film_id + nope);

	}

	@GetMapping("Get_Films_By_Keyword")
	public Iterable<Film> getFilmsByKeyword(@RequestParam String keyword){
		keyword = "%" + keyword + "%";
		return filmRepository.findByTitleLike(keyword);
	}



	// returns a list of movies and the corresponding category id
	@GetMapping("/films/filmCategories")
	public @ResponseBody
	Iterable<FilmCategory>getAllFilmCategories() {
		return filmCategoryRepository.findAll();
	}

	// returns a list of actors and the corresponding movie id the actor stars in

	@GetMapping("/films/{actor_id}")
	public @ResponseBody
	Iterable<FilmActor>getAllFilmActors() {
		return filmActorRepository.findAll();
	}

	/*@PostMapping("/add_Film")
	public @ResponseBody String FilmActor(@RequestParam String first_name, String last_name) {
		Film addFilm = new Film(first_name, last_name);
		filmRepository.save(addFilm);
		return "saved";
	}
*/
	/*@DeleteMapping("/delete_Films")
	public @ResponseBody String deleteFilmById(@RequestParam int film_id) {
		filmRepository.deleteById(film_id);
		return "Deleted Successfully";
	}
*/
	// lANGUAGE CRUD FUNCTION
	@GetMapping("/languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}

}