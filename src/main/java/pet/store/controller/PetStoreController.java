package pet.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreData.PetStoreCustomer;
import pet.store.controller.model.PetStoreData.PetStoreEmployee;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {

	@Autowired
	private PetStoreService petStoreService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) {
		log.info("Creating petstore {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}

	@PutMapping("/{petStoreId}")
	public PetStoreData updatePetStore(@RequestBody PetStoreData petStoreData, @PathVariable Long petStoreId) {
		petStoreData.setPetStoreId(petStoreId);
		log.info("Updating petstore {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}
	
	@PostMapping("/{petStoreId}/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreEmployee createPetStoreEmployee(@PathVariable Long petStoreId,@RequestBody PetStoreEmployee petStoreEmployee) {
		return petStoreService.saveEmployee(petStoreId, petStoreEmployee);
	}
	
	@PostMapping("/{petStoreId}/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreCustomer createPetStoreCustomer(@PathVariable Long petStoreId, @RequestBody PetStoreCustomer petStoreCustomer) {
		return petStoreService.saveCustomer(petStoreId, petStoreCustomer);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<PetStoreData> retrieveAllPetStores(){
		log.info("Retrieve all Pet Stores");
		return petStoreService.retrieveAllPetStore();
	}
	
	@GetMapping("/{petStoreId}")
	@ResponseStatus(code = HttpStatus.OK)
	public PetStoreData retrievePetStoreById(@PathVariable Long petStoreId) {
		log.info("Retrieving PetStore with ID={}", petStoreId);
		return petStoreService.retrievePetStoreById(petStoreId);
	}
	
	@DeleteMapping("/{petStoreId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, String> deletePetStoreById(@PathVariable Long petStoreId) {
		log.info("PetStore with ID{} and all associated employees and customers have been deleted");
		petStoreService.deletePetStoreById(petStoreId);
		return Map.of("message", "PetStore with Id=" + petStoreId + " deleted.");
	}
}
