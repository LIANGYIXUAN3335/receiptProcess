package com.yixuan.receiptProcess.receiptProcess.Receipt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class ReceiptDaoService {
	private static List<Receipt> receipts = new ArrayList<>();
	private static List<Item> items = new ArrayList<>();
	static {
		items.add(new Item("shortDescription",1.00));
	}
	static {
		receipts.add(new Receipt(UUID.randomUUID(),"retailer1",LocalDate.now().minusYears(30),LocalTime.now().minusHours(2),items,1.00));
	}
	
	public List<Receipt> findAll() {
		return receipts;
	}
	
	public Receipt save(Receipt receipt) {
		receipts.add(receipt);
		return receipt;
	}

	public Receipt findOne(UUID id) {
		Predicate<? super Receipt> predicate = user -> user.getId().equals(id); 
		return receipts.stream().filter(predicate).findFirst().orElse(null);
	}
}
