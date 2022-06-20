import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class PersonServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String requestUrl = request.getRequestURI();
		String name = requestUrl.substring("/people/".length());
		
		Person person = DataStore.getInstance().getPerson(name);
		
		if(person != null){
			String json = "{\n";
			json += "\"name\": " + JSONObject.quote(person.getName()) + ",\n";
			json += "\"address\": " + JSONObject.quote(person.getAddress()) + ",\n";
			json += "\"phonenumber\": " + person.getPhone() + "\n";
			json += "}";
			response.getOutputStream().println(json);
		}
		else{
			//That person wasn't found, so return an empty JSON object. We could also return an error.
			response.getOutputStream().println("{}");
		}
	}
	
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int phoneNumber = Integer.parseInt(request.getParameter("phonenumber"));
		
		DataStore.getInstance().putPerson(new Person(name, address, phoneNumber));
	}
}