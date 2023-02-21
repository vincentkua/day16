package nus.iss.day16;

import java.io.Reader;
import java.io.StringReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;

@SpringBootApplication
public class Day16Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day16Application.class, args);
	}

	@Override
	public void run(String... args) {

		// JsonObject json = Json.createObjectBuilder()
		// 		.add("name", "fred")
		// 		.add("email", "fred@gmail.com")
		// 		.add("age", 30)
		// 		.build();
		// System.out.println("JSON Content: >>>> " + json.toString());

		// JsonArray array = Json.createArrayBuilder()
		// 		.add(json)
		// 		.add(json)
		// 		.build();
		// System.out.println("Array Content: >>>> " + array.toString());

		// String jsonStr = """
		// 		{
		// 			"orderId":1234,"address" : "10 Bedrock Ave",
		// 			"lineItems" : [
		// 				{"name": "apple" , "quantity" : 10},
		// 				{"name": "orange" , "quantity" : 20}
		// 			]
		// 		}
		// 		""";
		// System.out.println("Jsonstr Content: >>>> " + jsonStr.toString());

		// Reader reader = new StringReader(jsonStr);
		// JsonReader jsonReader = Json.createReader(reader);
		// json = jsonReader.readObject();
		// System.out.println("orderId: >>>> " + json.getInt("orderId"));
		// System.out.println("address: >>>> " + json.getString("address"));

		// array = json.getJsonArray("lineItems");

		// for (int i = 0; i < array.size(); i++) {
		// 	json = array.getJsonObject(i);
		// 	System.out.println("name:" + json.getString("name") + " quantity:" + json.getInt("quantity"));
		// }

	}

}
