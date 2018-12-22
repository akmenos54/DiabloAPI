package Controller;

import Database.DAO.ItemsDAO;
import Database.Database;
import Models.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class ItemsController {

    @GetMapping("/items")
    public List<Item> getItems(@RequestParam(value = "location", required = false) String location, @RequestParam(value = "category", required = false) String category) {
        List<Item> items = Database.getItems();
        return items;
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable("id") int id) {
        return Database.getItem(id);
    }

    @PostMapping("/items")
    public ResponseEntity<Item> postItem(@RequestBody Item newItem) {
        return new ResponseEntity<>(ItemsDAO.save(newItem), HttpStatus.CREATED);
    }

    @PatchMapping("/items/{id}")
    public Item patchItem(@PathVariable("id") int id, @RequestBody Item updateItem) {
        return ItemsDAO.update(id, updateItem);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity deleteItem(@PathVariable("id") int id) {
        ItemsDAO.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

