package com.company.first;

import com.company.first.chain.ChainManager;

public class Main {
    public static void main(String[] args) {
        ChainManager chainManager = new ChainManager(new Request("Vasya", "Gogolya st.", "" +
                "Super Pizza"));
        chainManager.makeOrder();
    }
}
