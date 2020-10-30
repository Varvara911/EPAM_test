package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Data> List1 = new ArrayList<>();
        int k=0;
        do {
            System.out.println("    1 взять готовый список \n    2 составить новый список ");
            k = Integer.parseInt(scanner.nextLine());
        } while ((k != 2) && (k != 1));
        switch (k){
            case 1:
                List1.add(new Data(1,"C"));
                List1.add(new Data(1,"A"));
                List1.add(new Data(2,"D"));
                List1.add(new Data(1,"E"));
                List1.add(new Data(2,"B"));
                break;
            case 2:
                System.out.println("введите количество элементов списка:");
                int count = Integer.parseInt(scanner.nextLine());
                while(List1.size()<count){
                    List1.add(new Data());
                }
                break;
        }

        print(List1);
        dualSort(List1);
        System.out.println("Отсортированный список:");
        print(List1);

        scanner.close();
        List1.clear();
    }
    private static void print(ArrayList<Data> List) {
        for (int i = 0; i < List.size(); i++) {
            List.get(i).print();
        }
    }
    private static void dualSort(ArrayList<Data> List) {

        Collections.sort(List, new Comparator() {

            public int compare(Object o1, Object o2) {

                Integer x1 = ((Data) o1).getNumber();
                Integer x2 = ((Data) o2).getNumber();
                int sComp = x1.compareTo(x2);
                if (sComp != 0) {
                    return sComp;
                }

                String _x1 = ((Data) o1).getName();
                String _x2 = ((Data) o2).getName();
                return _x1.compareTo(_x2);
            }
        });
    }
    static class Data {
        int number;
        String name;
        public Data(){
            System.out.println("введите number: ");
            number = Integer.parseInt(scanner.nextLine());
            System.out.println("введите name:");
            name = scanner.nextLine();
        }
        public Data(int num, String _name)
        {
            number = num;
            name = _name;
        }
        public int getNumber(){

            return number;
        }
        public String getName(){

            return  name;
        }
        public void print(){

            System.out.println("number: " + number +"   name: " + name);
        }
    }
}