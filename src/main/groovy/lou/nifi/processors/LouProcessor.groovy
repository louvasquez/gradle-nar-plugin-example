/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lou.nifi.processors

import org.apache.nifi.components.PropertyDescriptor
import org.apache.nifi.annotation.behavior.ReadsAttribute
import org.apache.nifi.annotation.behavior.ReadsAttributes
import org.apache.nifi.annotation.behavior.WritesAttribute
import org.apache.nifi.annotation.behavior.WritesAttributes
import org.apache.nifi.annotation.lifecycle.OnScheduled
import org.apache.nifi.annotation.documentation.CapabilityDescription
import org.apache.nifi.annotation.documentation.SeeAlso
import org.apache.nifi.annotation.documentation.Tags
import org.apache.nifi.processor.exception.ProcessException
import org.apache.nifi.processor.AbstractProcessor
import org.apache.nifi.processor.ProcessContext
import org.apache.nifi.processor.ProcessSession
import org.apache.nifi.processor.ProcessorInitializationContext
import org.apache.nifi.processor.Relationship
import org.apache.nifi.processor.util.StandardValidators


@Tags(["example"])
@CapabilityDescription("Provide a description")
@SeeAlso([])
@ReadsAttributes([@ReadsAttribute(attribute = "", description = "")])
@WritesAttributes([@WritesAttribute(attribute = "", description = "")])
class LouProcessor extends AbstractProcessor {

    public static final PropertyDescriptor MY_PROPERTY = new PropertyDescriptor.Builder()
            .name("MY_PROPERTY")
            .displayName("My property")
            .description("Example Property")
            .required(true)
            .addValidator(StandardValidators.NON_EMPTY_VALIDATOR)
            .build()

    public static final Relationship MY_RELATIONSHIP = new Relationship.Builder()
            .name("MY_RELATIONSHIP")
            .description("Example relationship")
            .build()

    private List<PropertyDescriptor> descriptors

    private Set relationships

    protected void init(final ProcessorInitializationContext context) {
        final List<PropertyDescriptor> descriptors = new ArrayList<PropertyDescriptor>()
        descriptors.add(MY_PROPERTY)
        this.descriptors = Collections.unmodifiableList(descriptors)

        final Set<Relationship> relationships = new HashSet<Relationship>()
        relationships.add(MY_RELATIONSHIP)
        this.relationships = Collections.unmodifiableSet(relationships)
    }

    @Override
    Set<Relationship> getRelationships() {
        relationships
    }

    @Override
    final List<PropertyDescriptor> getSupportedPropertyDescriptors() {
        descriptors
    }

    @OnScheduled
    void onScheduled(final ProcessContext context) {
    }

    @Override
    void onTrigger(final ProcessContext context, final ProcessSession session) throws ProcessException {
        def flowFile = session.get()
        if (!flowFile) {
            return
        }
	def x = 104
	println x.getClass()
	x = "Guru99"
	println x.getClass()
        // TODO implement
	session.putAttribute(flowFile, 'aip', "my aip")
	session.transfer(flowFile, MY_RELATIONSHIP)

    }
}
