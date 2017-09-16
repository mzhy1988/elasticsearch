package com.chcit.shop.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.chcit.shop.model.Book;

import java.util.List;

/**
 * Created by Nasir on 12-09-2015.
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    public List<Book> findByName(String name);
    public List<Book> findByRatingBetween(Double start, Double end);
}
