/*
 * @(#)file      AttributeChangeNotificationFilter.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   4.23
 * @(#)lastedit      03/07/15
 *
 * Copyright 2000-2003 Sun Microsystems, Inc.  All rights reserved.
 * This software is the proprietary information of Sun Microsystems, Inc.
 * Use is subject to license terms.
 * 
 * Copyright 2000-2003 Sun Microsystems, Inc.  Tous droits r�serv�s.
 * Ce logiciel est propriet� de Sun Microsystems, Inc.
 * Distribu� par des licences qui en restreignent l'utilisation. 
 */

package javax.management; 


// java import
import java.util.Enumeration;
import java.util.Vector;


/**
 * This class implements of the {@link javax.management.NotificationFilter NotificationFilter} 
 * interface for the {@link javax.management.AttributeChangeNotification attribute change notification}.
 * The filtering is performed on the name of the observed attribute.
 * <P>
 * It manages a list of enabled attribute names. 
 * A method allows users to enable/disable as many attribute names as required.
 *
 * @since-jdkbundle 1.5
 */
public class AttributeChangeNotificationFilter implements NotificationFilter, java.io.Serializable { 
    
    /* Serial version */
    private static final long serialVersionUID = -6347317584796410029L;

    /**
     * @serial {@link Vector} that contains the enabled attribute names.
     *         The default value is an empty vector.
     */
    private Vector enabledAttributes = new Vector();


    /**
     * Invoked before sending the specified notification to the listener.
     * <BR>This filter compares the attribute name of the specified attribute change notification
     * with each enabled attribute name.
     * If the attribute name equals one of the enabled attribute names,
     * the notification must be sent to the listener and this method returns <CODE>true</CODE>.
     *   
     * @param notification The attribute change notification to be sent.
     * @return <CODE>true</CODE> if the notification has to be sent to the listener, <CODE>false</CODE> otherwise.
     */  
    public synchronized boolean isNotificationEnabled(Notification notification) {
        
        String type = notification.getType();
        
        if ((type == null) || 
            (type.equals(AttributeChangeNotification.ATTRIBUTE_CHANGE) == false) ||
            (!(notification instanceof AttributeChangeNotification))) {
            return false;
        }
        
        String attributeName =
          ((AttributeChangeNotification)notification).getAttributeName();
        return enabledAttributes.contains(attributeName);
    }
    
    /**
     * Enables all the attribute change notifications the attribute name of which equals
     * the specified name to be sent to the listener.
     * <BR>If the specified name is already in the list of enabled attribute names,
     * this method has no effect.
     *   
     * @param name The attribute name.
     * @exception java.lang.IllegalArgumentException The attribute name parameter is null.
     */  
    public synchronized void enableAttribute(String name) throws java.lang.IllegalArgumentException {
        
        if (name == null) {
            throw new java.lang.IllegalArgumentException("The name cannot be null.");
        }
        if (!enabledAttributes.contains(name)) {
            enabledAttributes.addElement(name);
        }
    }
    
    /**
     * Disables all the attribute change notifications the attribute name of which equals 
     * the specified attribute name to be sent to the listener.
     * <BR>If the specified name is not in the list of enabled attribute names,
     * this method has no effect.
     *   
     * @param name The attribute name.
     */  
    public synchronized void disableAttribute(String name) {
        enabledAttributes.removeElement(name);
    }
    
    /**
     * Disables all the attribute names.
     */  
    public synchronized void disableAllAttributes() {
        enabledAttributes.removeAllElements();
    }
    
    /**
     * Gets all the enabled attribute names for this filter.
     *
     * @return The list containing all the enabled attribute names.
     */
    public synchronized Vector getEnabledAttributes() {
        return enabledAttributes;
    }
   
}