package ba.unsa.etf.si.tim11.forms;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

public class ModelTabele extends AbstractTableModel
{
	
	private static final String[] columnNames = {"username", "ime", "prezime", "datum rođenja", "adresa"};
    private final LinkedList<KorisnikDbModel> lista;

    public ModelTabele() {
        lista = new LinkedList<KorisnikDbModel>();
    }

    public void dodajElement(KorisnikDbModel e) {
        // Adds the element in the last position in the list
        lista.add(e);
        fireTableRowsInserted(lista.size()-1, lista.size()-1);
    }


    public int getColumnCount() {
        return columnNames.length;
    }


    public int getRowCount() {
        return lista.size();
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return lista.get(rowIndex).getUsername();
            case 1: return lista.get(rowIndex).getIme();
            case 2: return lista.get(rowIndex).getPrezime();
            case 3: return lista.get(rowIndex).getDatumRodjenja();
            case 4: return lista.get(rowIndex).getAdresa();
        }
        return null;
    }



}
