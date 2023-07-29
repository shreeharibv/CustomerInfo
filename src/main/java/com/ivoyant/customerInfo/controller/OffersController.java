package com.ivoyant.customerInfo.controller;

import com.ivoyant.customerInfo.entity.Offers;
import com.ivoyant.customerInfo.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Offers/")
public class OffersController {
    @Autowired
    OffersService offersService;
    @PostMapping("create")
    public ResponseEntity<String> createOffers(@RequestBody Offers offers) {
        offersService.createOffers(offers);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
    @DeleteMapping("deleteOffer/{id}")
    public ResponseEntity<String> deleteOffers(@PathVariable("id") Long offerId) {
        offersService.deleteOffers(offerId);
        return new ResponseEntity<>("Offer successfully deleted!", HttpStatus.OK);
    }
    @GetMapping("getAllOffers/{bankName}")
    public ResponseEntity<List<Offers>> getOffersByLocation(@PathVariable("bankName")String bankName){
       List<Offers> offers= offersService.getOffersByName(bankName);
        return new ResponseEntity<>(offers,HttpStatus.OK);
    }
}
