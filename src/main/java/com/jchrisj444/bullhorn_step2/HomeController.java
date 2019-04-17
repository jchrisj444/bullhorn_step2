package com.jchrisj444.bullhorn_step2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    MessagepostRepository messagepostRepository;

    @RequestMapping("/")
    public String listMessageposts(Model model){
        model.addAttribute("messageposts", messagepostRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String messagepostForm(Model model) {
        model.addAttribute("messagepost", new Messagepost());
        return "messagepostform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Messagepost message,
                              BindingResult result){
        if (result.hasErrors()){
            return "messagepostform";
        }
        messagepostRepository.save(message);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showMessagepost(@PathVariable("id") long id, Model model){
        model.addAttribute("messagepost", messagepostRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateMessagepost(@PathVariable("id") long id,
                                    Model model){
        model.addAttribute("messagepost", messagepostRepository.findById(id).get());
        return "messagepostform";
    }

    @RequestMapping("/delete/{id}")
    public String delMessage(@PathVariable("id") long id){
        messagepostRepository.deleteById(id);
        return "redirect:/";
    }
}
