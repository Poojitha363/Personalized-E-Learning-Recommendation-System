
package com.elearning.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import java.util.*;

@Service
public class RecommendationService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${ml.service.url}")
    private String url;

    public List<?> getRecommendations(Long userId) {
        try {
            return restTemplate.getForObject(url + userId, List.class);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
