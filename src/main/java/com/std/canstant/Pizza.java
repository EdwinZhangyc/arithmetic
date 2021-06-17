package com.std.canstant;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zyc
 * @date 2021/6/4 10:38
 */
public class Pizza {

    private PizzaStatus status;
    private static final EnumSet<PizzaStatus> UNDELIVERED_PIZZA_STATUSES = EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    public enum PizzaStatus {
        /**
         *
         */
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private final int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        return input.stream().filter(
                (s) -> UNDELIVERED_PIZZA_STATUSES.contains(s.getStatus()))
                .collect(Collectors.toList());
    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy()
                    .deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }


    public static void main(String[] args) {
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        testPz.isDeliverable();
    }
}