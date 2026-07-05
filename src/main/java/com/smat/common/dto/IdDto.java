package com.smat.common.dto;

public record IdDto<T>(int id, T dto) {

    public static <T> IdDto<T> id(int id, T dto){
        return new IdDto<>(id, dto);
    }
}
