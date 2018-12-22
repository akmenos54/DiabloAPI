package Database.DAO;

import Database.Database;
import Models.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class ItemsDAO extends DAO {
    private static String filePath = staticPath + "Items.json";

    public static Map<Integer, Item> load() {
        return Arrays.stream(requireNonNull(getJSON(filePath, Item[].class))).collect(Collectors.toMap(Item::getId, item -> item));
    }

    public static Item save(Item newItem) {
        newItem.setId(generateId());
        Database.items.put(newItem.getId(), newItem);
        saveJson(filePath, Database.items);
        return newItem;
    }

    public static Item update(int id, Item updateItem) {
        updateItem.setId(id);
        mergeItem(updateItem);
        saveJson(filePath, Database.items);
        return Database.items.get(id);
    }

    public static void delete(int id) {
        Database.items.remove(id);
        saveJson(filePath, Database.items);
    }

    private static int generateId() {
        return Database.items.get(Collections.max(Database.items.keySet())).getId() + 1;
    }

    private static void mergeItem(Item Item) {
        Item old = Database.items.get(Item.getId());
        if (Item.getName() != null) {
            old.setName(Item.getName());
        }
        Database.items.replace(old.getId(), old);
    }
}
