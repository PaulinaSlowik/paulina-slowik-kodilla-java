package com.kodilla.good.patterns.challenges.Allegro;

public class OrderingProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderingProcessor(final InformationService informationSevice,
                          final OrderService orderService,
                          final OrderRepository orderRepository)  {
        this.informationService = informationSevice;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process (final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(),orderRequest.getProduct());

        if(isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        }else{
            return new OrderDto(orderRequest.getUser(),false);
        }
    }
}
