package com.chcit.shop.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.chcit.shop.model.ProductDoc;

/**
 * ElasticsearchRepository
 * 这个地方不要继承错误
 * @author Administrator
 *
 */
public interface ChcitElasticSearchRepository extends ElasticsearchRepository<ProductDoc, String> {
	 ProductDoc findByProductId(String id);
	 Iterable<ProductDoc> findByProductName(String name);
	 Iterable<ProductDoc> findByProductNameLike(String name);
	 Iterable<ProductDoc> findByProductNameContaining(String name);
}
