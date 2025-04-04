public class PainelDeControle {
    private Lampada[] lampadas;
    private int quant;
    private int cont;

    public PainelDeControle(int quant){
        this.lampadas = new Lampada[quant];
        this.quant = quant;
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
    public void criaLampada(){
        
    }
}
