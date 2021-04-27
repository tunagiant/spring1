package hello.itemservice.service;

import hello.itemservice.domain.item.Item;

import java.util.List;

public interface itemService {
    public interface ItemRepository {
        Item save(Item item);

        Item findById(Long itemId);
        List<Item> findAll();
        void update(Long itemId, Item updateParam);
        void delete(Long itemId);
    }
}
