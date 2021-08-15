package com.google.sps.servlets;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> funFacts = new ArrayList<>();
    funFacts.add("My favorite food is macaroni");
    funFacts.add("My favorite shoes are air force 1s");
    funFacts.add("I love to play basketball");

    String json = convertToJsonUsingGson(funFacts);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
  
  private String convertToJsonUsingGson(ArrayList<String> facts) {
    Gson gson = new Gson();
    String json = gson.toJson(facts);
    return json;
  }
}
