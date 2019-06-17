package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Bebida;

public class BebidaView extends AbstractTableModel{
    
    private ArrayList<Bebida> linhas;
    private String[] colunas = new String[]{"Código","Sabor","Tamanho","Preço"};
    
    public BebidaView(){
        linhas = new ArrayList<Bebida>();
    }
    
    public BebidaView(ArrayList<Bebida> bebidas){
        linhas = new ArrayList<Bebida>(bebidas);
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override 
    public String getColumnName(int coluna){
        return colunas[coluna];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return linhas.get(linha).getCodigo();
            case 1:
                return linhas.get(linha).getNome();
            case 3:
                return linhas.get(linha).getTamanho();
            case 4:
                return linhas.get(linha).getPreco();
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna){
            case 0:
                linhas.get(linha).setCodigo(Integer.parseInt((String)valor));
                break;
            case 1:
                linhas.get(linha).setNome((String)valor);
                break;
            case 3:
                linhas.get(linha).setTamanho((String)valor);
                break;
            case 4:
                linhas.get(linha).setPreco(Double.parseDouble((String)valor));
        } 
        fireTableRowsUpdated(linha, linha);
    }
    
    public void addProdutos(Bebida v){       
        linhas.add(v);
        fireTableDataChanged();
    }
    
    public void remove(int indiceLinha){
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    public Bebida getProduto(int indiceLinha){
        return linhas.get(indiceLinha);
    }
    
    public List<Bebida> getBebidas(){
        return linhas;
    }
    
    public void setBebidas(List<Bebida> bebidas){
        
        int tamanhoAntigo = this.getRowCount();

        linhas.addAll(bebidas);
        fireTableRowsInserted(tamanhoAntigo, this.getRowCount() - 1);
    }
    
    public void limpar(){
        linhas.clear();
        fireTableDataChanged();
    }
    
    public boolean isEmpty(){
        return linhas.isEmpty();
    }
}