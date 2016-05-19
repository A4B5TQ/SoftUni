import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pat = Pattern.compile("\"Project\": \\[\"(?<project>.*)\"\\], \"Type\": \\[\"(?<type>.*)\"\\], \"Message\": \\[\"(?<message>.*)\"\\]");

        String input = sc.nextLine();

        TreeMap<String, SortedList<String>> projectsCritical = new TreeMap<>();
        TreeMap<String, SortedList<String>> projectsWarning = new TreeMap<>();
        TreeMap<String, Integer> countMap = new TreeMap<>();

        while (!input.equals("END")) {
            Matcher match = pat.matcher(input);
            match.find();
            int counter = 0;
            if (!projectsCritical.containsKey(match.group("project"))) {
                projectsCritical.put(match.group("project"), new SortedList<String>());
            }
            if (!projectsWarning.containsKey(match.group("project"))) {
                projectsWarning.put(match.group("project"), new SortedList<String>());
            }

            if (match.group("type").equals("Critical")) {
                if (projectsCritical.containsKey(match.group("project"))) {
                    SortedList<String> critSort = projectsCritical.get(match.group("project"));
                    critSort.add(match.group("message"));
                    counter++;
                    projectsCritical.put(match.group("project"), critSort);
                }
            } else if (match.group("type").equals("Warning")) {

                if (projectsWarning.containsKey(match.group("project"))) {
                    SortedList<String> warnSort = projectsWarning.get(match.group("project"));
                    warnSort.add(match.group("message"));
                    projectsWarning.put(match.group("project"), warnSort);
                    counter++;
                }
            }
            if (!countMap.containsKey(match.group("project"))) {

                countMap.put(match.group("project"), 0);
            }
            int tempCoount = countMap.get(match.group("project"));
            countMap.put(match.group("project"), tempCoount + counter);
            input = sc.nextLine();
        }
        countMap.entrySet().stream().sorted((e1, e2) -> {
            return Integer.compare(e2.getValue(), e1.getValue());
        }).forEach(project -> {
            System.out.println(project.getKey() + ":");
            System.out.println("Total Errors: " + project.getValue());
            System.out.println("Critical: " + projectsCritical.get(project.getKey()).size());
            System.out.println("Warnings: " + projectsWarning.get(project.getKey()).size());
            System.out.println("Critical Messages:");
            if (projectsCritical.get(project.getKey()).size() != 0){
                projectsCritical.get(project.getKey()).stream().forEach(e -> {
                    System.out.println("--->" + e);
                });
            } else {
                System.out.println("--->None");
            }
            System.out.println("Warning Messages:");
            if (projectsWarning.get(project.getKey()).size() != 0){
                projectsWarning.get(project.getKey()).stream().forEach(e -> {
                    System.out.println("--->" + e);
                });
            } else {
                System.out.println("--->None");
            }
            System.out.println();
        });
    }


    public static class SortedList<E extends Comparable> implements List<E> {

        /**
         * The list of elements
         */
        private final List<E> list = new ArrayList();

        public E first() {
            return list.get(0);
        }

        public E last() {
            return list.get(list.size() - 1);
        }

        public E mid() {
            return list.get(list.size() >>> 1);
        }

        @Override
        public void clear() {
            list.clear();
        }

        @Override
        public boolean add(E e) {
            list.add(e);
            Collections.sort(list, new Comparator() {
                public int compare(Object o1, Object o2) {
                    int p = ((String) o1).length();
                    int p2 = ((String) o2).length();
                    return Integer.compare(p, p2);
                }
            }.thenComparing(Comparator.naturalOrder()));
            return true;
        }

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public boolean contains(Object obj) {
            return list.contains((E) obj);
        }

        @Override
        public Iterator<E> iterator() {
            return list.iterator();
        }

        @Override
        public Object[] toArray() {
            return list.toArray();
        }

        @Override
        public <T> T[] toArray(T[] arg0) {
            return list.toArray(arg0);
        }

        @Override
        public boolean remove(Object obj) {
            return list.remove((E) obj);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return list.containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {

            list.addAll(c);
            Collections.sort(list);
            return true;
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return list.removeAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return list.retainAll(c);
        }

        @Override
        public E get(int index) {
            return list.get(index);
        }

        @Override
        public E set(int index, E element) {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public void add(int index, E element) {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public E remove(int index) {
            return list.remove(index);
        }

        @Override
        public int indexOf(Object obj) {
            return list.indexOf((E) obj);
        }

        @Override
        public int lastIndexOf(Object obj) {
            return list.lastIndexOf((E) obj);
        }

        @Override
        public ListIterator<E> listIterator() {
            return list.listIterator();
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return list.listIterator(index);
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            throw new UnsupportedOperationException("Not supported.");
        }

    }
}
