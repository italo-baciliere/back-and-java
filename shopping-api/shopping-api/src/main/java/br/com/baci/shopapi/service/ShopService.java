package br.com.baci.shopapi.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baci.shopapi.model.Shop;
import br.com.baci.shopapi.model.ShopDTO;
import br.com.baci.shopapi.model.ShopDadosCadastroDTO;
import br.com.baci.shopapi.model.ShopReportDTO;
import br.com.baci.shopapi.repository.ReportRepositoryImpl;
import br.com.baci.shopapi.repository.ShopRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor    // https://javabydeveloper.com/lombok-requiredargsconstructor-examples/
public class ShopService {
    
    @Autowired
    private final ShopRepository shopRepository;
    private final ReportRepositoryImpl reportRepository;
    
    public List<ShopDTO> getAll(){
        List<Shop> shops = shopRepository.findAll();
        return shops.stream()
            .map(ShopDTO::converter)
            .collect(Collectors.toList());
    }
    
    public List<ShopDTO> getByUser(String userIdentifier){
        List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
        return shops.stream()
                    .map(ShopDTO::converter)
                    .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO){
        List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.date());
        return shops.stream()
                    .map(ShopDTO::converter)
                    .collect(Collectors.toList());
    }

    public ShopDTO findById(Long productId){
        Optional<Shop> shop = shopRepository.findById(productId);
        if(shop.isPresent())
            return ShopDTO.converter(shop.get());
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO){
        Shop shop = Shop.converter(shopDTO);
        shop.setTotal(
            shopDTO.items()
            .stream()
            .map(x -> x.price())
            .reduce((float) 0, Float::sum)
        );
        shop.setDate(LocalDateTime.now());
        shopRepository.save(shop);
        return ShopDTO.converter(shop);
    }

    public ShopDTO save(ShopDadosCadastroDTO shopDadosCadastroDTO){                
        Shop shop = Shop.converter(shopDadosCadastroDTO);
        shop.setTotal(
            shopDadosCadastroDTO.items()
            .stream()
            .map(x -> x.price())
            .reduce((float) 0, Float::sum)
        );
        shop.setDate(LocalDateTime.now());
        shopRepository.save(shop);
        return ShopDTO.converter(shop);
    }

    public List<ShopDTO> getShopsByFilter(
        LocalDate dataInicio, LocalDate dataFim, Float total
    ){
        List<Shop> shops = reportRepository.getShopByFilters(dataInicio, dataFim, total);
        return shops.stream()
               .map(ShopDTO::converter)
               .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim){
        return reportRepository.getReportByDate(dataInicio, dataFim);
    }
}