package achmad.rifai.cashier.service.controllers;

import achmad.rifai.cashier.service.dto.ArrayRes;
import achmad.rifai.cashier.service.dto.CategoryDto;
import achmad.rifai.cashier.service.dto.InquiryPriceReq;
import achmad.rifai.cashier.service.dto.InquiryPriceRes;
import achmad.rifai.cashier.service.dto.MessageRes;
import achmad.rifai.cashier.service.dto.OrderReq;
import achmad.rifai.cashier.service.services.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
public class CashierController {
    @Autowired
    CashierService service;

    @GetMapping("/")
    public Mono<ArrayRes<CategoryDto>> all() {
        return service.all();
    }

    @PostMapping("/inquire-price")
    public Mono<InquiryPriceRes> inquiryPrice(@RequestBody InquiryPriceReq req) {
    	return service.inquiryPrice(req);
    }

    @PostMapping("/order")
    public Mono<MessageRes> order(@RequestBody OrderReq req) {
    	return service.order(req);
    }
}