package org.example.pattern.decorator;

/**
 * 商業午餐除了飲料還有沙拉跟主餐
 */
public class BusinessLunch extends Restaurant {

    private Restaurant restaurant;

    public BusinessLunch(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    private void salad() {
        System.out.println("一盤沙拉");
    }

    private void mainMeal() {
        System.out.println("一份主餐");
    }

    @Override
    public void order() {
        super.order();
        salad();
        mainMeal();
    }

}
