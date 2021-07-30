package ru.diasoft.qsmsa.message.controller;

import org.springframework.web.bind.annotation.*;
import ru.diasoft.qsmsa.message.exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("messages")
public class MessageController {

    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>(){{put("id", "1"); put("text", "Task 03. First Message");}});
        add(new HashMap<String, String>(){{put("id", "2"); put("text", "Task 03. Second Message");}});
        add(new HashMap<String, String>(){{put("id", "3"); put("text", "Task 03. Third Message");}});
        add(new HashMap<String, String>(){{put("id", "4"); put("text", "Task 03. Forth Message");}});
        add(new HashMap<String, String>(){{put("id", "5"); put("text", "Task 03. Fifth Message");}});
    }};

    private int counter = 6;

    //get all messages
    @GetMapping
    public List<Map<String, String>> getMessages() {
        return messages;
    }

    //get message by id
    @GetMapping("{id}")
    public Map<String, String> getMessageByID(@PathVariable("id") String id) {
        return messages.stream().
                filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    //add message
    @PostMapping
    public Map<String, String> insertMessage(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));
        messages.add(message);
        return message;
    }

    //edit message
    @PutMapping("{id}")
    public Map<String, String> updateMessage(@PathVariable("id") String id, @RequestBody Map<String, String> message) {
        Map<String, String> foundMessage = getMessageByID(id);
        foundMessage.putAll(message);
        foundMessage.put("id", id);
        return message;
    }

    //delete message
    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable("id") String id) {
        messages.remove(getMessageByID(id));
    }
}
