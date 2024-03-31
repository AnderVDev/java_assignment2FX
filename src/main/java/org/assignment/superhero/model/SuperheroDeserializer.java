package org.assignment.superhero.model;

import com.google.gson.*;
import java.lang.reflect.Type;

public class SuperheroDeserializer implements JsonDeserializer<Superhero> {

    @Override
    public Superhero deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        int id = jsonObject.get("id").getAsInt(); // Extract id from JSON
        // Deserialize other fields
        String name = jsonObject.get("name").getAsString();
        String slug = jsonObject.get("slug").getAsString();
        Powerstats powerstats = context.deserialize(jsonObject.get("powerstats"), Powerstats.class);
        Appearance appearance = context.deserialize(jsonObject.get("appearance"), Appearance.class);
        Biography biography = context.deserialize(jsonObject.get("biography"), Biography.class);
        Work work = context.deserialize(jsonObject.get("work"), Work.class);
        Connections connections = context.deserialize(jsonObject.get("connections"), Connections.class);
        Images images = context.deserialize(jsonObject.get("images"), Images.class);

        // Create and return Superhero object
        return new Superhero(id, name, slug, powerstats, appearance, biography, work, connections, images);
    }
}
