package hello.itemservice.repository;

import hello.itemservice.domain.item.Item;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Optional;

@Primary
public interface ItemRepository {
    Item save(Item item);

    Item findById(Long itemId);
    List<Item> findAll();
    void update(Long itemId, Item updateParam);
    void delete(Long itemId);
}
