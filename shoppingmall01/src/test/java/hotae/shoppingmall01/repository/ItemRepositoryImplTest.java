package hotae.shoppingmall01.repository;

import hotae.shoppingmall01.item.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryImplTest {
    ItemRepositoryImpl itemRepository = new ItemRepositoryImpl();

    @AfterEach
    void clear() {
        itemRepository.clear();
    }

    @Test
    void save() {
        Item itemA = new Item("itemA", 1000, 10, "KOR");
        Item itemB = new Item("itemB", 2000, 20, "USA");

        itemRepository.save(itemA);
        itemRepository.save(itemB);

        Assertions.assertThat(itemRepository.map).containsValues(itemA, itemB);

    }

    @Test
    void findItem() {
        Item itemA = new Item("itemA", 1000, 10, "KOR");
        Item itemB = new Item("itemB", 2000, 20, "USA");

        itemRepository.save(itemA);
        itemRepository.save(itemB);

        Assertions.assertThat(itemA).isEqualTo(itemRepository.findById(1));
        Assertions.assertThat(itemB).isEqualTo(itemRepository.findById(2));

    }

    @Test
    void findItemList() {
        Item itemA = new Item("itemA", 1000, 10, "KOR");
        Item itemB = new Item("itemB", 2000, 20, "USA");

        itemRepository.save(itemA);
        itemRepository.save(itemB);

        Assertions.assertThat(itemRepository.findAll().size()).isEqualTo(2);

    }


}