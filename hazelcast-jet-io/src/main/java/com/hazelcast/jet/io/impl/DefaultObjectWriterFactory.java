/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.jet.io.impl;

import com.hazelcast.jet.io.spi.IOContext;
import com.hazelcast.jet.io.spi.DataType;
import com.hazelcast.jet.io.spi.ObjectWriter;
import com.hazelcast.jet.io.spi.ObjectWriterFactory;

public class DefaultObjectWriterFactory implements ObjectWriterFactory {
    private final IOContext ioContext;

    public DefaultObjectWriterFactory(IOContext ioContext) {
        this.ioContext = ioContext;
    }

    @Override
    public DataType getDataType(Object object) {
        return this.ioContext.getDataType(object);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> ObjectWriter<T> getWriter(Object object) {
        return this.ioContext.getDataType(object).getObjectWriter();
    }
}