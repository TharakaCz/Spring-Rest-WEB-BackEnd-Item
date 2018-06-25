package lk.ijse.spring.mvn.service;

import lk.ijse.spring.mvn.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {

    public ArrayList<ItemDTO>getAllItems();

    public ItemDTO getItem(String itemID);

    public boolean deleteItem (String itemID);

    public boolean saveItem(ItemDTO itemDTO);
}
