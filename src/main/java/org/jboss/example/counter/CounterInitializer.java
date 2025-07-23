package org.jboss.example.counter;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.ProtoSchema;

@ProtoSchema(
        includeClasses = {
                Counter.class
        }
)
public interface CounterInitializer extends SerializationContextInitializer{
    
}