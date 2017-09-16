package com.chcit.shop.service;


import com.chcit.shop.model.ProductDoc;

public interface ElasticSearchService {
	 ProductDoc queryProductInfoById(String id);
	 Iterable<ProductDoc> queryProductInfoByProductName(String name);
	 Iterable<ProductDoc> queryProductInfoByProductNameLike(String name);
	 Iterable<ProductDoc> queryProductInfoByProductNameContaining(String name);
	 ProductDoc save(ProductDoc productDoc);
	 Iterable<ProductDoc> findAll();
}
