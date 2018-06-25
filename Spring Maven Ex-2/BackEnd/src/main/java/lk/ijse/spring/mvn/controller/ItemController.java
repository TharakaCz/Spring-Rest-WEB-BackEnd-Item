package lk.ijse.spring.mvn.controller;

import lk.ijse.spring.mvn.dto.ItemDTO;
import lk.ijse.spring.mvn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v2/items")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ItemDTO>getAllItems(){
        return service.getAllItems();
    }

    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDTO getItem(@PathVariable("id")String itemID){
        return service.getItem(itemID);
    }

    @DeleteMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteItem(@PathVariable("id") String itemID){
        return service.deleteItem(itemID);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveItem(@RequestBody ItemDTO itemDTO){
        return service.saveItem(itemDTO);
    }
}
