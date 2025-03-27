package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.SpecialOffer;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.SpecialOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/special-offers")
public class SpecialOfferController {

    // repository
    @Autowired
    private SpecialOfferRepository repository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("specialOffer") SpecialOffer newOffer, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "special-offers/create";
        } else {
            repository.save(newOffer);
            return "redirect:/pizzas";
        }
    }
}
