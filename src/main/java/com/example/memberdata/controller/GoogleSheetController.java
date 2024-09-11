package com.example.memberdata.controller;

import com.example.memberdata.JsonReader;  // Import your JsonReader class
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/sheets")
public class GoogleSheetController {

  private static final String SHEET_URL = "https://script.google.com/macros/s/AKfycbzfJjHySY8aSUYg5l_7XKLfjmI9TmIRJ7T-TMjd1DKx/dev";

  @GetMapping("/data")
  public String getSheetData() {
    try {
      JSONObject json = JsonReader.readJsonFromUrl(SHEET_URL);
      return json.toString();
    } catch (IOException | JSONException e) {
      e.printStackTrace();
      return "Error fetching data";
    }
  }
}
// -------gitaaaa