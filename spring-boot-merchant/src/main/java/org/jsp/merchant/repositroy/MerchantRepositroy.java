package org.jsp.merchant.repositroy;

import org.jsp.merchant.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepositroy extends JpaRepository<Merchant, Integer> {

}
