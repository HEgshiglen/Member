package com.example.memberdata.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class GoogleSheetService {

    private final RestTemplate restTemplate;

    public GoogleSheetService() {
        this.restTemplate = new RestTemplate();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> fetchSheetData() {
        // Replace this URL with your Google Apps Script deployment URL
        String url = "https://script.google.com/macros/s/AKfycbxng9Khd8Pq66F-5_Xe50Au_HD1ofAudmjG-XM77GVeD4L8qPLfsp55zzByAANegbO6UQ/exec";
        
        // Fetch the JSON data as an array of objects
        List<Map<String, Object>> data = restTemplate.getForObject(url, List.class);
        return data;
    }
}

