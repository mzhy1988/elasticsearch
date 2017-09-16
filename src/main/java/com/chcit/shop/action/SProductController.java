package com.chcit.shop.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chcit.shop.model.SProduct;
import com.chcit.shop.repository.SProductRepository;



@RestController
public class SProductController {
	@Autowired  
	private SProductRepository sProductRepository ; 
	@RequestMapping(value = "/list" ,method = RequestMethod.GET)
	public List<SProduct> getList(){  
		return sProductRepository.findAll();  
	} 
	@RequestMapping(value = "/save" ,method = RequestMethod.GET)
	public void save(){ 
		SProduct arg0 = new SProduct();
		arg0.setAd_client_id(Long.valueOf(0));
		arg0.setAd_org_id(Long.valueOf(0));
		arg0.setName("SpringBootSave");
		arg0.setCreated(new Date());
		arg0.setCreatedby(Long.valueOf(0));
		arg0.setUpdated(new Date());
		arg0.setUpdatedby(Long.valueOf(0));
		arg0.setIsactive("Y");
		arg0.setIshasimage("N");
		arg0.setIsshelved("N");
		arg0.setIsgroupproduct("N");
		sProductRepository.save(arg0);  
	} 
}
