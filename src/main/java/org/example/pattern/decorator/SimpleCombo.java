package org.example.pattern.decorator;

/**
 * 簡餐多了湯品
 */
public class SimpleCombo extends BusinessLunch {

    public SimpleCombo(Restaurant restaurant) {
        super(restaurant);
    }

    private void soup() {
        System.out.println("一份湯品");
    }

    @Override
    public void order() {
        super.order();
        soup();
    }
}
