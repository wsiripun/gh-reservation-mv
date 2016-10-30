package com.example.server;
 
import javax.ws.rs.*;

import com.example.db.dao.AttendantDAO;
import com.example.db.model.Attendant;


 
// http://localhost:8080/RestEasy/tutorial/...		// 'tutorial' is the base.
// (Assume that the war file is 'RestEasy.war')
@Path("tutorial")
public class Reservation
{
	// Tomcat is at port 591.
	// URL:  http://localhost:591/P103B_RESTFul_HellowWorldMavenTomcat/tutorial/helloworld
    @GET
    @Path("helloworld1")
    public String helloworld() {
        return "WS GH_MV_RESERVATION...  10/28 555 Hello World!";
    }
    
    // URL:  http://localhost:591/P103B_RESTFul_HellowWorldMavenTomcat/tutorial/helloname/francesco123f
    @GET
    @Path("helloname1/{name}")
    public String hello(@PathParam("name") final String name) {
      return "Hello from GH_MV_RESERVATION" +name;
    }
    
    // URI:   http://localhost:591/P103B_RESTFul_HellowWorldMavenTomcat/tutorial/item
    @GET
    @Path("item1")
    @Produces({"application/json"})
    public Item  getItem() {
     
      Item item = new Item("GH_MV_RESERVATION Bcomputer555",2600);
     
     return item;
    }
    
    @GET
    @Path("insert")
    @Produces("text/plain")
    public String sayHello(@QueryParam("fname") String firstName,
    		@QueryParam("lname") String lastName) {
        if ((firstName != null) && (lastName != null)) {
            // if the query parameter "name" is there
			System.out.println("WIJS: hit RequestTicket");
			Attendant attendant = new Attendant();
			attendant.setFirstName(firstName);
			attendant.setLastName(lastName);
			boolean returnCode = (new AttendantDAO()).createAttendant(attendant);
			if (returnCode) {
				System.out.println ("WIJS: Create Ticket Success ++++ ");
			} else {
				System.out.println ("WIJS: Create Ticket FAILED ----- ");
			}
            return "Hello MYFIRST RESOURCE " + firstName +  "  lastName=" + lastName;
        }
        return "Hello World! FINAL RETurn";
    } 
    
}