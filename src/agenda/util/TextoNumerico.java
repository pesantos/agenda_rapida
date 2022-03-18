/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Paulo
 */
public class TextoNumerico extends PlainDocument{

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offs, str.replaceAll("[^0-9]", ""), a); //To change body of generated methods, choose Tools | Templates.
    }
    
}
