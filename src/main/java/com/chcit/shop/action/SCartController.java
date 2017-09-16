package com.chcit.shop.action;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chcit.shop.model.SCart;
import com.chcit.shop.repository.SCartRepository;



@RestController
public class SCartController {
	@Autowired  
	private SCartRepository sCartRepository ; 
	@RequestMapping(value = "/cart/list" ,method = RequestMethod.GET)
	public List<SCart> getList(){  
		return sCartRepository.findAll();  
	} 
	@RequestMapping(value = "/cart/save" ,method = RequestMethod.GET)
	public void save(){ 
		SCart arg0 = new SCart();
		arg0.setIsactive("Y");
		arg0.setEai_product_id(Long.valueOf(1110281));
		arg0.setQty(new BigDecimal(1));
		arg0.setSeqno(Long.valueOf(0));
		sCartRepository.save(arg0);  
	} 


}
