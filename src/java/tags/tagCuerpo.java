/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package tags;

import java.io.StringWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author salva
 */
public class tagCuerpo extends SimpleTagSupport {
        StringWriter sw = new StringWriter();    
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        
        try {
            getJspBody().invoke(sw);
            LocalTime time = LocalTime.now(); 
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            
            getJspContext().getOut().println(sw.toString() + "  " + time.format(formatter));
       } catch (java.io.IOException ex) {
            throw new JspException("Error in tagCuerpo tag", ex);
        }
    }
    
}
