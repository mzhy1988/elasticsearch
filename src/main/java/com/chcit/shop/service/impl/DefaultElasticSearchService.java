package com.chcit.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chcit.shop.model.ProductDoc;
import com.chcit.shop.repository.ChcitElasticSearchRepository;
import com.chcit.shop.service.ElasticSearchService;
@Service
public class DefaultElasticSearchService implements ElasticSearchService{

	@Autowired
	ChcitElasticSearchRepository elasticSearchRepository;

	@Override
	public ProductDoc queryProductInfoById(String id) {
		// TODO Auto-generated method stub
		return elasticSearchRepository.findByProductId(id);
	}

	@Override
	public Iterable<ProductDoc> queryProductInfoByProductName(String name) {
		// TODO Auto-generated method stub
		return elasticSearchRepository.findByProductName(name);
	}

	@Override
	public ProductDoc save(ProductDoc productDoc) {
		// TODO Auto-generated method stub
		return elasticSearchRepository.save(productDoc);
	}

	@Override
	public Iterable<ProductDoc> findAll() {
		// TODO Auto-generated method stub
		return elasticSearchRepository.findAll();
	}

	@Override
	public Iterable<ProductDoc> queryProductInfoByProductNameLike(String name) {
		// TODO Auto-generated method stub
		return elasticSearchRepository.findByProductNameLike(name);
	}

	@Override
	public Iterable<ProductDoc> queryProductInfoByProductNameContaining(
			String name) {
		// TODO Auto-generated method stub
		return elasticSearchRepository.findByProductNameContaining(name);
	}


}
