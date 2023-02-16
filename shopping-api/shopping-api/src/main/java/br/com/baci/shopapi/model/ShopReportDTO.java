package br.com.baci.shopapi.model;

public record ShopReportDTO(
    Integer count,
    Double total,
    Double mean
){}