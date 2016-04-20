package br.com.leonardoterrao.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/UserService")
public class UserService {

    UserDao userDao = new UserDao();

    @GET
    @Path("/users")
    @Produces(MediaType.TEXT_XML)
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @GET
    @Path("/users/{username}")
    @Produces(MediaType.TEXT_XML)
    public User getUsers(@PathParam("username") final String userName) {
        return userDao.findAll()
                .stream()
                .filter(u -> u.getName().equals(userName))
                .findFirst().orElse(null);
    }

}
