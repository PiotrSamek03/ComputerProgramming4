package pl.samek.ecommerce.sales;

import org.junit.jupiter.api.Test;
import pl.samek.ecommerce.sales.cart.HashMapCartStorage;
import pl.samek.ecommerce.sales.offering.Offer;
import pl.samek.ecommerce.sales.offering.OfferCalculator;
import pl.samek.ecommerce.sales.reservation.ReservationRepository;
import pl.samek.ecommerce.sales.reservation.SpyPaymentGateway;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class SalesTest {

    @Test
    void itShowsCurrentOffer() {
        String customerId = thereIsCustomer("Kuba");
        SalesFacade sales = thereIsSales();

        Offer offer = sales.getCurrentOffer(customerId);

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.ZERO);
        assertThat(offer.getItemsCount()).isEqualTo(0);
    }

    @Test
    void itAddsProductToCart() {

    }

    @Test
    void itAcceptCustomersCurrentOffer() {

    }

    @Test
    void itConfirmPayment() {

    }

    private SalesFacade thereIsSales() {
        return new SalesFacade(
                new HashMapCartStorage(),
                new OfferCalculator(),
                new SpyPaymentGateway(),
                new ReservationRepository()
        );
    }

    private String thereIsCustomer(String name) {
        return name;
    }
}
