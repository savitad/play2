/**
 * 
 */
package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.*;
import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * @author Savita Doddamani
 *
 */
@Entity
public class Employee extends Model {
	
	@Id
	public Long id;
	 
	@Required
	public String firstName;

	@Required
	public String lastName;
	
	@Email
	public String email;

	public String project;
	
	public Integer contactNo;
	
	@Required
	@Formats.DateTime(pattern="dd/MM/yyyy") 
	public Date joiningDate;
	
	public static Finder<Long,Employee> find = new Finder<Long, Employee>(Long.class, Employee.class);
}
