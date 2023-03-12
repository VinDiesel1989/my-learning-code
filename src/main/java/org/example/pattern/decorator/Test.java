package org.example.pattern.decorator;

public class Test {

    public static void main(String[] args) {

        //實現出來後發覺有一點問題，問題點在於，Decorator Pattern其實是要為了減少或替代繼承的使用，
        // 因為如果套餐間有互相繼承的關係，會提高系統的耦合性。系統設計的原則需要透過某種方式封裝可能的變化，
        // 並且減少類別之間的互相影響（降低耦合度），如果未來新的套餐出了或是套餐的餐點改變了，
        // 只需要新增一個類別或是修改一個類別，可以很輕鬆的滿足需求。
        //所以接下來我們試著根據原則重新實現...。
        Restaurant restaurant = new Restaurant();

        SimpleCombo simpleCombo = new SimpleCombo(restaurant);

        System.out.println("簡餐：");
        simpleCombo.order();

        BusinessLunch businessLunch = new BusinessLunch(restaurant);
        System.out.println("商業午餐：");
        businessLunch.order();

        FullCombo fullCombo = new FullCombo(restaurant);
        System.out.println("全餐：");
        fullCombo.order();
    }
}
