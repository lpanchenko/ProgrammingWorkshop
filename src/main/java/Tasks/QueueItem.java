package Tasks;

public class QueueItem {
    public QueueItem Previous;
    public QueueItem Next;
    public int Value;

    public QueueItem(int value, QueueItem previous, QueueItem next) {
        Value = value;
        Previous = previous;
        Next = next;
    }
}
