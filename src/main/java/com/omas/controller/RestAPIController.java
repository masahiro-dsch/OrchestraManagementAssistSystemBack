package com.omas.controller;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

//import com.omas.restservice.Greeting;
import com.omas.model.Todo;
import com.omas.model.TodoRepository;
import com.omas.service.OrderNumberService;
import com.omas.service.OrderService;
import com.omas.model.Concert;
import com.omas.model.ConcertRepository;
import com.omas.model.OrderNumber;
import com.omas.model.OrderResponse;
import com.omas.model.Product;
import com.omas.model.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestAPIController {

	// private static final String template = "Hello, %s!";
	// private final AtomicLong counter = new AtomicLong();
    private final TodoRepository todoRepository;
    private final ConcertRepository concertRepository;
    private final ProductRepository productRepository;

    @Autowired
    private OrderNumberService orderNumberService;
    @Autowired
    private OrderService orderService;

    public RestAPIController(TodoRepository todoRepository, ConcertRepository concertRepository, ProductRepository productRepository) {
        this.todoRepository = todoRepository;
        this.concertRepository = concertRepository;
        this.productRepository = productRepository;
    }

	// @GetMapping("/greeting")
	// public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
	// 	return new Greeting(counter.incrementAndGet(), String.format(template, name));
	// }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @GetMapping("/")
    public Iterable<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/api/concerts/")
    public Iterable<Concert> getConcerts() {
        return concertRepository.findAll();
    }

    @GetMapping("/api/products/")
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/api/orderNumber/{id}")
    public OrderNumber getOrderNumber(@PathVariable("id") Long id){
    // public Iterable<OrderNumber> getOrderNumber(@PathVariable("id") Long id){
        // ArrayList<Long> ids = new ArrayList<Long>();
        // ids.add(id);
        return orderNumberService.getOrderNumber(id);
    }

    @GetMapping("/api/orders/")
    public Iterable<OrderResponse> getOrder(){
        return orderService.getAllOrder();
    }

    @PostMapping("/api/orders/")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrderResponse(@RequestBody OrderResponse orderRequest) {
        return orderService.setOrder(orderRequest);
    }

    @DeleteMapping("/api/orders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.cancelOrder(id);
    }
}
