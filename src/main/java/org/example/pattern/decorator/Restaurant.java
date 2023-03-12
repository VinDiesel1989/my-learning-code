package org.example.pattern.decorator;

/**
 * 装饰模式
 * <p>
 * 假設一個餐廳有各種套餐，主餐、沙拉、飲料、甜點、湯..等，
 * <p>
 * 不同套餐的餐點不一樣，低消需要一杯飲料，
 */
public class Restaurant {
    /**
     * 小订单(低消费)
     */
    private void minimumOrder() {
        System.out.println("一杯饮料");
    }

    /**
     * 低消费一杯饮料
     */
    public void order() {
        minimumOrder();
    }

}
