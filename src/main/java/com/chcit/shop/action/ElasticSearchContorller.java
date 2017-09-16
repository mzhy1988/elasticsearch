package com.chcit.shop.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.chcit.shop.model.ProductDoc;
import com.chcit.shop.model.SProduct;
import com.chcit.shop.repository.SProductRepository;
import com.chcit.shop.service.ElasticSearchService;
/**
 * 匹配ElasticSearch 1.+版本
 * @author Administrator
 */
@RestController
public class ElasticSearchContorller {

	@Autowired
	private ElasticSearchService defaElasticSearchService;

	@Autowired
	private SProductRepository sProductRepository;

//	@Autowired
//	ElasticSearchService elasticSearchService;

	@RequestMapping("/product/add")
	public Iterable<ProductDoc> addProduct(String id, ModelMap modelMap){
		List<SProduct> list = sProductRepository.findAll();
		for (int i = 0; i < list.size(); i++) {
			SProduct p = list.get(i);
			ProductDoc productDoc = new ProductDoc();
			productDoc.setProductId(String.valueOf(p.getS_product_id()));
			productDoc.setProductName(p.getName());
			productDoc.setManufacturer(p.getManufacturer());
			productDoc.setProductSpec(p.getProductspec());
			productDoc.setCertificateNo(p.getCertificateno());
			defaElasticSearchService.save(productDoc);
		}
		//modelMap.addAttribute("esAccountInfo",accountInfo);
		//modelMap.addAttribute("test_elastic","Test the elasticsearch");
		return defaElasticSearchService.findAll();
	}

	@RequestMapping("/product/get")
	@Transactional
	public ProductDoc getProduct(String id, ModelMap modelMap){
		return defaElasticSearchService.queryProductInfoById(id);
	}
	@RequestMapping("/product/get/name")
	@Transactional
	public Iterable<ProductDoc> getProductName(String name, ModelMap modelMap){
		return defaElasticSearchService.queryProductInfoByProductNameContaining(name);
	}
}
