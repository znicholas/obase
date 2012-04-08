package com.yunbo.obase.example.service;

import org.springframework.stereotype.Service;

import com.yunbo.obase.core.service.ResourceService;
import com.yunbo.obase.example.model.ExampleModel;

@Service
public interface ExampleService extends ResourceService<ExampleModel> {
}
