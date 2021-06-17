package com.std.canstant;

/**
 * @author zyc
 */
public enum PizzaDeliverySystemConfiguration {
    /**
     * 枚举单例
     */
    INSTANCE;
    PizzaDeliverySystemConfiguration() {
        // Initialization configuration which involves
        // overriding defaults like delivery strategy
    }

    private final PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

    public static PizzaDeliverySystemConfiguration getInstance() {
        return INSTANCE;
    }

    public PizzaDeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }
}
