package com.yixuan.receiptProcess.receiptProcess.Receipt;


import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class ReceiptResource  {

	private ReceiptDaoService service;

	public ReceiptResource(ReceiptDaoService service) {
		this.service = service;
	}

	@GetMapping("/receipts")
	public List<Receipt> retrieveAllReceipts() {
		return service.findAll();
	}
	
	@GetMapping("/receipts/{id}/points")
	@ResponseBody
	public HashMap<String, Integer> retrieveReceipt(@PathVariable UUID id) {
		Receipt Receipt = service.findOne(id);
		if(Receipt==null)
			throw new ReceiptNotFoundException("id:"+id);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("points", calculatepoints(Receipt));
		return map;
	}
	public int calculatepoints(Receipt receipt) {
		int points = 0;
		if (receipt.getTotal() % 1 == 0) {
			points += 50;
			System.out.println(50);
		}
		if ((receipt.getTotal() % (0.25)) == 0) {
			points += 25;
			System.out.println(25);
		}
	    for (int i = 0; i < receipt.getRetailer().length(); i++) {
	        if (Character.isLetter(receipt.getRetailer().charAt(i)))
	        points++;
	    }
		System.out.println(points);

		points += (receipt.getItems().size() / 2) * 5;
		System.out.println(points);

		for (Item item : receipt.getItems()){
			System.out.println(item.getShortDescription());
			if(item.getShortDescription().trim().length() % 3 == 0) {
				points += Math.ceil(item.getPrice() * 0.2);
				System.out.println(item.getShortDescription());

			}
		}
		if(receipt.getPurchaseDate().getDayOfMonth() % 2 == 1) {
			points += 6;
			System.out.println(6);

		}
		if(receipt.getPurchaseTime().getHour()== 14 || receipt.getPurchaseTime().getHour() == 15) {
			points += 10;
			System.out.println(10);

		}
			
		return points;
		
	}

	@PostMapping("/receipts/process")
	public HashMap<String, UUID> createReceipt( @RequestBody Receipt Receipt) {
		Receipt.setId(UUID.randomUUID());
		if(Receipt.getPurchaseDate() == null) {
			throw new Error("PurchaseDate is required");
		}
		if(Receipt.getPurchaseDate() == null) {
			throw new Error("PurchaseDate is required");
		}
		if(Receipt.getPurchaseTime() == null) {
			throw new Error("PurchaseTime is required");
		}
		if(Receipt.getRetailer() == null) {
			throw new Error("Retailer is required");
		}
		service.save(Receipt);
		HashMap<String, UUID> map = new HashMap<>();
		map.put("id", Receipt.getId());
		return map;
	}
	
	
}
