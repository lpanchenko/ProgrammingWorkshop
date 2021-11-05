package Tasks;

public class Queue {
    QueueItem last;
    QueueItem first;

    public void add (int value) {

        if (last == null) {
            last = new QueueItem(value, null, null);
            first = last;
        }
        else{
            QueueItem previous = last;
            last = new QueueItem(value, previous, null);
            previous.Next = last;
        }
    }

    public int getLast() {

        QueueItem temp = last;
        last = last.Previous;
        last.Next = null;
        return temp.Value;
    }

    public int getFirst() {

        QueueItem temp = first;
        first = first.Next;
        return temp.Value;
    }

    public int getLastValue() {

        return last.Value;
    }

    public int getFirstValue() {

        return first.Value;
    }
}


