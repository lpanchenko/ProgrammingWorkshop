package Tasks;

public class HW8 {
/*
Сегодня будет писать небольшую очередь. Надо создать класс, у которого будет три метода - add(), getLast() и getFirst()

При вызове add() мы должны передать в него любое число, которое класс "запомнит". Например, мы передаем 5 и класс запоминает это число как первое. Затем снова вызываем add(6) и класс запоминает это число, как второе.
При вызове getLast() класс должен вернуть последнее добавленное число и "забыть" его. Например, в нашем случае вернуть 6. Если вызвать метод еще раз, вернется 5. А затем NULL.
При вызове getFirst() класс работает наоборот. Возвращает самое ранее добавленное число и забывает его. В нашем случае снала 5, затем 6.
Если в классе кончились числа, класс должен вернуть NULL на вызов и getLast() и getFirst().
 */

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(5);
        System.out.println(q.getLastValue());

        q.add(6);
        System.out.println(q.getLastValue());

        q.getLast();
        System.out.println(q.getLastValue());

        q.getFirst();
        System.out.println(q.getFirstValue());
    }
}
