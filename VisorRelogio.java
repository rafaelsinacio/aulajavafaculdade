
/**
 * A classe VisorRelogio implementa um visor de relógio digital para um
 * relógio de formato 24h. O relógio mostra horas e minutos.
 * A extensão do relógio é 00:00 (meia-noite) até 23:59 (um minuto antes da
 * meia-noite).
 * 
 * O visor do relógio recebe "tiques" (via o método tique) a cada minuto
 * e reage incrementando o visor. Isso é feito conforme um relógio normal:
 * a hora incrementa quando os minutos giram para zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * Traduzido por Daniel Conrado (nome original: ClockDisplay)
 */
public class VisorRelogio
{
    private VisorNumerico horas;
    private VisorNumerico minutos;
    private String stringExibição;    // simula o visor real
    private VisorNumerico segundos;
    private VisorNumerico semanas;
    /**
     * Construtor de objetos VisorRelogio. Este construtor
     * cria um novo relógio configurado para as 00:00.
     */
    public VisorRelogio()
    {
        horas = new VisorNumerico(24);
        minutos = new VisorNumerico(60);
        segundos = new VisorNumerico(60);
        
        semanas = new VisorNumerico(7);
        atualizarVisor();
    }

    /**
     * Construtor de objetos VisorRelogio. Este construtor
     * cria um novo relógio configurado no tempo especificado
     * pelos parâmetros.
     */
    public VisorRelogio(int hora, int minuto, int segundo, int semana)
    {
        horas = new VisorNumerico(24);
        minutos = new VisorNumerico(60);
        segundos = new VisorNumerico(60);
        semanas = new VisorNumerico(7);
        setTime(hora, minuto, segundo, semana);
    }

    /**
     * Este método deve ser chamado a cada minuto - ele faz
     * o visor do relógio andar um minuto para frente.
     */
    public void tique()
    {
        segundos.incrementar();
        if(segundos.getValor() == 0) 
        {  // acabou de virar!
            minutos.incrementar(); 
            if(minutos.getValor() == 0)
            {
                horas.incrementar();
                if(horas.getValor() == 0)
                {
                    semanas.incrementar();
                }
            }
        }
        atualizarVisor();
    }

    /**
     * COnfigura o tempo do visor para a hora e minuto especificados.
     */
    public void setTime(int hora, int minuto, int segundo, int semana)
    {
        horas.setValor(hora);
        minutos.setValor(minuto);
        segundos.setValor(segundo);
        semanas.setValor(semana);
        atualizarVisor();
    }

    /**
     * Retorna o tempo atual deste visor no formato HH:MM.
     */
    public String getTempo()
    {
        return stringExibição;
    }
    
    /**
     * Atualiza a string interna que representa o visor.
     */
    private void atualizarVisor()
    {
        if(semanas.getValor() == 0)
        {
            stringExibição = horas.getValorExibição() + ":" + 
                        minutos.getValorExibição() + ":" + segundos.getValorExibição() + " Dom";
        }
        
        if(semanas.getValor() == 1)
        {
            stringExibição = horas.getValorExibição() + ":" + 
                        minutos.getValorExibição() + ":" + segundos.getValorExibição() + " Seg";
        }
        
        if(semanas.getValor() == 2)
        {
            stringExibição = horas.getValorExibição() + ":" + 
                        minutos.getValorExibição() + ":" + segundos.getValorExibição() + " Ter";
        }
        
        if(semanas.getValor() == 3)
        {
            stringExibição = horas.getValorExibição() + ":" + 
                        minutos.getValorExibição() + ":" + segundos.getValorExibição() + " Qua";
        }
        
        if(semanas.getValor() == 4)
        {
            stringExibição = horas.getValorExibição() + ":" + 
                        minutos.getValorExibição() + ":" + segundos.getValorExibição() + " Qui";
        }
        
        if(semanas.getValor() == 5)
        {
            stringExibição = horas.getValorExibição() + ":" + 
                        minutos.getValorExibição() + ":" + segundos.getValorExibição() + " Sex";
        }
        
        if(semanas.getValor() == 6)
        {
            stringExibição = horas.getValorExibição() + ":" + 
                        minutos.getValorExibição() + ":" + segundos.getValorExibição() + " Sab";
        }
    }
}
