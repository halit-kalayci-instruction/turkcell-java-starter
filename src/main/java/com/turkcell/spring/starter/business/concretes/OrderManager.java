package com.turkcell.spring.starter.business.concretes;

import com.turkcell.spring.starter.business.abstracts.OrderDetailService;
import com.turkcell.spring.starter.business.abstracts.OrderService;
import com.turkcell.spring.starter.entities.Customer;
import com.turkcell.spring.starter.entities.Employee;
import com.turkcell.spring.starter.entities.Order;
import com.turkcell.spring.starter.entities.dtos.order.OrderForAddDto;
import com.turkcell.spring.starter.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailService orderDetailService;

    private final ModelMapper modelMapper;


    @Override
    @Transactional // metotun tamamen başarılı bir şekilde bitmesini bekleyip değişiklikleri o şekilde pushlayan metot
    public void add(OrderForAddDto request) {
        // Order'ı dbye kaydet, orderin bir id'si oluşsun..
        // oluşan id'yi ve itemları orderdetail service gönder o da bu idye detay eklemelerini yapsın..

        // Manual Mapping
        // Auto Mapping

        // Multi-Language Desteği => Mikro Görevler
        /*Order order = Order.builder()
                .customer(Customer.builder().customerId(request.getCustomerId()).build())
                .orderDate(LocalDate.now())
                .employee(Employee.builder().employeeId(request.getEmployeeId()).build())
                .requiredDate(request.getRequiredDate())
                .shipAddress(request.getShipAddress())
                .shipCity(request.getShipCity())
                .shipName(request.getShipName())
                .shipRegion(request.getShipRegion())
                .build();
        */
        Order orderFromAutoMapping = modelMapper.map(request, Order.class);


        orderFromAutoMapping = orderRepository.save(orderFromAutoMapping);  // gönderen hesaptan parayı düş

        // bu satırdan sonra order'ın id alanı set edilmiş..
        orderDetailService.addItemsToOrder(orderFromAutoMapping, request.getItems()); // gönderilen hesaba parayı göndermek
}
}
