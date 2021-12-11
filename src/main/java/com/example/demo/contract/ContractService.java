package com.example.demo.contract;

import com.example.demo.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> getContracts() {
        return contractRepository.findAll();
    }

    public Contract saveContract(Contract contract) {
        return  contractRepository.saveAndFlush(contract);
    }

    public void deleteContract(Contract contract,Long id) {
        contractRepository.deleteById(id);
    }

    public Contract editContract(Contract contract,Long id) {
        return contractRepository.saveAndFlush(contract);
    }

    public Contract findContractByID(Long id) {
        return  contractRepository.getById(id);
    }



}
