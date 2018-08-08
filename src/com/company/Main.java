package com.company;

import com.company.demoService.DemoService;
import com.company.demoService.DemoServiceInt;

public class Main {

    public static void main(String[] args) {
        DemoServiceInt demo = new DemoService();
        demo.startDemo();
    }
}
