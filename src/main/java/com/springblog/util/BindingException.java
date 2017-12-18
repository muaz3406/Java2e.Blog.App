package com.springblog.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class BindingException extends Exception {
    @NonNull
    private String field;
    @NonNull
    private String message;
    @NonNull
    private Object[] objects;
}

