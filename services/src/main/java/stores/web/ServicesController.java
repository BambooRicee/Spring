package stores.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import stores.Services;
import stores.Payment;
import stores.data.ServicesRepository;

@Controller

public class ServicesController {
    private final ServicesRepository servicesRepository;

    public ServicesController(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @GetMapping("/services")
    public String showServicesForm(Model model) {
    	model.addAttribute("services", servicesRepository.findAll());
        model.addAttribute("newServices", new Services());
        return "services";
    }

    
    @PostMapping("/selectpayment")
    public String selectServices(@RequestParam("servicesId") Long servicesId, Model model) {
    	
        Services services = servicesRepository.findById(servicesId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid deal type Id:" + servicesId));
        model.addAttribute("selectedServices", services);

        Payment payment = new Payment();
        payment.setTypeId(servicesId);
        model.addAttribute("payment", payment);

        return "payment";
    }
    
   

    @GetMapping("/allServices")
    public String showAllServices(Model model) {
        model.addAttribute("services", servicesRepository.findAll());
        return "allServices";
    }

    @GetMapping("/addServices")
    public String showAddServicesForm(Model model) {
        model.addAttribute("services", new Services());
        return "addServices";
    }

    @PostMapping("/addServices")
    public String addServices(@ModelAttribute("services") @Valid Services services, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addServices";
        }

        servicesRepository.save(services);
        return "redirect:/allServices";
    }


    @GetMapping("/editServices/{id}")
    public String showEditServicesForm(@PathVariable Long id, Model model) {
        Services services = servicesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment type Id:" + id));
        model.addAttribute("services", services);
        return "editServices";
    }

    @PostMapping("/editServices/{id}")
    public String editServices(@PathVariable Long id, @ModelAttribute("services") @Valid Services updatedServices, BindingResult result) {
        if (result.hasErrors()) {
            return "editServices";
        }

        servicesRepository.findById(id).ifPresent(services -> {
            services.setType(updatedServices.getType());
            servicesRepository.save(services);
        });
        return "redirect:/allServices";
    }


    @GetMapping("/deleteServices/{id}")
    public String deleteServices(@PathVariable Long id) {
        servicesRepository.deleteById(id);
        return "redirect:/allServices";
    }

}


