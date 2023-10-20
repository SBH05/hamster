package com.teamproject.hamster.controller;

import com.teamproject.hamster.view.ListView;

import java.util.Scanner;

public class CartController {
    Scanner sc = new Scanner(System.in);
    ListView LM = new ListView();


    public void shopBasket() { //


        while (true) {

            System.out.println("1. 사이즈 변경");
            System.out.println("2.상품 취소");
            System.out.println("3.상품 더 보기");
            System.out.println("4.결제 하기");
            System.out.print("번호를 입력 하세요 : ");
            int num = sc.nextInt();
            switch (num) {
                case 1: LM.ShoesSize(); break; // 선택한 상품 사이즈 변경 Key 값을 기입
                case 2: cartCancel(); break;
                case 3: LM.kindOfShoes(); break;
                case 4:  break; //s
            }

        }
    }


    public void cartCancel () {  }


    public void changeSize() {

    }






}
