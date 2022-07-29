package fooddelivery.domain.usecase;

import fooddelivery.PaymentApplication;
import fooddelivery.domain.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentCommand {

    @Autowired
    PaymentRepository paymentRepository;
}
