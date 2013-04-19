/**
 * 
 */
package controllers;

import java.util.List;

import models.Employee;

import play.api.mvc.Call;
import play.api.templates.Html;
import play.data.Form;
import play.data.validation.Validation;
import play.mvc.Content;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Symbol;
import scala.Tuple2;

/**
 * @author Savita Doddamani check branch
 *
 */
public class Employees extends Controller {
	public static Result index() { 
		List<Employee> employees = Employee.find.all();
		/*Employee e = new Employee();
		e.firstName = "sss";
		e.id = 1l;
		employees.add(e);*/
		return ok(views.html.Employees.index.render(employees)); 
	} 
	public static Result details(Long id) { 
		Employee employee = Employee.find.byId(id);
		return ok(views.html.Employees.details.render(employee));
	} 
	public static Result save()
	{
		Form<Employee> employeeForm = form(Employee.class);
		/*if(employeeForm.hasErrors()) {
		    Html arg2 = new Html("Employees.create.scala.html");
			Tuple2<Symbol, String>[] arg1 = null;
			Call arg0 = null;
			return badRequest(views.html.helper.form.render(arg0, arg1, arg2));//(employeeForm.get()));//views.html.helper.form.render(employeeForm)
		} else {*/
			Employee employee = employeeForm.bindFromRequest().get();
			employee.save();
			flash("success", "Employee details saved successfully.");
			return redirect(controllers.routes.Employees.details(employee.id));
		/*}*/
	}
	
	public static Result create() {
		//Employee employee = new Employee();
		Form<Employee> employee = new Form<Employee>(Employee.class);
		//render(employee);
		return ok(views.html.Employees.create.render(employee));
	}


}
