import java.util.Scanner;

class Data{
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
        System.out.println(dia + "/" + mes + "/" + ano);
    }
}

public class Main{
    public static void main(String[] args){
        int i, j;
        Scanner scanner = new Scanner(System.in);
        Data[] datas = new Data[i];
        System.out.println("Entre com a quantidade de datas que deseja adicionar:");
        i = scanner.nextInt();
        for(j = 0; j < i; j++){
            System.out.printf("Entre com o dia %d:\n", j + 1);
            int dia = scanner.nextInt();
            System.out.printf("Entre com o mes %d:\n", j + 1);
            int mes = scanner.nextInt();
            System.out.printf("Entre com o ano %d:\n", j + 1);
            int ano = scanner.nextInt();
            datas[j] = new Data(dia, mes, ano);
        }
        System.out.println("\nAs datas cadastradas são:");
        for (int j = 0; j < i; j++) {
            datas[j].exibirData();  // Call exibirData() for each Data object
        }

        scanner.close();
    }
}