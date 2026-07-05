package com.smat.app.acidentes.dto;

public record LocalLesaoAcidenteDto(int id) {

    public static LocalLesaoAcidenteDto localLesaoAcidente(int id) {
        return new LocalLesaoAcidenteDto(id);
    }
}
