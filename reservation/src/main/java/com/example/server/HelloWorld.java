package com.example.server;
 
import javax.ws.rs.*;


 
// http://localhost:8080/RestEasy/tutorial/...		// 'tutorial' is the base.
// (Assume that the war file is 'RestEasy.war')
@Path("tutorial")
public class HelloWorld
{
	// Tomcat is at port 591.
	// URL:  http://localhost:591/P103B_RESTFul_HellowWorldMavenTomcat/tutorial/helloworld
    @GET
    @Path("helloworld")
    public String helloworld() {
        return "WS GH_MV...  10/28 555 Hello World!";
    }
    
    // URL:  http://localhost:591/P103B_RESTFul_HellowWorldMavenTomcat/tutorial/helloname/francesco123f
    @GET
    @Path("helloname/{name}")
    public String hello(@PathParam("name") final String name) {
      return "Hello from GH_MV" +name;
    }
    
    // URI:   http://localhost:591/P103B_RESTFul_HellowWorldMavenTomcat/tutorial/item
    @GET
    @Path("item")
    @Produces({"application/json"})
    public Item  getItem() {
     
      Item item = new Item("GH_MV Bcomputer555",2600);
     
     return item;
    }
}