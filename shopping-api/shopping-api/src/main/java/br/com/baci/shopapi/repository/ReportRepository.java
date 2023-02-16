package br.com.baci.shopapi.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.com.baci.shopapi.model.Shop;
import br.com.baci.shopapi.model.ShopReportDTO;

public interface ReportRepository{

    public List<Shop> getShopByFilters(
        LocalDate dataInicio,
        LocalDate dataFim,
        Float valorMinimo);

    public ShopReportDTO getReportByDate(
        Date dataInico,
        Date dataFim);
    
}