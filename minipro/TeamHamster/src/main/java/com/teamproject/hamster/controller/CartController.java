package com.teamproject.hamster.controller;

import com.teamproject.hamster.dto.ProductDTO;
import com.teamproject.hamster.view.ListView;


import java.util.ArrayList;
import java.util.Scanner;


public class CartController {
    Scanner sc = new Scanner(System.in);

    public void shopBasket(ArrayList select) {

        while (true) {

            System.out.println("1.사이즈 변경");
            System.out.println("2.상품 취소");
            System.out.println("3.상품 더 보기");
            System.out.println("4.결제 하기");
            System.out.print("번호를 입력 하세요 : ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    changeSize(select);
                    break;// 선택한 상품 사이즈 변경

                case 2:
                    cartCancel(select);
                    break;

                case 3:
                    break;

                case 4: //PaymentController.print(select); break;
            }
        }
    }

    // 선택 취소 메소드
    public void cartCancel(ArrayList<ProductDTO> cancel) { // 선택 취소 메소드

        for (int i = 0; i < cancel.size(); i++) { //담은 목록 출력
            System.out.print(cancel.get(i).getName() + ", ");
            System.out.print(cancel.get(i).getSize() + ", ");
            System.out.println(cancel.get(i).getPrice() + " ");
        }

        System.out.println("어떤 것을 취소하겠습니까? ");
        sc.nextLine();
        System.out.print("신발 이름을 입력하세요 : ");
        String st = sc.nextLine();
        System.out.print("사이즈를 입력하세요 : ");
        int siz = sc.nextInt();

        for (int i = 0; i < cancel.size(); i++) {
            if (st.equals(cancel.get(i).getName()) && siz == cancel.get(i).getSize()) {
                System.out.println(cancel.get(i).getName() + " " + cancel.get(i).getSize() + "취소 되었습니다.");
                cancel.remove(i); //제거 기능(인덱스)
                i--; //물어 보기
                System.out.println("장바구니에 돌아 갑니다.");
                shopBasket(cancel); //장바구니에 돌아감
            }
        }
    }


    //사이즈 변경 메소드
    public void changeSize(ArrayList<ProductDTO> change) {

        for (int i = 0; i < change.size(); i++) { //담은 목록 출력
            System.out.print(change.get(i).getName() + ",  ");
            System.out.print(change.get(i).getSize() + ",  ");
            System.out.println(change.get(i).getPrice() + " ");
        }
        System.out.println("어떤 것을 변경합니까? ");
        sc.nextLine();
        System.out.print("신발 이름을 입력하세요 : ");
        String st = sc.nextLine();
        System.out.print("사이즈를 입력하세요 : ");
        int siz = sc.nextInt();

        ListView mv = new ListView();
        ArrayList<ProductDTO> productList = mv.getProductList();

//        for (int i = 0; i < productList.size(); i++) {
//            productList.get(i).getName();
//            productList.get(i).getSize();
//            productList.get(i).getPrice();
//        }
            for (int j = 0; j < productList.size(); j++) {
                if (st.equals(change.get(j).getName()) && siz == change.get(j).getSize()) {;
                    for (int k = 0; k < productList.size(); k++) {
                        if (st.equals(productList.get(k).getName())) {
                        System.out.println("변경 할 수 있는 사이즈 목록");
                        System.out.println("제품 이름 : " + productList.get(j).getName());
                        System.out.println("제품 사이즈 : " +productList.get(j).getSize());
                        System.out.println("제품 가격 : " + productList.get(j).getPrice());
                        System.out.print("변경할 사이즈를 입력 해주세요 : ");
                        int chan = sc.nextInt();
                        System.out.println(productList.get(k).getName() + " " + chan + "사이즈로 변경 되었습니다.");

                        //change.set(1,productList.get(0));//수정 기능

                        System.out.println("장바구니에 돌아 갑니다.");
                        shopBasket(change); //장바구니에 돌아감
                         }
                    }
                }
            }

       // }
    }
}