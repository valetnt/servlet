package ch.arpage.valeriatonetto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.imageio.*;
import java.io.*;


@Path("/")
public class WalletPassService {

    @Context ServletContext servletContext;
    private CustomerDataService dataService = CustomerDataService.getInstance();

//    @GET
//    @Path("example/{clientName}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response greetClient(@PathParam("clientName") String name) {
//        String output = "Hi " + name;
//        return Response.status(200).entity(output).build();
//    }

//    @GET
//    @Path("get")
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//    public Response downloadPass() {
//        String filepath = servletContext.getRealPath("images/image.png");
//        File file = new File(filepath);
//        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
//                .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"") //optional
//                .build();
//    }

    @GET
    @Path("download/{filename}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadPass(@PathParam("filename") String filename) {
        String filepath = servletContext.getRealPath("images/" + filename);
        File file = new File(filepath);
        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"") //optional
                .build();
    }

    @POST
    @Path("submit/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String createCustomer(@FormParam("name") String name,
                                 @FormParam("address") String address,
                                 @FormParam("phone-number") String phoneNumber) {
        return dataService.addCustomer(name, address, phoneNumber);
    }
}
