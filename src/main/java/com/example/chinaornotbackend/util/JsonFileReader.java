package com.example.chinaornotbackend.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileReader {
  public static <T> T readJsonFile(String filePath, TypeReference<T> valueType) {
    ObjectMapper mapper = new ObjectMapper();
    T object = null;

    try {
      object = mapper.readValue(new File(filePath), valueType);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return object;
  }
}