public class app {

    public static void main(String[] args) {
        // Создание нового списка
        MyLinkedList<String> myList = new MyLinkedList<>();
        // Добавление элементов
        myList.addFirst("A");
        myList.addLast("B");
        myList.addLast("C");
        // Вывод элементов списка
        System.out.println("First element: " + myList.get(0)); // Получение первого элемента
        System.out.println("Second element: " + myList.get(1)); // Получение второго элемента
        System.out.println("List size: " + myList.size()); // Вывод размера списка
    }

    // Класс узла списка
    public static class Node<T> {
        T data; // Данные узла
        Node<T> next; // Ссылка на следующий узел

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Класс связного списка
    public static class MyLinkedList<T> {
        private Node<T> head; // Начало списка
        private int size; // Размер списка

        public MyLinkedList() {
            head = null;
            size = 0;
        }

        // Добавление элемента в начало списка
        public void addFirst(T data) {
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
            size++;
        }

        // Добавление элемента в конец списка
        public void addLast(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                // Если список пуст, новый элемент становится головой списка
                head = newNode;
            } else {
                // Иначе идем до конца списка и добавляем элемент
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        // Получение элемента по индексу
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        // Получение размера списка
        public int size() {
            return size;
        }
    }
}
