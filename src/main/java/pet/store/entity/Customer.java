package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * This class provides JPA with information on how to manage the Customer table.
 * 
 * @Entity Marks the class as one JPA will manage.
 * 
 * @Data Creates getters & setters for the instance variables. Also creates the .equals() and .hashCode() methods, as well as a .toString() method.
 */

@Entity
@Data
public class Customer {
	
	/**
	 * @Id Tells JPA that this is an identity (primary key) field.
	 * 
	 * @GeneratedValue Tells JPA that the datasource will manage the primary key.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	private String customerFirstName;
	private String customerLastName;
	private String email;
	
	/**
	 * This is the "owned" side of a many-to-many bidirectional relationship between customer and pet_store. 
	 * This variable contains a recursive reference to the pet_store class.
	 * Because of this it must be excluded from the .equals(), .hashCode(), and .toString() methods.
	 */
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
	private Set<PetStore> petStore = new HashSet<>();

}