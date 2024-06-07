import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {

    Character[][] map;
    ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
    int monster = 0;
    Queue<Node> toVisit = new LinkedList<>();

    public Algorithm(Character[][] map) {
        this.map = map;
        mapToNodes();
    }

    private void mapToNodes() {
        for (int i = 0; i < map.length; i++) {
            ArrayList<Node> row = new ArrayList<>();
            for (int j = 0; j < map[0].length; j++) {
                row.add(new Node(i, j, map[i][j], 1000000));
            }
            nodes.add(row);
        }
    }

    public Character[][] findPath() {
        int[] exit = findExit();
        if (exit[0] == -1) {
            System.out.println("no exit");
            return new Character[][]{{'!', '!', '!'}, {'!', '!', '!'}, {'!', '!', '!'}};
        }
        buildPath(exit[0], exit[1]);
        return listNodeToArray(nodes);
    }

    private int[] findExit() {
        nodes.get(1).get(0).setDistance(1);
        nodes.get(1).get(0).setVisited(true);
        toVisit.add(nodes.get(1).get(0));
        findDistanceToOtherNodes();
        int[] exit = new int[]{-1, -1};
        int minDistance = 1_000_000_000;
        int curDistance;
        for (int i = 0; i < nodes.get(0).size(); i++) {
            curDistance = nodes.get(0).get(i).getDistance();
            if (curDistance < minDistance && curDistance > 0) {
                minDistance = curDistance;
                exit[0] = nodes.get(0).get(i).getX();
                exit[1] = nodes.get(0).get(i).getY();
            }
            curDistance = nodes.get(nodes.size() - 1).get(i).getDistance();
            if (curDistance < minDistance && curDistance > 0) {
                minDistance = curDistance;
                exit[0] = nodes.get(nodes.size() - 1).get(i).getX();
                exit[1] = nodes.get(nodes.size() - 1).get(i).getY();
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            curDistance = nodes.get(i).get(nodes.get(0).size() - 1).getDistance();
            if (curDistance < minDistance && curDistance > 0) {
                minDistance = curDistance;
                exit[0] = nodes.get(i).get(nodes.get(0).size() - 1).getX();
                exit[1] = nodes.get(i).get(nodes.get(0).size() - 1).getY();
            }
        }
        for (int i = 2; i < nodes.size(); i++) {
            curDistance = nodes.get(i).get(0).getDistance();
            if (curDistance < minDistance && curDistance > 0) {
                minDistance = curDistance;
                exit[0] = nodes.get(i).get(0).getX();
                exit[1] = nodes.get(i).get(0).getY();
            }
        }
        return exit;
    }

    private void findDistanceToOtherNodes() {
        int distance;
        while (!toVisit.isEmpty()) {
            int x = toVisit.element().getX();
            int y = toVisit.element().getY();
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : directions) {
                int cur_x = x + dir[0];
                int cur_y = y + dir[1];
                if (0 <= cur_x && cur_x < nodes.size()
                        && 0 <= cur_y && cur_y < nodes.get(0).size()
                        && !nodes.get(cur_x).get(cur_y).isVisited()
                        && nodes.get(cur_x).get(cur_y).getType() != 'x') {
                    distance = nodes.get(x).get(y).getDistance();
                    nodes.get(cur_x).get(cur_y).setDistance(++distance);
                    nodes.get(cur_x).get(cur_y).setVisited(true);
                    toVisit.add(nodes.get(cur_x).get(cur_y));
                }
            }
            toVisit.remove();
        }
    }

    private void buildPath(int x, int y) {
        if (String.valueOf(nodes.get(x).get(y).getType()).equals("@")) {
            monster++;
        }
        nodes.get(x).get(y).setType('o');
        int curDist = nodes.get(x).get(y).getDistance();
        if (x > 0 && nodes.get(x - 1).get(y).getDistance() < curDist) {
            buildPath(x - 1, y);
        } else if (x < nodes.size() - 1 && nodes.get(x + 1).get(y).getDistance() < curDist) {
            buildPath(x + 1, y);
        } else if (y > 0 && nodes.get(x).get(y - 1).getDistance() < curDist) {
            buildPath(x, y - 1);
        } else if (y < nodes.get(x).size() - 1 && nodes.get(x).get(y + 1).getDistance() < curDist) {
            buildPath(x, y + 1);
        }
    }

    public static Character[][] listNodeToArray(ArrayList<ArrayList<Node>> list) {
        Character[][] array = new Character[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                array[i][j] = list.get(i).get(j).getType();
            }
        }
        return array;
    }
}
