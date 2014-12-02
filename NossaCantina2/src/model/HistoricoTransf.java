package model;

/**
 *
 * @author MauricioBertodo
 */
public class HistoricoTransf {
    
    private int idTransferencia;
    private String nomeUsaurioLogado;
    private int contaUsuarioLogado;
    private String valorDepositado;
    private String dataDeposito;
    private String nomeUsuarioTransferencia;
    private int contaUsuarioTransferencia;

    public HistoricoTransf(int idTransferencia, String nomeUsaurioLogado, int contaUsuarioLogado, String valorDepositado, String dataDeposito, String nomeUsuarioTransferencia, int contaUsuarioTransferencia) {
        this.idTransferencia = idTransferencia;
        this.nomeUsaurioLogado = nomeUsaurioLogado;
        this.contaUsuarioLogado = contaUsuarioLogado;
        this.valorDepositado = valorDepositado;
        this.dataDeposito = dataDeposito;
        this.nomeUsuarioTransferencia = nomeUsuarioTransferencia;
        this.contaUsuarioTransferencia = contaUsuarioTransferencia;
    }
    public HistoricoTransf(String nomeUsaurioLogado, int contaUsuarioLogado, String valorDepositado, String dataDeposito, String nomeUsuarioTransferencia, int contaUsuarioTransferencia) {
        this.nomeUsaurioLogado = nomeUsaurioLogado;
        this.contaUsuarioLogado = contaUsuarioLogado;
        this.valorDepositado = valorDepositado;
        this.dataDeposito = dataDeposito;
        this.nomeUsuarioTransferencia = nomeUsuarioTransferencia;
        this.contaUsuarioTransferencia = contaUsuarioTransferencia;
    }
    
    public void setNomeUsaurioLogado(String nomeUsaurioLogado) {
        this.nomeUsaurioLogado = nomeUsaurioLogado;
    }

    public void setContaUsuarioLogado(int contaUsuarioLogado) {
        this.contaUsuarioLogado = contaUsuarioLogado;
    }

    public void setValorDepositado(String valorDepositado) {
        this.valorDepositado = valorDepositado;
    }

    public void setDataDeposito(String dataDeposito) {
        this.dataDeposito = dataDeposito;
    }

    public void setNomeUsuarioTransferencia(String nomeUsuarioTransferencia) {
        this.nomeUsuarioTransferencia = nomeUsuarioTransferencia;
    }

    public void setContaUsuarioTransferencia(int contaUsuarioTransferencia) {
        this.contaUsuarioTransferencia = contaUsuarioTransferencia;
    }
    
    public int getIdTransferencia() {
        return idTransferencia;
    }

    public String getNomeUsaurioLogado() {
        return nomeUsaurioLogado;
    }

    public int getContaUsuarioLogado() {
        return contaUsuarioLogado;
    }

    public String getValorDepositado() {
        return valorDepositado;
    }

    public String getDataDeposito() {
        return dataDeposito;
    }

    public String getNomeUsuarioTransferencia() {
        return nomeUsuarioTransferencia;
    }

    public int getContaUsuarioTransferencia() {
        return contaUsuarioTransferencia;
    }
    
    @Override
    public String toString() {
        return "Nome:" + nomeUsaurioLogado + "  Conta:" + contaUsuarioLogado + "    Valor Deposito:" + valorDepositado + 
                "   Data Deposito:" + dataDeposito + "  Transferido para: "+ nomeUsuarioTransferencia + "   Conta:" + contaUsuarioTransferencia;
    }
    
}
