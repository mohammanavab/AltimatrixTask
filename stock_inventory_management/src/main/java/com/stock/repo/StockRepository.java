package com.stock.repo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import com.stock.model.Stock;
@EnableJpaRepositories
public interface StockRepository extends CrudRepository<Stock, Integer>{
	@Query(
			  value = "SELECT s.stockName, s.purchaSeprice, s.sellingPrice, s.sellingDate, s.purchaseDate, count(productId) as quantity FROM Stock s ORDER BY s.productId DESC", 
			  nativeQuery = true)
    List<Stock> getAllStock();	
}
