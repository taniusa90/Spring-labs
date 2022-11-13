package com.cydeo;

import com.cydeo.enums.DiscountType;
import com.cydeo.enums.PaymentMethod;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final BalanceRepository balanceRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final DiscountRepository discountRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public QueryDemo(AddressRepository addressRepository, BalanceRepository balanceRepository, CartItemRepository cartItemRepository, CartRepository cartRepository, CustomerRepository customerRepository, DiscountRepository discountRepository, OrderRepository orderRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.addressRepository = addressRepository;
        this.balanceRepository = balanceRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("-------Address--------");
        //System.out.println(addressRepository.findAllByCustomerId(1L));
       // System.out.println(addressRepository.findByStreet("Everett"));
       // System.out.println(addressRepository.findTop3ByCustomerEmail("asturton0@list-manage.com"));
        //System.out.println(addressRepository.findAllByCustomerFirstName("Anstice"));
       // System.out.println(addressRepository.findAllByStreetStartingWith("Li"));
       // System.out.println(addressRepository.retrieveCustomerById(498L));
        System.out.println("----------Balance----------");
       // System.out.println(balanceRepository.existsByCustomerId(1L));
       // System.out.println(balanceRepository.findByCustomerId(1L));
       //System.out.println(balanceRepository.findAllByAmountIsGreaterThanEqual(BigDecimal.valueOf(500.36)));
        //System.out.println(balanceRepository.retrieveBalance(BigDecimal.valueOf(92.48)));
        //System.out.println(balanceRepository.retrieveTop5Amount());
        System.out.println("----------CartItem----------");
        //System.out.println(cartItemRepository.countCartItemBy());
        //System.out.println(cartItemRepository.findByCart_CartState(CartState.CREATED));
       // System.out.println(cartItemRepository.retrieveCartItemsByStateAndName( "CREATED","Wine - Prosecco Valdobiaddene"));
       // System.out.println(cartItemRepository.retrieveCartItemsByCartState("CREATED"));
        System.out.println("----------Cart--------------");
        //System.out.println(cartRepository.findByDiscount_DiscountType(DiscountType.AMOUNT_BASED));
        // System.out.println(cartRepository.retrieveAllByCustomer(451L));
         //System.out.println(cartRepository.findByCustomerIdAndCartState(451L,CartState.CREATED));
        // System.out.println(cartRepository.findByCustomerIdAndCartStateAndDiscountNull("asturton0@list-manage.com",CartState.CREATED));
         System.out.println(cartRepository.retrieveAllCartByDiscount(240L,"CREATED"));
        System.out.println("--------Category-------------");
        //System.out.println(categoryRepository.findByName("Termite Control"));
        //System.out.println(categoryRepository.findFirst3ByOrderByNameDesc());
        System.out.println("--------Customer-------------");
        //System.out.println(customerRepository.findAllById(1L));
      //  System.out.println(customerRepository.retrieveCustomerByEmail("asturton0@list-manage.com"));
        System.out.println("--------Discount-------------");
        //System.out.println(discountRepository.findByName("%25"));
        //System.out.println(discountRepository.getByDiscountGreaterThanOrderByDiscount(BigDecimal.valueOf(25)));
        //System.out.println(discountRepository.getByDiscountType(DiscountType.AMOUNT_BASED));
       // System.out.println(discountRepository.retrieveDiscountBetweenRange(BigDecimal.valueOf(10), BigDecimal.valueOf(60)));
        System.out.println("--------Orders-------------");
        //System.out.println(orderRepository.findFirst5ByOrderByTotalPriceDesc());
        //System.out.println(orderRepository.findByCustomer_Email("asturton0@list-manage.com"));
       // System.out.println(orderRepository.findOrdersByPayment_PaymentMethod(PaymentMethod.BUY_NOW_PAY_LATER));
        //System.out.println(orderRepository.retrieveAllOrdersByName("Almonds Ground Blanched"));
        System.out.println(orderRepository.retrieveAllOrdersByCategoryId(1L));
        //System.out.println(orderRepository.findByPaidPriceAndTotalPriceEquals(BigDecimal.valueOf(767.98), BigDecimal.valueOf(1563.97)));
        //System.out.println(orderRepository.findByPaidPriceAndTotalPriceAndCart_DiscountIdNotNull(BigDecimal.valueOf(316.72), BigDecimal.valueOf(171.37)));
        System.out.println("---------Product-------------");
        // System.out.println(productRepository.findFirs3tByOrderByPriceDesc());
      // System.out.println(productRepository.findByCategoryId(4L));
        //System.out.println(productRepository.countAllByPriceGreaterThan(BigDecimal.valueOf(92)));
        //System.out.println(productRepository.findAllByQuantityGreaterThanEqual(404));
        //System.out.println(productRepository.retrieveAllProductsByPrice(BigDecimal.valueOf(92),404));
        //System.out.println(productRepository.retrieveAllProductsByCategory(4L));
        //System.out.println(productRepository.retrieveAllProductsByCategoryAndAmount(4L,BigDecimal.valueOf(92)));


    }
}
