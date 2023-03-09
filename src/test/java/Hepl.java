import java.util.*;
public class Hepl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(); // 包裹数
        int n = scanner.nextInt(); // 道路数
        Map<String, Set<String>> packageMap = new HashMap<>(); // 包裹与站点之间的映射关系
        Map<String, Set<String>> graph = new HashMap<>(); // 站点之间的图

        // 读入包裹信息
        for (int i = 0; i < m; i++) {
            String packageName = scanner.next();
            String from = scanner.next();
            String to = scanner.next();
            Set<String> set = packageMap.getOrDefault(packageName, new HashSet<>());
            set.add(from);
            set.add(to);
            packageMap.put(packageName, set);
        }

        // 读入道路信息，构建图
        for (int i = 0; i < n; i++) {
            String from = scanner.next();
            String to = scanner.next();
            Set<String> set = graph.getOrDefault(from, new HashSet<>());
            set.add(to);
            graph.put(from, set);
            set = graph.getOrDefault(to, new HashSet<>());
            set.add(from);
            graph.put(to, set);
        }

        Set<String> cannotArrivePackages = new TreeSet<>(); // 不能送达的包裹
        for (String packageName : packageMap.keySet()) {
            Set<String> visited = new HashSet<>();
            if (!dfs(packageMap.get(packageName), graph, visited)) { // 不能送达
                cannotArrivePackages.add(packageName);
            }
        }

        if (cannotArrivePackages.isEmpty()) {
            System.out.println("none");
        } else {
            for (String packageName : cannotArrivePackages) {
                System.out.println(packageName);
            }
        }
    }

    // 深度优先遍历图
    private static boolean dfs(Set<String> stations, Map<String, Set<String>> graph, Set<String> visited) {
        for (String station : stations) {
            if (visited.contains(station)) {
                continue;
            }
            visited.add(station);
            if (!graph.containsKey(station)) { // 如果当前站点没有出边，则可以送达
                return true;
            }
            if (dfs(graph.get(station), graph, visited)) { // 递归遍历相邻站点
                return true;
            }
        }
        return false;
    }


}
