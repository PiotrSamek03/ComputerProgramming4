package pl.samek.ecommerce.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.samek.ecommerce.sales.cart.HashMapCartStorage;
import pl.samek.ecommerce.sales.offering.OfferCalculator;
import pl.samek.ecommerce.sales.payment.PaymentDetails;
import pl.samek.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.samek.ecommerce.sales.reservation.ReservationRepository;

@Configuration
public class SalesConfiguration {
    @Bean
    SalesFacade createSales() {
        return new SalesFacade(
                new HashMapCartStorage(),
                new OfferCalculator(),
                (RegisterPaymentRequest request) -> {
                    return new PaymentDetails("http://payment");
                },
                new ReservationRepository()
        );
    }

}
