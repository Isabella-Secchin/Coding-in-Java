public class ListaCompromissoNO{
    private DataV5[] compromissos;
    private int cap;
    private int cont;

    public ListaCompromissoNO(int cap){
        this.compromissos = new DataV5[cap];
        this.cap = cap;
        this.cont = 0;
    }

    public void adicionarCompromisso(DataV5 data){
        if(!verificaCompromisso(data)){
            if(cont < cap){
                compromissos[cont] = data;
                cont++;
                System.out.printf("O compromisso foi marcado!");
            }
            else System.out.printf("A lista esta cheia!\n");
        }
    }

    public void desmarcarCompromisso(DataV5 data){
        for(int i = 0; i <= cont; i++){
            if(data == compromissos[i]){
                compromissos[i] = null;
                for( ; i <= cont; i++){
                    compromissos[i] = compromissos[i + 1];
                }
                cont--;
                System.out.printf("O compromisso foi desmarcado!");
                return;
            }
        }
    }

    public boolean verificaCompromisso(DataV5 data){
        for(int i = 0; i <= cont; i++){
            if(data == compromissos[i]){
                System.out.printf("Ja existe um compromisso nessa data!\n");
                return true;
            }
        }
        return false;
    }

    public void listarCompromissos(DataV5[] compromissos){
        for(int i = 0; i <= cont; i++){
            compromissos[i].mostraData();
        }
    }
}
