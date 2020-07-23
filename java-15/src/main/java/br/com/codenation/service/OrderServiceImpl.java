package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		//items.stream().map()
		Double value = items.stream()
				.map(item -> this.productValue(item.getProductId())*item.getQuantity())
				.mapToDouble(Double::doubleValue)
				.sum()
		;
		return value;
	}

	public Double productValue(Long productID){
		Optional<Product> product = productRepository.findById(productID);
		if (product.isPresent() && product.get().getIsSale()){
			return product.get().getValue()*0.8;
		}
		return product.get().getValue();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
				.map(id -> productRepository.findById(id))
				.filter(opt -> opt.isPresent()).map(prs ->prs.get())
				.collect(Collectors.toSet())
		;
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream()
				.map(ls -> this.calculateOrderValue(ls))
				.mapToDouble(Double::doubleValue)
				.sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productRepository.findAll().stream()
				.filter(product -> productIds.contains(product.getId()))
				.collect(Collectors.groupingBy(Product::getIsSale));
	}

}