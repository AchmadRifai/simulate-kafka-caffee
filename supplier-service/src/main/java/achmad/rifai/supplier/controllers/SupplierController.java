package achmad.rifai.supplier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import achmad.rifai.supplier.dto.MessageRes;
import achmad.rifai.supplier.dto.SupplyReq;
import achmad.rifai.supplier.services.SupplierService;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
public class SupplierController {

	@Autowired
	SupplierService service;

	@PostMapping("/supplying")
	public Mono<MessageRes> supplying(@RequestBody SupplyReq req) {
		return service.supplying(req);
	}
}
