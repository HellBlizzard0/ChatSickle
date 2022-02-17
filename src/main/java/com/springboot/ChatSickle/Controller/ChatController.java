package com.springboot.ChatSickle.Controller;

import com.springboot.ChatSickle.Entity.Chat;
import com.springboot.ChatSickle.Entity.Message;
import com.springboot.ChatSickle.Service.ChatService;
import com.springboot.ChatSickle.Service.MessageService;
import com.springboot.ChatSickle.Service.UserService;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatController {

    private ChatService chatService;
    private UserService userService;
    private MessageService messageService;

    @Autowired
    public ChatController(ChatService chatService, UserService userService, MessageService messageService) {
        this.chatService = chatService;
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String show(Model model) {
        List<Chat> chats = chatService.theDeats();
		model.addAttribute("chats", chats);
        // System.out.println(chats.get(0).getMessages().get(chats.get(0).getMessages().size()
        // - 1).getDateOfCreation());
        return "main";
    }

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) {
        this.context = context;
    }

    @ResponseBody
    @RequestMapping(value = "/sendMessage")
    public String getSearchResultViaAjax(@RequestBody HashMap<String, String> param, HttpSession session) {
        Chat chat = this.chatService.getChat(Integer.parseInt(param.get("chatId")));
        this.chatService.update(chat);
        return "main";
    }

    @ResponseBody
    @RequestMapping(value = "/switchChat")
    public List<Message> switchChat(@RequestBody HashMap<String, String> param) {
        return messageService.findByChatId(Integer.parseInt(param.get("chatId")));
    }

}
