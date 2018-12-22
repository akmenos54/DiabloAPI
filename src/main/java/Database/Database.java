package Database;

import Database.DAO.ItemsDAO;
import Models.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Database {
	public static Map<Integer, Item> items;

    // GETTERS ---------------------------------------------

    public static Item getItem(int itemId) {
        return items.get(itemId);
    }

    public static List<Item> getItems() {
        return new ArrayList<>(items.values());
    }

    // LOAD AND SAVE ---------------------------------------

    public static void load() {
        items = ItemsDAO.load();
    }
}