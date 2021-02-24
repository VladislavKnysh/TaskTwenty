package com.company.second;

import com.company.second.chain.DecoratorsManager;

public class Main {
    public static void main(String[] args) {
        DecoratorsManager decoratorsManager = new DecoratorsManager(new Request("Vitya", "Pushkin st.", "Pizza One"));
        decoratorsManager.makeOrder();
    }
}
