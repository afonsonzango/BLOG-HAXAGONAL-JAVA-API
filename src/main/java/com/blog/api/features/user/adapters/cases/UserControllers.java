package com.blog.api.features.user.adapters.cases;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("S{api.version}/users")
public abstract class UserControllers { }