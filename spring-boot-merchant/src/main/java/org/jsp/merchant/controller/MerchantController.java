package org.jsp.merchant.controller;

import java.util.Optional;

import org.jsp.merchant.dao.MerchantDao;
import org.jsp.merchant.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {
	@Autowired
 private MerchantDao mdao;
 
 @PostMapping("/merchants")
 public Merchant saveMerchant(@RequestBody Merchant merchants) {
	 return mdao.saveMerchant(merchants);
 }
 @PutMapping("/merchants/{id}")
 public Merchant updateMerchant(@RequestBody Merchant merchants ,@PathVariable int id) {
	 return mdao.updateMerchant(merchants);
 }
 @GetMapping("/merchants/{id}")
 public Optional<Merchant> findById (@PathVariable int id) {
	 return mdao.fetchById(id);
 }
 @DeleteMapping("/merchants/{id}")
 public void deleteMerchant (@PathVariable int id) {
	 mdao.deleteMerchant(id);
 }
}
