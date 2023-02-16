package br.com.baci.shopapi.repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.com.baci.shopapi.model.Shop;
import br.com.baci.shopapi.model.ShopReportDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ReportRepositoryImpl implements ReportRepository{

    @PersistenceContext // pegar conexão com o banco de dados
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo) {

        StringBuilder sb = new StringBuilder(); // outro método para criar o SQL
        sb.append("select s ");
        sb.append("from shop s ");
        sb.append("where s.date >= :dataInicio ");

        if(dataFim != null)
            sb.append("and s.date <= :dataFim ");
        if(valorMinimo != null)
            sb.append("and s.total <= :valorMinimo ");

        Query query = entityManager.createQuery(sb.toString()); // outro para criar o objeto Query e definir os parâmetros
        query.setParameter("dataInicio", dataInicio);

        if(dataFim != null)
            query.setParameter("dataFim", dataFim);        
        if(valorMinimo != null)
            query.setParameter("valorMinimo", valorMinimo);

        return query.getResultList();
    }

    @Override
    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
        sb.append("from shopping.shop sp ");
        sb.append("where sp.date >= :dataInicio ");
        sb.append("and sd.date <= :dataFim");
        Query query = entityManager.createNativeQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);
        Object[] result = (Object[]) query.getSingleResult();
        ShopReportDTO shopReportDTO = new ShopReportDTO(
            ((BigInteger)result[0]).intValue(), // count sempre retorna BigInteger
            (Double) result[1], // double sempre para sum e avg
            (Double) result[2]);
        return shopReportDTO;
    }
    
}