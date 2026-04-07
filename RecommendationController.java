
package com.elearning.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.elearning.service.RecommendationService;
import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService service;

    @GetMapping("/{userId}")
    public List<?> get(@PathVariable Long userId) {
        return service.getRecommendations(userId);
    }
}
