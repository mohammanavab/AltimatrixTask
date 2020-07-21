package com.stock.servcie;

import java.util.List;
import java.util.Optional;

import com.stock.model.Stock;


public interface StockService {
	 Integer  saveStock(Stock stock);
	 void updateStock(Stock stock);
	 void delete(Integer id);
	// Optional<Stock> getoneStock(Integer id);
	 List <Stock> getAllStock();
	 boolean isStocktExist(Integer id);

}
