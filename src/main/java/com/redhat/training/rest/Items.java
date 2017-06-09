package com.redhat.training.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.training.service.CatalogService;



//Sets the path to base URL + /hello
@Path("/items")
public class Items {

	@Inject
	private CatalogService service;

	
	// This method is called if TEXT_PLAIN is request
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextItems() {
	    return "Hello Jersey";
	  }

	  // This method is called if XML is request
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public String sayXMLItems() {
	    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	  }

	  // This method is called if HTML is request
	  @GET
	  @Produces(MediaType.TEXT_HTML)
	  public String sayHtmlItems() {
	    //return "<html> " + "<title>" + "Hello Jersey" + "</title>"
	    //    + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	    return getItems();
	  }
	  
	  private String getItems()
	  {
		  StringBuilder ret = new StringBuilder();
			List<String> categories = service.getCategories();
			if (categories != null)
			{
				ret.append("size:" + categories.size() + ":");
				for (int cat=0;cat<categories.size();cat++)
				{
					ret.append(categories.get(cat) + ";");
				}
			}
		  return ret.toString();
	  }
	  
}
	