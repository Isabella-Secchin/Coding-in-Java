public class DataV5 {

    // Encapsulamento public
    private byte dia;
    private byte mes;
    private short ano;

     
    public DataV5() {
        dia = 1;
        mes = 1;
        ano = 1970;
    }

    public DataV5(DataV5 outraData) {
        dia = outraData.dia;
        mes = outraData.mes;
        ano = outraData.ano;
    }

    public DataV5(DataV5 outraData, int dias) {
        dia = outraData.dia;
        mes = outraData.mes;
        ano = outraData.ano;
        for (int i = 0; i < dias; i++) {
            dia++;
            if (!dataValida(dia, mes, ano)) {
                dia = 1;
                mes++;
                if (!dataValida(dia, mes, ano)) {
                    mes = 1;
                    ano++;
                }
            }
        }
    }

    public DataV5(byte dia, byte mes, short ano) {
        this();
        if (dataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } 
    }
    
    public boolean iniData(byte d, byte m, short a) {
        if (!dataValida(d, m, a)) {
            return false;
        }
        dia = d;
        mes = m;
        ano = a;
        return true;
    }

    public static boolean dataValida(byte d, byte m, short a) 
    {
        byte diasMes[] = {31,28,31,30,31,30,31,31,30,31,30,31};

        if (a < 0) {
            return false;
        }

        if (m < 1 || m > 12) {
            return false;
        }

        if (d < 1 || d > diasMes[m-1]) {
            return false;
        }

        // ano bisexto
        if (m == 2 && d == 29) {
            if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }  

    public void mostraData() {
        System.out.println(dia + "/" + mes + "/" + ano);
    }

    public byte getDia() {
        return dia;
    }

    public byte getMes() {
        return mes;
    }

    public short getAno() {
        return ano;
    }

    public boolean setDia(byte d) {
        if (dataValida(d, mes, ano)) {
            dia = d;
            return true;
        }else {
            return false;
        }
    }

    public boolean setMes(byte m) {
        if (dataValida(dia, m, ano)) {
            mes = m;
            return true;
        }else{
            return false;
        }
    }

    public boolean setAno(short a) {
        if (dataValida(dia, mes, a)) {
            ano = a;
            return true;
        }else{
            return false;
        }   
    }

    public boolean igualA(DataV5 outraData) {
        if(dia == outraData.dia && mes == outraData.mes && ano == outraData.ano){
            return true;
        }
        return false;
    }

    public static boolean igualA(DataV5 data1, DataV5 data2) {
        if(data1.dia == data2.dia && data1.mes == data2.mes && data1.ano == data2.ano){
            return true;
        }
        return false;
    }

    public boolean diferenteDe(DataV5 outraData) {
        if(dia != outraData.dia || mes != outraData.mes || ano != outraData.ano ){
            return true;
        }
        return false;
    }

    public static boolean diferenteDe(DataV5 data1, DataV5 data2) {
        if(data1.dia != data2.dia || data1.mes != data2.mes || data1.ano != data2.ano){
            return true;
        }
        return false;
    }

    // menorQue
    public boolean anterior(DataV5 outraData) {
        if(ano < outraData.ano){
            return true;
        }
        else if(mes < outraData.mes && ano <= outraData.ano){
            return true;
        }
        else if(dia < outraData.dia && ano <= outraData.ano && mes <= outraData.mes){
            return true;
        }
        return false;
    }

    // menorQue
    public static boolean anterior(DataV5 data1, DataV5 data2) {
        if(data1.ano < data2.ano){
            return true;
        }
        else if(data1.mes < data2.mes && data1.ano <= data2.ano){
            return true;
        }
        else if(data1.dia < data2.dia && data1.ano <= data2.ano && data1.mes <= data2.mes){
            return true;
        }
        return false;
    }

    // maiorQue
    public boolean posterior(DataV5 outraData) {
        if(ano > outraData.ano){
            return true;
        }
        else if(mes > outraData.mes && ano >= outraData.ano){
            return true;
        }
        else if(dia > outraData.dia && ano >= outraData.ano && mes >= outraData.mes){
            return true;
        }
        return false;
    }
    // maiorQue
    public static boolean posterior(DataV5 data1, DataV5 data2) {
        if(data1.ano > data2.ano){
            return true;
        }
        else if(data1.mes > data2.mes && data1.ano >= data2.ano){
            return true;
        }
        else if(data1.dia > data2.dia && data1.ano >= data2.ano && data1.mes >= data2.mes){
            return true;
        }
        return false;
    }

    public boolean maiorOuIgual(DataV5 outraData) {
        if(igualA(outraData) && posterior(outraData)){
            return true;
        }
        return false;
    }

    public static boolean maiorOuIgual(DataV5 data1, DataV5 data2) {
        if(igualA(data1, data2) && posterior(data1, data2)){
            return true;
        }
        return false;
    }

    public boolean menorOuIgual(DataV5 outraData) {
        if(igualA(outraData) && anterior(outraData)){
            return true;
        }
        return false;
    }

    public static boolean menorOuIgual(DataV5 data1, DataV5 data2) {
       if(igualA(data1, data2) && anterior(data1, data2)){
            return true;
        }
        return false;
    }
}