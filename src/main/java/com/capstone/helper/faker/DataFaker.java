package com.capstone.helper.faker;

import java.util.List;

public interface DataFaker <T> {
    List<T> generateData();
    String getData();
}
