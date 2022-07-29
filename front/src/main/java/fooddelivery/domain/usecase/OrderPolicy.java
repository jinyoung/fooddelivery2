package fooddelivery.domain.usecase;

import fooddelivery.domain.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPolicy {

    @Autowired
    OrderRepository orderRepository;

    public void updateStatus(Accepted accepted) {
        Order order = new Order();
        /*
        LOGIC GOES HERE
        */
        // orderRepository.save(order);

    }

    public void updateStatus(Rejected rejected) {
        Order order = new Order();
        /*
        LOGIC GOES HERE
        */
        // orderRepository.save(order);

    }
}
