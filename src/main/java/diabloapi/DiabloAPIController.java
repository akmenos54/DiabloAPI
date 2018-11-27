package diabloapi;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import diabloapi.Item;

@RestController
public class DiabloAPIController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    //cette arraylist sert de BDD, a modifier en JSON
    private ArrayList<Item> Items_List = new ArrayList();

    @GetMapping("/DiabloAPI")
    public ArrayList<Item> Item() {
        return Items_List;
    }
    
    /*
    @GetMapping("/DiabloAPI/:id")
    public Item diabloID(@PathVariable int id) {
        //to do 
    	return null;
    }*/
    
    @DeleteMapping("/DiabloAPI/:id")
    public ResponseEntity greetingDelete(@PathVariable int id) {
       // To do
    	return ResponseEntity.status(HttpStatus.OK).build();
    }

    
    @PostMapping("/DiabloAPI/post")
    public Item newItem(@RequestBody Item newItem) {
    	// Add to database
    	newItem.setId(Items_List.size()+1);
    	Items_List.add(newItem);
    	return newItem;
    }
}
