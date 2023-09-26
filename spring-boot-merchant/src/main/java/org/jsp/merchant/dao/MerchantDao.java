package org.jsp.merchant.dao;

import java.util.Optional;

import org.jsp.merchant.dto.Merchant;
import org.jsp.merchant.repositroy.MerchantRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
        @Autowired
	private MerchantRepositroy repositroy;
	
        public Merchant saveMerchant (Merchant merchants) {
        	return repositroy.save(merchants);
        }
        public Merchant updateMerchant(Merchant merchants) {
        	return repositroy.save(merchants);
        }
        public Optional<Merchant> fetchById(int id){
        	return repositroy.findById(id);
        }
        public void deleteMerchant (int id) {
        	 repositroy.deleteById(id);
        }
}
