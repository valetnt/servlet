package ch.arpage.valeriatonetto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import javax.imageio.*;
import java.io.*;


@Path("/")
public class WalletPassService {

    @Context ServletContext servletContext;

    @GET
    @Path("example/{clientName}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response greetClient(@PathParam("clientName") String name) {
        String output = "Hi " + name;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response displayImage() {

//        ServletContext cntx= req.getServletContext();
//        // Get the absolute path of the image
//        String filename = cntx.getRealPath("src/main/webapp/images/image.png");
//        // retrieve mimeType dynamically
//        String mime = cntx.getMimeType(filename);
//        if (mime == null) {
//            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            return Response.status(500).entity(String.valueOf(resp)).build();
//        }
//
//        resp.setContentType(mime);
//
//        File file = new File(filename);
//        resp.setContentLength((int)file.length());
//
//        FileInputStream in = null;
//        try {
//            in = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        OutputStream out = null;
//        try {
//            out = resp.getOutputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Copy the contents of the file to the output stream
//        byte[] buf = new byte[1024];
//        int count = 0;
//        try {
//            if (in != null) {
//                while ((count = in.read(buf)) >= 0) {
//                    if (out != null) {
//                        out.write(buf, 0, count);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            if (out != null) {
//                out.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            if (in != null) {
//                in.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return Response.status(200).entity(String.valueOf(resp)).build();
//    }
        String filepath = servletContext.getRealPath("images/image.png");
        File file = new File(filepath);
        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"") //optional
                .build();
    }
}
