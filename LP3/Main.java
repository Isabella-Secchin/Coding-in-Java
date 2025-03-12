import java.util.Arrays;
import java.util.Scanner;

class Data implements Comparable<Data>{
    private int dia;
    private int mes;
    private int ano;
    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAno(){
        return ano;
    }
    public void setDia(int dia){
        this.dia = dia;
    }
    public void setMes(int mes){
        this.mes = mes;
    }
    public void setAno(int ano){
        this.ano = ano;
    }
    public void exibirData(){
        System.out.printf("%02d/%02d/%04d\n", dia, mes, ano);
    }
    @Override
    public int compareTo(Data outraData) {
        if (this.ano != outraData.ano) {
            return this.ano - outraData.ano;  // Compara os anos
        } else if (this.mes != outraData.mes) {
            return this.mes - outraData.mes;  // Compara os meses
        } else {
            return this.dia - outraData.dia;  // Compara os dias
        }
    }
}

public class Main{
    public static void main(String[] args){
        int i, j;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre com a quantidade de datas que deseja adicionar:");
        i = scanner.nextInt();
        scanner.nextLine();
        Data[] datas = new Data[i];
        for (j = 0; j < i; j++) {
            System.out.printf("Digite a data %d no formato dd/mm/aaaa:\n", j + 1);
            String dataString = scanner.nextLine();
            String[] partes = dataString.split("/");
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);
            if(mes < 1 || mes > 12){
                System.out.println("Mes invalido!");
                j--;
                continue;
            }
            if (dia < 1 || dia > 31){
                System.out.println("Dia invalido!");
                j--;
                continue;
            }
            if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30){
                System.out.println("Dia invalido!");
                j--;
                continue;
            }
            if (mes == 2){
                boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
                if (dia > 29 || (dia == 29 && !bissexto)){
                    System.out.println("Dia invalido!");
                    j--;
                    continue;
                }
            }
            datas[j] = new Data(dia, mes, ano);
        }
        Arrays.sort(datas);
        System.out.println("\nAs datas cadastradas em ordem cronologica são:");
        for (j = 0; j < i; j++) {
            datas[j].exibirData();  
        }
        scanner.close();
    }
}
