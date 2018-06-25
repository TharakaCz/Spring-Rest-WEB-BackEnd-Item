package lk.ijse.spring.mvn.service.impl;

import lk.ijse.spring.mvn.dto.ItemDTO;
import lk.ijse.spring.mvn.entity.Item;
import lk.ijse.spring.mvn.repository.ItemRepository;
import lk.ijse.spring.mvn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public ArrayList<ItemDTO> getAllItems() {
        List<Item>items = repository.findAll();
        ArrayList<ItemDTO>alItems = new ArrayList<>();

        for (Item item: items){
            ItemDTO itemDTO = new ItemDTO(item.getIcode(),
                    item.getIname(),
                    item.getIdiscription(),
                    item.getQty(),
                    item.getUnitprice());
            alItems.add(itemDTO);
        }
        return alItems;

    }

    @Override
    public ItemDTO getItem(String itemID) {
        Item item = repository.findById(itemID).get();
        ItemDTO itemDTO = new ItemDTO(item.getIcode(),item.getIname(),item.getIdiscription(),item.getQty(),item.getUnitprice());
        return itemDTO;
    }

    @Override
    public boolean deleteItem(String itemID) {
        repository.deleteById(itemID);
        return true;
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.getIcode(),itemDTO.getIname(),itemDTO.getIdiscription(),itemDTO.getQty(),itemDTO.getUnitprice());
        repository.save(item);
        return true;
    }
}
