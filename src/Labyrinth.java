import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Labyrinth {
    public String[][] laby;
    public LinkedQueue queue = new LinkedQueue(9999);
    public Coordinate entry;
    public Coordinate exit;
    public Coordinate current;

    public Labyrinth() throws IOException {
        this.readLaby();
        this.current = entry;
    }

    public void readLaby() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file1.txt"));
        String line = br.readLine();

        try {
            StringBuilder sb = new StringBuilder();

            int nCol = 0;
            while (true) {
                if(line == null){
                    break;
                }
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();

                if(line != null){
                    nCol = line.split("").length;
                }
            }

            String all = sb.toString();
            int nRow = all.split("\n").length;
            String[][] labyAux= new String[nRow][nCol];
            String[] lines = all.split(System.lineSeparator());

            for (int i = 0; i < lines.length; i++) {
                String[] items = lines[i].split("");
                for (int j = 0; j < items.length; j++) {
                    labyAux[i][j] = items[j];
                }
            }

            this.laby = labyAux;

            for (int i = 0; i < this.laby.length; i++) {
                for (int j = 0; j < this.laby[i].length; j++) {
                    if(Objects.equals(this.laby[i][j], "E")){
                        entry = new Coordinate(i, j);
                    }
                    if(Objects.equals(this.laby[i][j], "S")){
                        exit = new Coordinate(i, j);
                    }
                }
            }
        } finally {
            br.close();
        }
    }

    public void printLaby(){
        for (int i = 0; i < this.laby.length; i++) {
            for (int j = 0; j < this.laby[i].length; j++) {
                if(this.laby[i][j] == null){
                    //System.out.print(" ");
                }else {
                    System.out.print(this.laby[i][j]);
                }
                //Space between columns
                System.out.print(" ");
            }
            //Space between lines
            System.out.println();
        }
    }

    public void solve() throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);

        while (true) {
            this.printLaby();

            System.out.println("Programe seus passos para chegar no 'S'!");
            System.out.println("Comandos enfileirados: " + this.queue.count);
            System.out.println("-=-=-=-=-=-=| COMANDOS |=-=-=-=-=-=-");
            System.out.println("[ U ] - UP");
            System.out.println("[ D ] - DOWN");
            System.out.println("[ L ] - LEFT");
            System.out.println("[ R ] - RIGHT");
            System.out.println("[ G ] - GO");
            System.out.println("[ X ] - RESTART");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            String command = scan.nextLine();

            ArrayList<String> sla = new ArrayList<>();
            sla.add("U");
            sla.add("D");
            sla.add("L");
            sla.add("R");
            command = command.toUpperCase().trim();
            if (sla.contains(command)) {
                Coordinate coord = validateMove(command);

                if (coord != null) {
                    this.queue.add(coord);
                } else {
                    System.out.println("Movimento inválido! Tente outro!");
                }
            }
            if (command.equals("G")) {
                boolean win = go();
                if(win){
                    System.out.println("GG!");
                }else{
                    System.out.println("DEFEAT!");
                }

                while(true){
                    System.out.println("Deseja jogar novamente?");
                    System.out.println("[ 1 ] - Sim");
                    System.out.println("[ 2 ] - Não");
                    int game = scan.nextInt();

                    if(game == 1){
                        this.queue.clear();
                        this.readLaby();
                        this.current = entry;
                        System.out.println("RESTART!");
                        break;
                    }else if(game == 2){
                        System.exit(0);
                    }else{
                        System.out.println("Opção inválida");
                    }
                }
            }

            if (command.equals("X")) {
                this.queue.clear();
                this.readLaby();
                this.current = entry;
                System.out.println("RESTART!");
            }

        }
    }

    public Coordinate validateMove(String coord){
        Coordinate up       = new Coordinate(this.current.x - 1, this.current.y);
        Coordinate down     = new Coordinate(this.current.x + 1, this.current.y);
        Coordinate left     = new Coordinate(this.current.x, this.current.y - 1);
        Coordinate right    = new Coordinate(this.current.x, this.current.y + 1);

        switch(coord) {
            case "U":
                if (Objects.equals(this.laby[up.x][up.y], " ") || this.laby[up.x][up.y].equals("S")) {
                    this.laby[up.x][up.y] = "-";
                    this.current = up;
                    return up;
                }else{
                    return null;
                }
            case "D":
                if (Objects.equals(this.laby[down.x][down.y], " ") || this.laby[down.x][down.y].equals("S")) {
                    this.laby[down.x][down.y] = "-";
                    this.current = down;
                    return down;
                }else{
                    return null;
                }
            case "L":
                if (Objects.equals(this.laby[left.x][left.y], " ") || this.laby[left.x][left.y].equals("S")) {
                    this.laby[left.x][left.y] = "-";
                    this.current = left;
                    return left;
                }else{
                    return null;
                }
            case "R":
                if (Objects.equals(this.laby[right.x][right.y], " ") || this.laby[right.x][right.y].equals("S")) {
                    this.laby[right.x][right.y] = "-";
                    this.current = right;
                    return right;
                }else{
                    return null;
                }
            default:
                return null;
        }
    }

    public boolean go() throws InterruptedException {
        boolean win = false;
        Node node = this.queue.first;
        int count = this.queue.count;
        for (int i = 0; i <= count; i++) {
            if(node == null){
                break;
            }

            if(node.coord.x == this.exit.x && node.coord.y == this.exit.y){
                win = true;
            }else{
                win = false;
            }

            this.laby[node.getCoord().x][node.getCoord().y] = "*";
            node = node.getNext();
            queue.remove();

            this.printLaby();
            MILLISECONDS.sleep(500);
        }

        return win;
    }

}

