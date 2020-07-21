package com.stock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.model.Stock;
import com.stock.servcie.StockService;

@RestController
@RequestMapping("/rest/stockInvMng")
public class StockController{
	
	@Autowired
	private StockService service;

	@PostMapping("/saveStock")
	public ResponseEntity<String> stockSave(@RequestBody Stock stock) {
		ResponseEntity<String> resp = null;
		try {

			if (stock.getStockId() != null && service.isStocktExist(stock.getStockId())) {
				resp = new ResponseEntity<String>("stock all ready Exist ", HttpStatus.BAD_REQUEST);
			} else {

				Integer id = service.saveStock(stock);

				resp = new ResponseEntity<String>("stock save successfully", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to save stock", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;

	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAllStock() {
		ResponseEntity<?> resp = null;

		try {
			List<Stock> stocktlist = service.getAllStock();
			resp = new ResponseEntity<List<Stock>>(stocktlist, HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("unable to fetch stock", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@PutMapping("stocktUpdate")
	public ResponseEntity<String> updateStock(@RequestBody Stock stock) {
		ResponseEntity<String> resp = null;
		try {
			if (stock.getStockId() != null && service.isStocktExist(stock.getStockId())) {
				service.updateStock(stock);
				resp = new ResponseEntity<String>("stock update successfully", HttpStatus.OK);
			} else {
				resp = new ResponseEntity<String>("stock dose not Exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("unable to update stock", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@DeleteMapping("remove/{id}")
	public ResponseEntity<String> removestock(@PathVariable Integer id) {
		ResponseEntity<String> resp = null;
		try {
			if (id != null && service.isStocktExist(id)) {
				service.delete(id);
				resp = new ResponseEntity<String>("stock remove successfully", HttpStatus.OK);
				getAllStock();
			} else {
				resp = new ResponseEntity<String>("stock does not exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("unable to remove stock", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}

}
