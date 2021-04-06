package hello.itemservice.controller;

import hello.itemservice.domain.item.Item;
//import hello.itemservice.domain.item.ItemRepository;
import hello.itemservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/basic/items")
public class BasicItemController {

    private final ItemRepository itemRepository;

    //@Autowired 생략가능
    public BasicItemController(@Qualifier("itemRepository") ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //========상품목록
    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    //========상품상세
    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        System.out.println("item = " + item);
        return "basic/item";
    }

    /**
     * 같은 URL 을 HTTP method에 따라 구분해줌
     */
    //========상품등록폼
    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    //========상품등록처리
//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                            @RequestParam int price,
                            @RequestParam Integer quantity,
                            Model model) {

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);
        model.addAttribute("item", item);

        return "basic/item";
    }

    //    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model) {

        itemRepository.save(item);
        model.addAttribute("item", item);
        return "basic/item";
    }

    //    @PostMapping("/add")
    /** @ModelAttribute의 name설정과 parameter의 이름 같으면 생략가능 **/
    public String addItemV3(@ModelAttribute Item item, Model model) {

        itemRepository.save(item);
        /** @ModelAttribute 로 name설정해주면 자동으로 모델에 넣어줌
         * model.addAttribute("item", item); 생략된 것**/
        return "basic/item";
    }

//        @PostMapping("/add")
    /** @ModelAttribute도 생략가능(스프링에서 자동 추론) */
    public String addItemV4(Item item) {

        itemRepository.save(item);
        return "basic/item";
    }

    //    @PostMapping("/add")
    public String addItemV5(Item item) {

        itemRepository.save(item);
        return "redirect:/basic/items/" +  item.getId();
    }

    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        //query parameter로 감    // ?status=...
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }

    //========상품수정폼
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    //========상품수정처리
    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }

    //========상품삭제폼
    @GetMapping("/{itemId}/delete")
    public String deleteForm(@PathVariable Long itemId, Model model) {
//        Optional<Item> item = itemRepository.findById(itemId);
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/deleteForm";
    }

    //상품삭제처리
    @PostMapping("/{itemId}/delete")
    public String delete(@PathVariable Long itemId) {
        itemRepository.delete(itemId);
        return "redirect:/basic/items";
    }

    //Dependency Injection 되기 전에 실행 시 null이 저장되므로 PostConstruct 사용
    //테스트용 데이터(아무것도 save되지 않은 상태에서는 모르기때문에)
//    @PostConstruct
//    public void init() {
//        itemRepository.save(new Item("itemA", 10000, 10));
//        itemRepository.save(new Item("itemB", 20000, 20));
//
//    }
}
