package fooddelivery.domain.usecase;

import fooddelivery.domain.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentPolicy {

    @Autowired
    PaymentRepository paymentRepository;

    public void cancelPayment(Rejected rejected) {
        Payment payment = new Payment();
        /*
        LOGIC GOES HERE
        */
        // paymentRepository.save(payment);

    }

    public void cancelPayment(OrderCanceled orderCanceled) {
        Payment payment = new Payment();
        /*
        LOGIC GOES HERE
        */
        // paymentRepository.save(payment);

    }
}
