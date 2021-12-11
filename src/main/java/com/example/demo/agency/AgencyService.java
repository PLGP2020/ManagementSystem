package com.example.demo.agency;

import com.example.demo.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("agencyService")
public class AgencyService {

      private AgencyRepository agencyRepository;

      @Autowired
      public  AgencyService(AgencyRepository agencyRepository) {
          this.agencyRepository = agencyRepository;
      }

      public List<Agency> getAgencies() {
        return agencyRepository.findAll();
    }

      public Agency saveAgency(Agency agency) {
        return  agencyRepository.saveAndFlush(agency);
    }

      public void deleteAgency(Agency agency,Long id) {
        agencyRepository.deleteById(id);
    }

      public Agency editAgency(Agency agency,Long id) {
        return agencyRepository.saveAndFlush(agency);
    }

      public Agency findAgencyByID(Long id) {
        return  agencyRepository.getById(id);
    }


}
