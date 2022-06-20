import java.util.HashMap;
import java.util.Map;

public class DataStore {


	private Map<String, Person> personMap = new HashMap<>();
	

	private static DataStore instance = new DataStore();
	public static DataStore getInstance(){
		return instance;
	}


	private DataStore(){
		
		personMap.put("John Doe", new Person("John Doe", "Addis Ababa- Bole Subcity", "+251-911-000000"));
	}

	public Person getPerson(String name) {
		return personMap.get(name);
	}

	public void putPerson(Person person) {
		personMap.put(person.getName(), person);
	}
public class Person {
	private String name;
	private String address;
	private String phoneNumber;
	
	public Person(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getPhone() {
		return phoneNumber;
	}
}
}