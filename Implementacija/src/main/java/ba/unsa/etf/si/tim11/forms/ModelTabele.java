package ba.unsa.etf.si.tim11.forms;

import java.util.Date;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.Validator;

public class ModelTabele extends AbstractTableModel
{
	
	private static final String[] columnNames = {"Ime", "Prezime", "Datum rođenja", "Adresa", "Id Tip Korisnika"," IdPozicija Korisnika","Aktivan"};
    private final LinkedList<KorisnikDbModel> lista;

    public ModelTabele() {
        lista = new LinkedList<KorisnikDbModel>();
    }

    public void dodajElement(KorisnikDbModel e) {
        // Adds the element in the last position in the list
        lista.add(e);
        fireTableRowsInserted(lista.size()-1, lista.size()-1);
    }
    
    public void ocistiListu()
    {
    	lista.clear();
    	fireTableRowsDeleted(lista.size()-1, lista.size()-1);
    }


    public int getColumnCount() {
        return columnNames.length;
    }


    public int getRowCount() {
        return lista.size();
    }
    /*public void setRowCount(int i)
    {
    	lista.clear();
    }*/
    public boolean isCellEditable(int row, int col) {
            return true;
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return lista.get(rowIndex).getIme();
            case 1: return lista.get(rowIndex).getPrezime();
            case 2: return lista.get(rowIndex).getDatumRodjenja();
            case 3: return lista.get(rowIndex).getAdresa();
            case 4: return lista.get(rowIndex).getKorisnikTipId();
            case 5: return lista.get(rowIndex).getKorisnikPozicijaId();
            case 6: return lista.get(rowIndex).getAktivan();
        }
        return null;
    }
    
    public void setValueAt(Object value, int row, int col) {
    	
        switch(col)
        {
        	case 0: 
        		if(!Validator.daLiJeStringPrazan((String)value)&&Validator.daLiJeStringSamoSlova((String)value))
        		{
        			lista.get(row).setIme((String)value); 
        		}
        		break; 
        	case 1: 
        		if(!Validator.daLiJeStringPrazan((String)value)&&Validator.daLiJeStringSamoSlova((String)value))
        		{
        			lista.get(row).setPrezime((String)value);
        		}
        		break;
        	case 2: 
        		if(!Validator.daLiJeStringPrazan((String)value)&&Validator.daLiJeStringSlovaIBrojevi((String)value))
        		{
        			lista.get(row).setDatumRodjenja((Date) value);
        		}
        		break;
        	case 3: 
        		if(!Validator.daLiJeStringPrazan((String)value)&&Validator.daLiJeStringSlovaIBrojevi((String)value))
        		{
        			lista.get(row).setAdresa((String)value);
        		}
        		break;
        	case 4: 
        		if(!Validator.daLiJeStringPrazan((String)value)&&Validator.samoJedanBroj((String)value))
        		{
        			lista.get(row).setKorisnikTipId((Integer)value);
        		}
        		break;
        	case 5: 
        		if(!Validator.daLiJeStringPrazan((String)value)&&Validator.samoJedanBroj((String)value))
        		{
        		lista.get(row).setKorisnikPozicijaId((Integer)value);
        		}
        		break;
        	case 6:
        		if(!Validator.daLiJeStringPrazan((String)value)&&Validator.daLiJeTrueFalse((String)value))
        		{
        		lista.get(row).setAktivan(Boolean.parseBoolean((String)value));
        		}
        		break;

        	
        }
        fireTableCellUpdated(row, col);
        
        
    }


}
