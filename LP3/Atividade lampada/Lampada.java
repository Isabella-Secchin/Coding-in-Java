public class Lampada{

    //Lampada:
    private boolean ligada;
    private int cont;
    private int lim;
    private int pot;

    //Construtores para gerar uma lampada:
    public Lampada(int pot, int lim){
        this.ligada = false;
        this.pot = pot;
        this.cont = 0;
        this.lim = lim;
    }

    public Lampada(){
        this.ligada = false;
        this.pot = 15;
        this.cont = 0;
        this.lim = 1000;
    }

    //Getters:
    public int getCont(){
        return cont;
    }
    public int getLim(){
        return lim;
    }
    
    //Funções para lampada:
    public void ligar(Lampada lampada){
        if(lampada.ligada == false){
            cont++;
        }
        lampada.ligada = true;
    }
    public void desligar(Lampada lampada){
        lampada.ligada = false;
    }
    public boolean estaLigada(Lampada lampada){
        return lampada.ligada;
    }
    public int qualAPotencia(Lampada lampada){
        return lampada.pot;
    }
    public boolean devoTrocar(Lampada lampada){
        return lampada.cont > lampada.lim;
    }
    public void trocarLampada(Lampada lampada, int pot, int lim){
        if(devoTrocar(lampada)){
            lampada = new Lampada(pot, lim);
        }
    }
}
