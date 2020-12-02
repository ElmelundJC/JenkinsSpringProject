package com.elmelund.jpademo.controller;

import com.elmelund.jpademo.model.Owner;
import com.elmelund.jpademo.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.Set;

@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners/","/owners","owners/index"})
    public String getOwners(Model model){
        System.out.println("Owners: ");
        Set<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        System.out.println(owners.size());
        return "owners/index";
    }

    @PostMapping("/addOwner")
    public String addOwner(Owner owner){
            ownerService.save(owner);
            return "redirect:/dogs";// redirect til dog page..
    }

    @PostMapping(value = "/updatedelete", params = "update")
    public String updateOwner(Owner owner){
        Optional<Owner> ownerToUpdate = ownerService.findById(owner.getId());
        if(ownerToUpdate.isPresent()){
            ownerService.save(owner);
        }
        return "redirect:/owners/index";
    }

    @PostMapping(value = "/updatedelete", params = "delete")
    public String deleteOwner(@RequestParam Long id){
        Optional<Owner> ownerToDelete = ownerService.findById(id);
        if(ownerToDelete.isPresent()){
            ownerService.delete(ownerToDelete.get());
        }
        return "redirect:/owners/index";
    }
}
