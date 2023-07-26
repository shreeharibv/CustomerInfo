package com.ivoyant.customerInfo.service;

import com.ivoyant.customerInfo.entity.Offers;
import com.ivoyant.customerInfo.repository.OffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffersService {
    @Autowired
    OffersRepository offersRepository;
    public void createOffers(Offers offers) {
        try {
            offersRepository.save(offers);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void deleteOffers(Long offerId) {
        try {
            offersRepository.deleteById(offerId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
