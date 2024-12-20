package com.blog.api.features.post.adapters.cases;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.version}/posts")
public abstract class PostControllers { }