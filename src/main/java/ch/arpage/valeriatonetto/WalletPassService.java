package ch.arpage.valeriatonetto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.imageio.*;
import java.io.*;


@Path("/")
public class WalletPassService {

//    @GET
//    @Path("{clientName}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response greetClient(@PathParam("clientName") String name) {
//        String output = "Hi " + name;
//        return Response.status(200).entity(output).build();
//    }

    @GET
    @Path("get")
    @Produces("image/png")
    public Response displayImage(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) {
        String filename = ""
        File file = new File(filename);
        resp.setContentLength((int)file.length());

        FileInputStream in = new FileInputStream(file);
        OutputStream out = resp.getOutputStream();

        // Copy the contents of the file to the output stream
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();

        return Response.status(200).entity(output).build();
    }
}
