package Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import Database.Database;

import java.util.List;

public class Item implements JsonModel {
    private int id;
    private String name;

    @JsonProperty("nom")
    public String getName() {
        return name;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
