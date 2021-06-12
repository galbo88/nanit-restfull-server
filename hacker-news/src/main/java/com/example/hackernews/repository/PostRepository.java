package com.example.hackernews.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.hackernews.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PostRepository {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public PostRepository(final DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }


    public List<Content> getAll() {
        return dynamoDBMapper.scan(Content.class, new DynamoDBScanExpression());
    }


    public Content getById(String contentId) {
        return dynamoDBMapper.load(Content.class, contentId);
    }

    public String postContent(String content) {
        Content newContent = new Content(UUID.randomUUID().toString(), content);
        dynamoDBMapper.save(newContent);
        return newContent.getContentId();
    }

}
