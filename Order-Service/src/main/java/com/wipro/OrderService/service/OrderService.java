package com.wipro.OrderService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.wipro.OrderService.dto.OrderLineItemsDto;
import com.wipro.OrderService.dto.OrderRequest;
import com.wipro.OrderService.model.Order;
import com.wipro.OrderService.model.OrderLineItems;
import com.wipro.OrderService.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItems> list = orderRequest.getOrderLineItemsDtos()
								.stream()
									.map(orderLineItemDto -> mapToDto(orderLineItemDto)).toList();
		order.setOrderLineItems(list);
		
		orderRepository.save(order);
	}
	
	public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		return orderLineItems;
	}
}
