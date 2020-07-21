package com.stock.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.model.Stock;
import com.stock.repo.StockRepository;
import com.stock.servcie.StockService;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository repo;

	@Override
	public Integer saveStock(Stock stock) {
		// TODO Auto-generated method stub
		
		return repo.save(stock).getStockId();
	}

	@Override
	public void updateStock(Stock stock) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Stock> getAllStock() {
		// TODO Auto-generated method stub
		
		return (List<Stock>) repo.findAll();
	}

	@Override
	public boolean isStocktExist(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
