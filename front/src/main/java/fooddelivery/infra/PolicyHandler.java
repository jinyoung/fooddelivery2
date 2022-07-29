package fooddelivery.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddelivery.config.kafka.KafkaProcessor;
import fooddelivery.domain.*;
import fooddelivery.domain.usecase.*;
import javax.naming.NameParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderPolicy orderPolicy;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PaymentPolicy paymentPolicy;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRejected_CancelPayment(@Payload Rejected rejected) {
        if (!rejected.validate()) return;
        Rejected event = rejected;
        System.out.println(
            "\n\n##### listener CancelPayment : " + rejected.toJson() + "\n\n"
        );

        // Sample Logic //
        orderPolicy.cancelPayment(event);

        paymentPolicy.cancelPayment(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_CancelPayment(
        @Payload OrderCanceled orderCanceled
    ) {
        if (!orderCanceled.validate()) return;
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener CancelPayment : " +
            orderCanceled.toJson() +
            "\n\n"
        );

        // Sample Logic //
        orderPolicy.cancelPayment(event);

        paymentPolicy.cancelPayment(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRejected_Cancel(@Payload Rejected rejected) {
        if (!rejected.validate()) return;
        Rejected event = rejected;
        System.out.println(
            "\n\n##### listener Cancel : " + rejected.toJson() + "\n\n"
        );

        // Sample Logic //
        orderPolicy.cancel(event);

        paymentPolicy.cancel(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAccepted_UpdateStatus(@Payload Accepted accepted) {
        if (!accepted.validate()) return;
        Accepted event = accepted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + accepted.toJson() + "\n\n"
        );

        // Sample Logic //
        orderPolicy.updateStatus(event);

        paymentPolicy.updateStatus(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRejected_UpdateStatus(@Payload Rejected rejected) {
        if (!rejected.validate()) return;
        Rejected event = rejected;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + rejected.toJson() + "\n\n"
        );

        // Sample Logic //
        orderPolicy.updateStatus(event);

        paymentPolicy.updateStatus(event);
    }
}
