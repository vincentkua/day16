package nus.iss.day16.controllers;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@RestController
@RequestMapping(path = "/rsvp", produces = MediaType.APPLICATION_JSON_VALUE)
public class RSVPController {

    // To handle request
    // POST /rsvp
    // Content-Type : application/x.www.form.urlencoded
    // Accept : application/json
    // \r\n
    // name:fred & attend:yes

    // To Return
    // @Post Controller
    // @RequestMapping(
    // path = "/rsvp",
    // produces = "appllication/json")
    // @PostMapping(
    // Consumes = "form-urlencoded"
    // )

    private Logger logger = Logger.getLogger(RSVPController.class.getName());

    // application/json
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postAsJson(@RequestBody String payload) {
        logger.log(Level.INFO, payload);

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject json = reader.readObject();

        String name = json.getString("name");
        boolean attending = json.getBoolean("attending");

        logger.log(Level.INFO, name + attending);

        return ResponseEntity.status(201)
                .body(json.toString());

    }

    // application/x-www-form-urlencoded
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> postAsForm(
            @RequestBody MultiValueMap<String, String> form) {
        String name = form.getFirst("name");
        boolean attending = Boolean.parseBoolean(form.getFirst("attending"));

        logger.log(Level.INFO, name + attending);

        // 201 Created
        // Content-Type : application/json
        // {"status" : "Received <name> RSVP" } sent

        JsonObject payload = Json.createObjectBuilder()
                .add("message", "Received %s RSVP".formatted(name))
                .add("attending", attending)
                .build();

        return ResponseEntity.status(201)
                .body(payload.toString());
    }

}
