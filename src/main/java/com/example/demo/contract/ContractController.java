package com.example.demo.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ContractController {

    @Autowired
    private ContractService contractService;

    public ContractController(ContractService contractService) {
             this.contractService = contractService;
    }


}
