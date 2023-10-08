package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * This class provides JPA with information on how to manage the Employee table.
 * 
 * @Entity Marks the class as one JPA will manage.
 * 
 * @Data Creates getters & setters for the instance variables. Also creates the .equals() and .hashCode() methods, as well as a .toString() method.
 */

@Entity
@Data
public class Employee {
	
	/**
	 * @Id Tells JPA that this is an identity (primary key) field.
	 * 
	 * @GeneratedValue Tells JPA that the datasource will manage the primary key.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	private String employeeFirstName;
	private String employeeLastName;
	private String phone;
	private String jobTitle;
	
	/**
	 * This is the "owned" side of a on-to-many relationship between employee and pet_store.
	 * This variable contains a recursive reference to the pet_store class.
	 * Because of this it must be excluded from the .equals(), .hashCode(), and .toString() methods.
	 */
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_store_id", nullable = false)
	private PetStore petStore;

}