public class PainelDeControle{
    private Lampada[] lampadas;
    private int quant;
    private int cont;

    public PainelDeControle(int quant){
        this.lampadas = new Lampada[quant];
        if(quant < 30){
            this.quant = 30;
        }
        else{
            this.quant = quant;
        }
        this.cont = 0;
    }

    public PainelDeControle(){
        this.lampadas = new Lampada[quant];
        this.quant = 30;
        this.cont = 0;
    }

    //Getters:
    public int getQuant(){
        return quant;
    }
    public Lampada[] getLampadas(){
        return lampadas;
    }

    //Funções do painel:
    public boolean criaLampada(){
        if(quant > cont){
            lampadas[cont] = new Lampada();
            cont++;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean criaLampada(int pot, int lim){
        if(quant > cont){
            lampadas[cont] = new Lampada(pot,lim);
            cont++;
            return true;
        }
        else{
            return false;
        }
    }
    public void ligar(Lampada[] lampadas){
        for(int i = 0; i < cont; i++){
            lampadas[i].ligar(lampadas[i]);
        }
    }
    public void desligar(Lampada[] lampadas){
        for(int i = 0; i < cont; i++){
            lampadas[i].desligar(lampadas[i]);
        }
    }
    public void verificar(Lampada[] lampadas){
        System.out.printf("Lampadas que devem ser trocadas:\n\n");
        for(int i = 0; i < cont; i++){
            if(lampadas[i].devoTrocar(lampadas[i])){
                System.out.printf("A lampada %d deve ser trocada.\n", i);
            }
        }
    }
}
