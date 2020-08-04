package com.Eventregistration.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.stock.domain.Stock;
import com.stock.domain.StockAccount;

public class InMemoryCustomersRepository implements CustomersRepository {

	/** This is simply to eliminate the need to provide an in-memory database! */
	private List<Customer> accountData = new ArrayList<>(Arrays.asList(
			new Customer(1L, "John Smith", 5000, createStocks()),
			new Customer(2L, "Linda Hamilton", 3000, createStocks()), 
			new Customer(3L, "Jose Gomez", 10000, createStocks()),
			new Customer(4L, "Teresa Richardson", 7500, createStocks()), 
			new Customer(5L, "Bill Jones", 12000, createStocks())));

	private SortedMap<String, Customer> createStocks() {
		SortedMap<String, Customer> stockMap = new TreeMap<>();
		
		// Generates a random number between 0 and 5
		int numStocks = (int) (Math.random() * 6);
						
		// Always return at least one stock
		if (numStocks == 0) { 
			numStocks = 1;
		}
		
		Stock ibm = new Stock("IBM", 100, 126);
		Stock google = new Stock("GOOG", 100, 1557);
		Stock microsoft = new Stock("MSFT", 100, 208);
		Stock facebook = new Stock("FB", 100, 243);
		Stock amazon = new Stock("AMZN", 100, 3119);
		
		List<Stock> stockArray = new ArrayList<>(Arrays.asList(
				ibm, google, microsoft, facebook, amazon
				));
		
		for (int i = 0; i < numStocks; i++) {
			stockMap.put(stockArray.get(i).getSymbol(), stockArray.get(i));
		}
		
		return stockMap;
	}
	
	@Override
	public StockAccount findById(Long id) {
		// Uses Java 8 Streams, and filters with a lambda that matches on id value.
		Optional<StockAccount> accountOptional = accountData.stream().filter(account -> account.getId().equals(id))
				.findAny();

		return accountOptional.orElse(null); // Returns item if found, else returns null
	}

	@Override
	public Collection<StockAccount> findAll() {
		return Collections.unmodifiableCollection(accountData);
	}

	@Override
	public Collection<StockAccount> findByName(String name) {
		return accountData.stream().filter(account -> account.getName().toLowerCase().equals(name.toLowerCase()))
				.collect(Collectors.toList());
	}

	@Override
	public long count() {
		return accountData.size();
	}

	@Override
	public StockAccount save(StockAccount account) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(StockAccount account) {
		throw new UnsupportedOperationException();
	}

}
