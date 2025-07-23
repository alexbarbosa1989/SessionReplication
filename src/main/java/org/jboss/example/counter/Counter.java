/***************************************
 *                                     *
 *  JBoss: The OpenSource J2EE WebOS   *
 *                                     *
 *  Distributable under LGPL license.  *
 *  See terms of license at gnu.org.   *
 *                                     *
 ***************************************/

package org.jboss.example.counter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

/**
 *
 * @author  Stan Silvert (Changelog: adapted for ProtoStream)
 */
public class Counter {
    public static final Logger LOG = LogManager.getLogger(Counter.class);
    
    private int counter = 0;
    
    /**
     * required constructor annotated with @ProtoFactory 
     */
    @ProtoFactory
    public Counter(int value) {
        LOG.info("************************");
        LOG.info("Counter is being created/deserialized with value: " + value);
        LOG.info("************************");
        this.counter = value;
    }

    /* default constructor */
    public Counter() {
        LOG.info("************************");
        LOG.info("Counter is being created");
        LOG.info("************************");
    }
    
    public void increment() {
        this.counter++;
    }
    
    @ProtoField(number = 1, defaultValue = "0")
    public int getValue() {
        return this.counter;
    }

}
