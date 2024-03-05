package stores.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import jakarta.validation.Valid;
import stores.Services;
import stores.Payment;
import stores.data.ServicesRepository;
import stores.data.PaymentRepository;
import org.springframework.beans.BeanUtils;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentRepository paymentRepository;
    private final ServicesRepository servicesRepository;

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    public PaymentController(PaymentRepository paymentRepository, ServicesRepository servicesRepository) {
        this.paymentRepository = paymentRepository;
        this.servicesRepository = servicesRepository;
    }
    
    private List<Services> getAllServices() {
        List<Services> allServices = new ArrayList<>();
        servicesRepository.findAll().forEach(allServices::add);
        return allServices;
    }


    private void addServicesAttributes(Model model, Long selectedServicesId) {
        model.addAttribute("allServices", getAllServices());
        model.addAttribute("services", servicesRepository.findById(selectedServicesId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid services Id:" + selectedServicesId)));
    }

    @GetMapping("/create")
    public String paymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "Payment";
    }
    
    @GetMapping("/all")
    public String allPayment(Model model) {
        List<Payment> allPayment = (List<Payment>) paymentRepository.findAll();
        List<Services> allServices = (List<Services>) servicesRepository.findAll(); 
        model.addAttribute("allPayment", allPayment);
        model.addAttribute("allServices", allServices);
        return "allPayment";
    }


    @PostMapping("/submit")
    public String processDeal(@Valid @ModelAttribute("payment") Payment payment, Errors errors, SessionStatus sessionStatus, @ModelAttribute("selectedServicesid") 
    Services servicesId, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("selectedServices", servicesId);
            return "payment";
        }
        System.out.println(payment);
        log.info("Deal submitted: {}", payment);
        paymentRepository.save(payment);
        sessionStatus.setComplete();
        return "redirect:/payment/all";
    }
    
    @GetMapping("/edit/{id}")
    public String editPayment(@PathVariable Long id, Model model) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment Id:" + id));
        model.addAttribute("payment", payment);
        addServicesAttributes(model, payment.getTypeId());
        return "paymentEdit";
    }

    @PostMapping("/update/{id}")
    public String updateDeal(@PathVariable Long id, @Valid @ModelAttribute("payment") Payment payment,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            addServicesAttributes(model, payment.getTypeId());
            return "paymentEdit";
        }

        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment Id:" + id));

        BeanUtils.copyProperties(payment, existingPayment, "id");
        paymentRepository.save(existingPayment);
        return "redirect:/payment/all";
    }


    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentRepository.deleteById(id);
        return "redirect:/payment/all";
    }
}












